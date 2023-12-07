package com.app.recetasEIngredientes.common.componentes

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.app.recetasEIngredientes.constantes.Colores
import com.app.recetasEIngredientes.mainMenu.minutas.listadoMinutas.ListadoMinutasViewModel

@Composable
fun BotonAgregar(
    modifier: Modifier = Modifier,
    color: Color,
    onPress: () -> Unit
) {

    FloatingActionButton(
        containerColor = color,
        contentColor = Colores.BLANCO,
        modifier = modifier.padding(16.dp),
        onClick = { onPress() }
    ) {
        Icon(Icons.Default.Add, contentDescription = "Add")
    }
}