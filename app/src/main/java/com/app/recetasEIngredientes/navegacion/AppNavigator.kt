package com.app.recetasEIngredientes.navegacion

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.app.recetasEIngredientes.createAccount.CreateAccountView
import com.app.recetasEIngredientes.login.LoginView
import com.app.recetasEIngredientes.mainMenu.MainMenuView
import com.app.recetasEIngredientes.mainMenu.minutas.nuevaMinuta.NuevaMinutaView


@Composable
fun AppNavigator() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Routes.MENU_PRINCIPAL
    ) {

        // pantalla de login
        composable(Routes.LOGIN) {
            LoginView(navController)
        }

        // pantalla de crear cuenta
        composable(Routes.CREATE_ACCOUNT) {
            CreateAccountView(navController)
        }

        // pantalla de menu principal que contiene un navegador
        composable(Routes.MENU_PRINCIPAL) {
            MainMenuView()
        }


    }
}
