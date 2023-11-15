package com.app.recetasEIngredientes.mainMenu.minutas.listadoMinutas

import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import com.app.recetasEIngredientes.navegacion.Routes

class ListadoMinutasViewModel(navController: NavController) : ViewModel() {

    val _navController = navController

    fun navigateToNuevaMinuta() {
        _navController.navigate(Routes.NUEVA_MINUTA)
    }

}