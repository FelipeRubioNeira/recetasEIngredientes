package com.app.recetasEIngredientes.mainMenu.recetas.nuevaReceta

import androidx.lifecycle.ViewModel
import androidx.navigation.NavController

class NuevaRecetaViewModel(val appNavigator: NavController) : ViewModel() {


    fun goBack() {
        appNavigator.popBackStack()
    }

    fun navigateTo(route: String) {
        appNavigator.navigate(route)
    }
}