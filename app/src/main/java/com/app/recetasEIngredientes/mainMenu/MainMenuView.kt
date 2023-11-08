package com.app.recetasEIngredientes.mainMenu

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.app.recetasEIngredientes.constantes.Colores
import com.app.recetasEIngredientes.constantes.Fuentes
import com.app.recetasEIngredientes.navegacion.MainMenuScreens

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainMenuView(navController: NavController) {

    val mainMenuViewModel = MainMenuViewModel(navController)

    Scaffold(
        topBar = { TopBar() },
        bottomBar = { ButtonNavigationBar(mainMenuViewModel) },
        floatingActionButton = { BotonAgregar() }

    ) { innerPadding ->

        Body(innerPadding)

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
fun Body(innerPadding: PaddingValues) {
    Column(
        modifier = Modifier.padding(innerPadding),
        //verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {

    }
}

@Composable
fun ButtonNavigationBar(mainMenuViewModel: MainMenuViewModel) {

    var selectedIndex by rememberSaveable { mutableStateOf(0) }
    val screens = mainMenuViewModel.screens

    NavigationBar {
        screens.forEachIndexed() { index, screen ->
            NavigationBarItem(
                selected = selectedIndex == index,
                onClick = { selectedIndex = index },
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
                        tint = Colores.ROJO,
                        modifier = Modifier.size(30.dp)
                    )
                },

                label = { Text(text = screen.name, fontFamily = Fuentes.REM_LIGHT) },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Colores.BLANCO,
                    unselectedIconColor = Colores.GRIS_TRANSPARENTE
                ),

                )
        }
    }

}

fun NavigationItem() {

}

@Composable
fun BottomBar(navController: NavController) {

    val items = listOf(
        MainMenuScreens.Calendario,
        MainMenuScreens.Recetas,
        MainMenuScreens.Perfil
    )

    BottomAppBar(
        containerColor = Colores.ROJO,
        contentColor = Colores.BLANCO,
    ) {
        Row(modifier = Modifier.padding(2.dp)) {

            items.forEach { screen ->
                MenuItem(screen.name, Modifier.weight(1f)) {
                    Icon(
                        painter = painterResource(id = screen.resourceId),
                        contentDescription = "icono de semana",
                        tint = Colores.BLANCO,
                        modifier = Modifier.size(30.dp)
                    )
                }
            }

//            MenuItem("Calendario", Modifier.weight(1f)) {
//                Icon(
//                    painter = painterResource(id = R.drawable.ic_calendar),
//                    contentDescription = "icono de semana",
//                    tint = Colores.BLANCO,
//                    modifier = Modifier.size(30.dp)
//                )
//            }
//
//            MenuItem("Recetas", Modifier.weight(1f)){
//                Icon(
//                    painter = painterResource(id = R.drawable.ic_restaurant),
//                    contentDescription = "icono de semana",
//                    tint = Colores.BLANCO,
//                    modifier = Modifier.size(30.dp)
//                )
//            }
//
//            MenuItem("Perfil", Modifier.weight(1f)){
//                Icon(
//                    painter = painterResource(id = R.drawable.ic_account),
//                    contentDescription = "icono de semana",
//                    tint = Colores.BLANCO,
//                    modifier = Modifier.size(30.dp)
//                )
//            }
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