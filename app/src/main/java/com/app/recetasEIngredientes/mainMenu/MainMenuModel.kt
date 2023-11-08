package com.app.recetasEIngredientes.mainMenu

import androidx.annotation.DrawableRes
import com.app.recetasEIngredientes.R

class MainMenuModel {

    // estas son las pantallas que se muestran en el menu
    val screens = listOf(
        MenuItem(
            name = "Calendario",
            route = "Calendario",
            iconSelected = R.drawable.ic_calendar_selected,
            iconUnselected = R.drawable.ic_calendar
        ),
        MenuItem(
            name = "Recetas",
            route = "Recetas",
            iconSelected = R.drawable.ic_restaurant_selected,
            iconUnselected = R.drawable.ic_restaurant
        ),
        MenuItem(
            name = "Perfil",
            route = "Perfil",
            iconSelected = R.drawable.ic_account_selected,
            iconUnselected = R.drawable.ic_account
        )
    )


}

// listado de items del menu
data class MenuItem(
    val name: String,
    val route: String,
    @DrawableRes val iconSelected: Int,
    @DrawableRes val iconUnselected: Int
) {}