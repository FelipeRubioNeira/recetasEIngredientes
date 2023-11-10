package com.app.recetasEIngredientes.mainMenu

import NavigatorMainMenu
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.app.recetasEIngredientes.constantes.Colores
import com.app.recetasEIngredientes.constantes.Fuentes

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainMenuView(navController: NavController) {

    val navController = rememberNavController()
    val mainMenuViewModel = MainMenuViewModel(navController)

    Scaffold(
        topBar = { TopBar() },
        bottomBar = { ButtonNavigationBar(mainMenuViewModel, navController) },
        floatingActionButton = { BotonAgregar() }

    ) { innerPadding -> // padding del button navigation bar y del header de la pantalla

        Body(innerPadding) {
            NavigatorMainMenu(navController)
        }

    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar() {

    TopAppBar(
        colors = TopAppBarDefaults.smallTopAppBarColors(
            containerColor = Colores.ROJO,
            titleContentColor = Colores.BLANCO,
        ),
        title = { Titulo("Bienvenido") }
    )
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
fun Body(innerPadding: PaddingValues, body: @Composable () -> Unit) {

    Column(
        modifier = Modifier.padding(innerPadding),
        //verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        body()
    }
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
                onClick = { navController.navigate(screen.route) },

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

@Composable
fun BotonAgregar() {
    FloatingActionButton(
        containerColor = Colores.ROJO,
        contentColor = Colores.BLANCO,
        onClick = { }
    ) {
        Icon(Icons.Default.Add, contentDescription = "Add")
    }
}

@Composable
fun MenuItem(value: String, modifier: Modifier, icon: @Composable () -> Unit = {}) {

    TextButton(
        onClick = { /*TODO*/ },
        modifier = modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(2.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            // icono opcional que puede venir en el menu
            icon()
            Text(text = value, color = Colores.BLANCO, fontFamily = Fuentes.REM_LIGHT)
        }
    }
}