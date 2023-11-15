package com.app.recetasEIngredientes.mainMenu.minutas.listadoMinutas

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.BottomEnd
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.app.recetasEIngredientes.constantes.Colores
import com.app.recetasEIngredientes.mainMenu.minutas.listadoMinutas.ListadoMinutasViewModel
import com.app.recetasEIngredientes.navegacion.Routes


@Composable
fun ListadoMinutasView(navController: NavController) {

    //val listadoMinutasViewModel = ListadoMinutasViewModel(navHostController)

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Text(text = "Listado Minutas", color = Colores.AZUL)
        BotonAgregarMinuta(navController, Modifier.align(alignment = BottomEnd))
    }
}

@Composable
fun BotonAgregarMinuta(
    navController: NavController,
    modifier: Modifier,
) {

    FloatingActionButton(
        containerColor = Colores.ROJO,
        contentColor = Colores.BLANCO,
        modifier = modifier.padding(16.dp),
        onClick = {
            navController.navigate(Routes.NUEVA_MINUTA)
        }
    ) {
        Icon(Icons.Default.Add, contentDescription = "Add")
    }
}
