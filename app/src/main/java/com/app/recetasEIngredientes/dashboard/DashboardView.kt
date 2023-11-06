package com.app.recetasEIngredientes.dashboard

import android.graphics.Color
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
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.app.recetasEIngredientes.R
import com.app.recetasEIngredientes.constantes.Colores
import com.app.recetasEIngredientes.constantes.Fuentes

@Composable
fun DashboardView() {
    ScaffoldDashbard()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScaffoldDashbard() {

    Scaffold(
        topBar = { TopBar() },
        bottomBar = { BottomBar() },
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
fun BottomBar() {

    BottomAppBar(
        containerColor = Colores.ROJO,
        contentColor = Colores.BLANCO,
    ) {
        Row(modifier = Modifier.padding(2.dp)) {

            MenuItem("Inicio", Modifier.weight(1f)) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_calendar),
                    contentDescription = "icono de semana",
                    tint = Colores.BLANCO,
                    modifier = Modifier.size(30.dp)
                )
            }

            MenuItem("Recetas", Modifier.weight(1f)){
                Icon(
                    painter = painterResource(id = R.drawable.ic_restaurant),
                    contentDescription = "icono de semana",
                    tint = Colores.BLANCO,
                    modifier = Modifier.size(30.dp)
                )
            }

            MenuItem("Perfil", Modifier.weight(1f)){
                Icon(
                    painter = painterResource(id = R.drawable.ic_account),
                    contentDescription = "icono de semana",
                    tint = Colores.BLANCO,
                    modifier = Modifier.size(30.dp)
                )
            }
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