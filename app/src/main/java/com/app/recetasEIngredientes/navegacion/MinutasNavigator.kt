package com.app.recetasEIngredientes.navegacion

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.app.recetasEIngredientes.mainMenu.minutas.listadoMinutas.ListadoMinutasView
import com.app.recetasEIngredientes.mainMenu.minutas.nuevaMinuta.NuevaMinutaView

@Composable
fun MinutasNavigator() {

    val navController = rememberNavController()

    NavHost(
        route = Routes.MINUTAS_NAVIGATOR,
        navController = navController,
        startDestination = Routes.LISTADO_MINUTAS
    ) {

        composable(Routes.LISTADO_MINUTAS) {
            ListadoMinutasView(navController)
        }

        composable(Routes.NUEVA_MINUTA) {
            NuevaMinutaView(navController)
        }

    }
}