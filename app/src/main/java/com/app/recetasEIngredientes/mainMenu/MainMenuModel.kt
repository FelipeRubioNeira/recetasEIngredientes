package com.app.recetasEIngredientes.mainMenu

import androidx.annotation.DrawableRes
import com.app.recetasEIngredientes.R
import com.app.recetasEIngredientes.navegacion.Routes

class MainMenuModel {

    // listado de pantallas
    val itemsMenu = listOf(
        MenuItem.Minutas,
        MenuItem.Recetas,
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
    object Minutas : MenuItem(
        name = "Minutas",
        route = Routes.MINUTAS_NAVIGATOR,
        iconSelected = R.drawable.ic_calendar_selected,
        iconUnselected = R.drawable.ic_calendar
    )

    object Recetas : MenuItem(
        name = "Recetas",
        route = Routes.RECETAS,
        iconSelected = R.drawable.ic_restaurant_selected,
        iconUnselected = R.drawable.ic_restaurant
    )

    object Perfil : MenuItem(
        name = "Perfil",
        route = Routes.PERFIL,
        iconSelected = R.drawable.ic_account_selected,
        iconUnselected = R.drawable.ic_account
    )
}