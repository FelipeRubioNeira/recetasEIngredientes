package com.app.recetasEIngredientes.navegacion

import androidx.annotation.DrawableRes
import com.app.recetasEIngredientes.R

sealed class MainMenuScreens(val route: String, val name: String, @DrawableRes val resourceId: Int = 0) {
    object Calendario : MainMenuScreens("Calendario", "Calendario", R.drawable.ic_calendar)
    object Recetas : MainMenuScreens("Recetas", "Recetas", R.drawable.ic_restaurant)
    object Perfil : MainMenuScreens("Perfil", "Recetas", R.drawable.ic_account)

}
