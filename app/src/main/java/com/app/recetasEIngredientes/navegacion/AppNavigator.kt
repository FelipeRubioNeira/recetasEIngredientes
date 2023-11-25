package com.app.recetasEIngredientes.navegacion

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.app.recetasEIngredientes.createAccount.CreateAccountView
import com.app.recetasEIngredientes.login.LoginView
import com.app.recetasEIngredientes.mainMenu.MainMenuView
import com.app.recetasEIngredientes.mainMenu.minutas.listadoMinutas.ListadoMinutasViewModel
import com.app.recetasEIngredientes.mainMenu.minutas.nuevaMinuta.NuevaMinutaView
import com.app.recetasEIngredientes.mainMenu.minutas.nuevaMinuta.NuevaMinutaViewModel


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun AppNavigator() {

    val navControllerPrincipal = rememberNavController()

    // recive el nav controller principal para poder navegar entre las pantallas del stack
    val listadoMinutasVM = ListadoMinutasViewModel(navControllerPrincipal)

    val nuevaMinutasVM = NuevaMinutaViewModel(
        navControllerPrincipal,
        listadoMinutasVM,
    )


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
            MainMenuView(
                navControllerPrincipal,
                listadoMinutasVM,
            )
        }

        // del menu principal podemos navegar a las minutas
        composable(Routes.NUEVA_MINUTA) {
            NuevaMinutaView(nuevaMinutasVM)
        }


    }
}
