package com.app.recetasEIngredientes.mainMenu

import androidx.lifecycle.ViewModel
import androidx.navigation.NavController

class MainMenuViewModel(navController: NavController) : ViewModel() {

    val mainMenuModel = MainMenuModel()

    val screens = mainMenuModel.screens

}