package com.app.recetasEIngredientes.mainMenu.calentario

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.app.recetasEIngredientes.constantes.Colores

@Composable
fun CalendarioView() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Red)
    ) {
        Text(text = "CalendarioView", color = Colores.BLANCO)
    }
}