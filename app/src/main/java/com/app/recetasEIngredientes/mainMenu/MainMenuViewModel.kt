package com.app.recetasEIngredientes.mainMenu

import androidx.compose.runtime.getValue
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState

class MainMenuViewModel(navController: NavController) : ViewModel() {

    val mainMenuModel = MainMenuModel()
    val _navController = navController

    // listado de pantallas que recibimos desde el model
    val itemsMenu = mainMenuModel.itemsMenu

    val _selectedIndex = MutableLiveData(0)
    val selectedIndex = _selectedIndex

    val _barraNavegacionInferiorVisible = MutableLiveData(true)
    val barraNavegacionInferiorVisible = _barraNavegacionInferiorVisible

    fun goBack() {
        _navController.popBackStack()
    }

    fun ocultarBarraNavegacionInferior() {
        _barraNavegacionInferiorVisible.value = false
    }
    fun mostrarBarraNavegacionInferior() {
        _barraNavegacionInferiorVisible.value = true
    }

}