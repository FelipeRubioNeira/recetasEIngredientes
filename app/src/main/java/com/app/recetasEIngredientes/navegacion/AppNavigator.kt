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

    val navControllerPrincipal = rememberNavController()

    NavHost(
        navController = navControllerPrincipal,
        startDestination = Routes.MENU_PRINCIPAL
    ) {

        // pantalla de login
        composable(Routes.LOGIN) {
            LoginView(navControllerPrincipal)
        }

        // pantalla de crear cuenta
        composable(Routes.CREATE_ACCOUNT) {
            CreateAccountView(navControllerPrincipal)
        }

        // pantalla de menu principal que contiene un navegador
        composable(Routes.MENU_PRINCIPAL) {
            MainMenuView(navControllerPrincipal)
        }

        // del menu principal podemos navegar a las minutas
        composable(Routes.NUEVA_MINUTA) {
            NuevaMinutaView(navControllerPrincipal)
        }


    }
}
