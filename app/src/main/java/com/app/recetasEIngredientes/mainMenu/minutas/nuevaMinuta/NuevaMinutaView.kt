package com.app.recetasEIngredientes.mainMenu.minutas.nuevaMinuta

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.app.recetasEIngredientes.constantes.Colores
import com.app.recetasEIngredientes.mainMenu.ButtonNavigationBar
import com.app.recetasEIngredientes.mainMenu.IconoGoBack
import com.app.recetasEIngredientes.mainMenu.MainMenuViewModel
import com.app.recetasEIngredientes.mainMenu.Titulo
import com.app.recetasEIngredientes.mainMenu.TopBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NuevaMinutaView(navControllerPrincipal: NavController) {


    Scaffold(
        topBar = { TopBar(navControllerPrincipal) },

        ) { innerPadding ->

        Column(modifier = Modifier.padding(innerPadding)) {

        }


    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(navControllerPrincipal: NavController) {

    TopAppBar(
        title = { Titulo("Nueva minuta") },
        navigationIcon = { IconoGoBack(navControllerPrincipal) },
        colors = TopAppBarDefaults.smallTopAppBarColors(
            containerColor = Colores.ROJO,
            titleContentColor = Colores.BLANCO,
        )
    )
}

@Composable
fun IconoGoBack(navController: NavController) {

    IconButton(
        modifier = Modifier,
        onClick = { navController.popBackStack() }
    ) {
        Icon(
            imageVector = Icons.Default.ArrowBack,
            contentDescription = "back",
            tint = Colores.BLANCO
        )
    }
}

