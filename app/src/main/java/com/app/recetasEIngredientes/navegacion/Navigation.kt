package com.app.recetasEIngredientes.navegacion

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.app.recetasEIngredientes.createAccount.CreateAccountView
import com.app.recetasEIngredientes.dashboard.DashboardView
import com.app.recetasEIngredientes.login.LoginView

@Composable
fun Navigation() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Routes.LOGIN

    ) {

        // pantalla de login
        composable(Routes.LOGIN) {
            LoginView(navController)
        }

        // pantalla de crear cuenta
        composable(Routes.CREATE_ACCOUNT) {
            CreateAccountView(navController)
        }

        // pantalla principal del usuario (en un futuro puede ser otro navegador)
        composable(Routes.DASHBOARD) {
             DashboardView()
        }



    }
}