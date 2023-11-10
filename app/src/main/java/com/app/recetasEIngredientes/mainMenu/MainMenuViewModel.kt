package com.app.recetasEIngredientes.mainMenu

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination

class MainMenuViewModel(val navController: NavController) : ViewModel() {

    val mainMenuModel = MainMenuModel()

    // listado de pantallas que recibimos desde el model
    val itemsMenu = mainMenuModel.itemsMenu

    val _selectedIndex = MutableLiveData(0)
    val selectedIndex = _selectedIndex

    fun setSelectedIndex(index: Int) {
        _selectedIndex.value = index
    }

    fun navigate(rounte: String) {
        navController.navigate(rounte) {
            popUpTo(navController.graph.findStartDestination().id) {
                saveState = true
            }
            launchSingleTop = true
            restoreState = true
        }

    }

}