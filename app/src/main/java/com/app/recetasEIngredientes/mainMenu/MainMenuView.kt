package com.app.recetasEIngredientes.mainMenu

import MainMenuNavigator
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.app.recetasEIngredientes.constantes.Colores
import com.app.recetasEIngredientes.constantes.Fuentes


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainMenuView() {

    val navController = rememberNavController()
    val mainMenuViewModel = MainMenuViewModel(navController)
    val mostrarBarraNavegacionInferior: Boolean by mainMenuViewModel.barraNavegacionInferiorVisible.observeAsState(initial = true)

    Scaffold(

        topBar = { TopBar(mainMenuViewModel, mostrarBarraNavegacionInferior) },
        bottomBar = {
            if (mostrarBarraNavegacionInferior) ButtonNavigationBar(
                mainMenuViewModel,
                navController
            )
        },

        ) { innerPadding -> // padding del button navigation bar y del header de la pantalla

        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {

            MainMenuNavigator(navController)

        }

    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(mainMenuViewModel: MainMenuViewModel, mostrarBarraNavegacionInferior: Boolean) {

    TopAppBar(
        title = { Titulo("Bienvenido") },
        navigationIcon = {
            if (!mostrarBarraNavegacionInferior) IconoGoBack(mainMenuViewModel)
        },
        colors = TopAppBarDefaults.smallTopAppBarColors(
            containerColor = Colores.ROJO,
            titleContentColor = Colores.BLANCO,
        )
    )
}

@Composable
fun IconoGoBack(mainMenuViewModel: MainMenuViewModel) {

    IconButton(
        modifier = Modifier,
        onClick = {
            //lo que deseamos es navegar hacia atras

            mainMenuViewModel.goBack()
            mainMenuViewModel.mostrarBarraNavegacionInferior()
        }
    ) {
        Icon(
            imageVector = Icons.Default.ArrowBack,
            contentDescription = "back",
            tint = Colores.BLANCO
        )
    }
}

@Composable
fun Titulo(titulo: String = "") {
    Text(
        text = titulo,
        textAlign = TextAlign.Center,
        fontFamily = Fuentes.REM_MEDIUM
    )
}

@Composable
fun ButtonNavigationBar(mainMenuViewModel: MainMenuViewModel, navController: NavController) {

    val selectedIndex: Int by mainMenuViewModel.selectedIndex.observeAsState(initial = 0)
    val screens = mainMenuViewModel.itemsMenu

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    NavigationBar(
        containerColor = Colores.ROJO,
    ) {
        screens.forEachIndexed() { index, screen ->

            NavigationBarItem(
                selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true,
                onClick = {
                    navController.navigate(screen.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                label = { Text(text = screen.name, fontFamily = Fuentes.REM_LIGHT) },
                icon = {
                    Icon(
                        painter = painterResource(
                            id = if (selectedIndex == index) {
                                screen.iconSelected
                            } else {
                                screen.iconUnselected
                            }
                        ),
                        contentDescription = "icono de semana",
                        modifier = Modifier.size(30.dp),
                    )
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Colores.BLANCO,
                    unselectedIconColor = Colores.GRIS_TRANSPARENTE,
                    selectedTextColor = Colores.BLANCO,
                    unselectedTextColor = Colores.GRIS_TRANSPARENTE,
                    indicatorColor = Colores.ROJO_OSCURO
                )
            )
        }
    }
}
