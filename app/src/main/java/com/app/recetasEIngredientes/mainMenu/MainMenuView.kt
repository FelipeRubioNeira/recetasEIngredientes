package com.app.recetasEIngredientes.mainMenu

import MainMenuNavigator
import android.util.Log
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
import com.app.recetasEIngredientes.mainMenu.minutas.listadoMinutas.ListadoMinutasViewModel
import com.app.recetasEIngredientes.mainMenu.recetas.ListadoRecetasViewModel

/*
* NAV CONTROLLER PRINCIPAL SE ENCARGA DE NAVEGAR EN EL STACK
* NAV CONTROLLER MENU SE ENCARGA DE NAVEGAR ENTRE LAS 3 PANTALLAS DEL MENU */

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainMenuView(
    navControllerStack: NavController,
    listadoMinutasVM: ListadoMinutasViewModel,
    listadoRecetasVM: ListadoRecetasViewModel,
) {

    //  controller del menu de los iconos de abajo
    val navControllerBotom = rememberNavController()
    val mainMenuViewModel = MainMenuViewModel(navControllerBotom)

    Scaffold(

        topBar = { TopBar(mainMenuViewModel) },
        bottomBar = {
            ButtonNavigationBar(
                mainMenuViewModel,
                navControllerBotom
            )
        },

        ) { innerPadding -> // padding del button navigation bar y del header de la pantalla

        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {
            MainMenuNavigator(
                navControllerBotom,
                listadoMinutasVM,
                listadoRecetasVM
            )
        }

    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(mainMenuViewModel: MainMenuViewModel) {

    TopAppBar(
        title = { Titulo("Bienvenido") },
        navigationIcon = {
            IconoGoBack(mainMenuViewModel)
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
        onClick = { mainMenuViewModel.goBack() }
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
fun ButtonNavigationBar(
    mainMenuViewModel: MainMenuViewModel,
    navControllerMenu: NavController,
) {

    // segun el index, se marca un icono u otro
    val selectedIndex: Int by mainMenuViewModel.selectedIndex.observeAsState(initial = 0)

    // lista de pantallas que se muestran en el button navigation bar
    val screens = mainMenuViewModel.itemsMenu

    val navBackStackEntry by navControllerMenu.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    NavigationBar(
        containerColor = Colores.ROJO,
    ) {
        screens.forEachIndexed() { index, screen ->

            NavigationBarItem(
                selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true,
                onClick = {
                    navControllerMenu.navigate(screen.route) {
                        popUpTo(navControllerMenu.graph.findStartDestination().id) {
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
