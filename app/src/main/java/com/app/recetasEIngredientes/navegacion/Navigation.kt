package com.app.recetasEIngredientes.navegacion

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import com.app.recetasEIngredientes.createAccount.CreateAccountView
import com.app.recetasEIngredientes.login.LoginView
import com.app.recetasEIngredientes.mainMenu.MainMenuView
import com.app.recetasEIngredientes.mainMenu.calentario.CalendarioView
import com.app.recetasEIngredientes.mainMenu.perfil.PerfilView
import com.app.recetasEIngredientes.mainMenu.recetas.RecetasView


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

        menuPrincipal(navController)

    }
}

fun NavGraphBuilder.menuPrincipal(navController: NavController) {

    navigation(
        route = Routes.NAVEGATOR_MENU_PRINCIPAL, // ahora el menu principal es un navegador
        startDestination = Routes.MENU_PRINCIPAL,
    ) {

        composable(Routes.MENU_PRINCIPAL) {
            MainMenuView(navController)
        }

        composable(Routes.CALENDARIO) {
            CalendarioView()
        }

        composable(Routes.RECETAS) {
            RecetasView()
        }

        composable(Routes.PERFIL) {
            PerfilView()
        }

        composable(Routes.CALENDARIO) {
            PerfilView()
        }

    }
}
