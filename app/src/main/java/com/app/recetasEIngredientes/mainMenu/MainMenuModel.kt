package com.app.recetasEIngredientes.mainMenu

import androidx.annotation.DrawableRes
import com.app.recetasEIngredientes.R
import com.app.recetasEIngredientes.navegacion.Routes

class MainMenuModel {

    // listado de pantallas
    val itemsMenu = listOf(
        MenuItem.Recetas,
        MenuItem.ListadoMinutas,
        MenuItem.Perfil
    )

}

// listado de items del menu
sealed class MenuItem(
    val name: String,
    val route: String,
    @DrawableRes val iconSelected: Int,
    @DrawableRes val iconUnselected: Int
) {

    object Recetas : MenuItem(
        name = "Recetas",
        route = Routes.ListadoRecetas.ruta,
        iconSelected = R.drawable.ic_restaurant_selected,
        iconUnselected = R.drawable.ic_restaurant
    )

    object ListadoMinutas : MenuItem(
        name = "Minutas",
        route = Routes.ListadoMinutas.ruta,
        iconSelected = R.drawable.ic_calendar_selected,
        iconUnselected = R.drawable.ic_calendar
    )

    object Perfil : MenuItem(
        name = "Perfil",
        route = Routes.Perfil.ruta,
        iconSelected = R.drawable.ic_account_selected,
        iconUnselected = R.drawable.ic_account
    )
}