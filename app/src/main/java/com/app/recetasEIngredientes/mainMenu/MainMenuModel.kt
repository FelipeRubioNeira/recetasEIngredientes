package com.app.recetasEIngredientes.mainMenu

import androidx.annotation.DrawableRes
import com.app.recetasEIngredientes.R

class MainMenuModel {

    // listado de pantallas
    val itemsMenu = listOf(
        MenuItem.Calendario,
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
    object Calendario : MenuItem(
        name = "Calendario",
        route = "Calendario",
        iconSelected = R.drawable.ic_calendar_selected,
        iconUnselected = R.drawable.ic_calendar
    )

    object Recetas : MenuItem(
        name = "Recetas",
        route = "Recetas",
        iconSelected = R.drawable.ic_restaurant_selected,
        iconUnselected = R.drawable.ic_restaurant
    )

    object Perfil : MenuItem(
        name = "Perfil",
        route = "Perfil",
        iconSelected = R.drawable.ic_account_selected,
        iconUnselected = R.drawable.ic_account
    )
}