package com.app.recetasEIngredientes.mainMenu.minutas.nuevaMinuta

import androidx.annotation.ColorRes
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.app.recetasEIngredientes.R
import com.app.recetasEIngredientes.constantes.Colores
import com.app.recetasEIngredientes.constantes.Fuentes
import com.app.recetasEIngredientes.mainMenu.Titulo


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NuevaMinutaView(navControllerPrincipal: NavController) {

    Scaffold(
        topBar = { TopBar(navControllerPrincipal) },

        ) { innerPadding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {

            Header()
            Body()

        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Header() {

    var value by remember { mutableStateOf("") }

    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(16.dp)
    ) {
        Text(text = "Nueva minuta: ", fontFamily = Fuentes.REM_LIGHT)
        TextField(
            placeholder = { PlaceholderApp("Nombre de la minuta") },
            value = value, onValueChange = { value = it },
            singleLine = true,

            textStyle = TextStyle(
                fontFamily = Fuentes.REM_LIGHT,
                fontSize = 16.sp,
                color = Colores.GRIS_OSCURO
            ),

        )
    }
}

@Composable
fun Body() {

   Column {

   }
}
    
@Composable
fun PlaceholderApp(value: String) {
    Text(
        text = value,
        fontFamily = Fuentes.REM_LIGHT,
        color = Colores.GRIS,
        fontSize = 16.sp
    )
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

@Composable
fun PantallaVacia() {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
        //.padding(16.dp)
    ) {
        IconButton(
            onClick = { /*TODO*/ },
            modifier = Modifier.size(150.dp)

        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_add),
                contentDescription = "Add",
                tint = Colores.GRIS_TRANSPARENTE,
                modifier = Modifier
                    .size(150.dp)
            )
        }

        Text(
            text = "Agrega una nueva minuta para la semana",
            color = Colores.GRIS_OSCURO,
            fontFamily = Fuentes.REM_LIGHT
        )

    }

}

