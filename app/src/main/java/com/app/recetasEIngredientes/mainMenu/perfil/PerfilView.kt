package com.app.recetasEIngredientes.mainMenu.perfil

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun PerfilView() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Green)
    ){
        Text(text = "PerfilView", color = Color.White)
    }
}
