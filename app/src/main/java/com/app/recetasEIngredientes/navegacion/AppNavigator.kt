package com.app.recetasEIngredientes.navegacion

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.app.recetasEIngredientes.createAccount.CreateAccountView
import com.app.recetasEIngredientes.login.LoginView
import com.app.recetasEIngredientes.mainMenu.MainMenuView
import com.app.recetasEIngredientes.mainMenu.minutas.listadoMinutas.ListadoMinutasViewModel
import com.app.recetasEIngredientes.mainMenu.minutas.nuevaMinuta.NuevaMinutaView
import com.app.recetasEIngredientes.mainMenu.minutas.nuevaMinuta.NuevaMinutaViewModel
import com.app.recetasEIngredientes.mainMenu.perfil.PerfilViewModel
import com.app.recetasEIngredientes.mainMenu.recetas.listadoRecetas.ListadoRecetasViewModel
import com.app.recetasEIngredientes.mainMenu.recetas.nuevaReceta.NuevaReceta
import com.app.recetasEIngredientes.mainMenu.recetas.nuevaReceta.NuevaRecetaViewModel


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun AppNavigator() {


    val navControllerPrincipal = rememberNavController()


    // --------------------- view models ---------------------

    // view model para el listado de recetas
    val listadoRecetasVM = ListadoRecetasViewModel(navControllerPrincipal)

    // view model para la pantalla de nueva receta o editar receta
    val nuevaRecetaVM = NuevaRecetaViewModel(navControllerPrincipal, listadoRecetasVM)


    // view model para el listado de minutas
    val listadoMinutasVM = ListadoMinutasViewModel(navControllerPrincipal)

    // view model para la pantalla de nueva minuta o editar minuta
    val nuevaMinutasVM = NuevaMinutaViewModel(
        navControllerPrincipal,
        listadoMinutasVM,
        listadoRecetasVM
    )

    val perfilVM = PerfilViewModel()


    // --------------------- navegacion principal ---------------------
    NavHost(
        navController = navControllerPrincipal,
        startDestination = Routes.MenuPrincipal.ruta
    ) {

        // pantalla de login
        composable(Routes.Login.ruta) {
            LoginView(navControllerPrincipal)
        }

        // pantalla de crear cuenta
        composable(Routes.CreateAccount.ruta) {
            CreateAccountView(navControllerPrincipal)
        }

        // pantalla de menu principal que contiene un navegador
        composable(Routes.MenuPrincipal.ruta) {
            MainMenuView(
                navControllerPrincipal,
                listadoMinutasVM,
                listadoRecetasVM,
                perfilVM
            )
        }

        // del menu principal podemos navegar a las minutas
        composable(
            Routes.NuevaMinuta.ruta,
            arguments = listOf(navArgument("minutaId") { type = NavType.IntType })
        ) {
            NuevaMinutaView(nuevaMinutasVM, it.arguments?.getInt("minutaId"))
        }

        composable(
            Routes.NuevaReceta.ruta,
            arguments = listOf(navArgument("recetaId") { type = NavType.IntType })
        ) {
            NuevaReceta(nuevaRecetaVM, it.arguments?.getInt("recetaId"))
        }


    }
}
