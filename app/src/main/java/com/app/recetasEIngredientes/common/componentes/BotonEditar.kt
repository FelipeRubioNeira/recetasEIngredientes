package com.app.recetasEIngredientes.common.componentes

import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.app.recetasEIngredientes.R
import com.app.recetasEIngredientes.constantes.Colores

@Composable
fun BotonEditar(onClick: () -> Unit, color: Color = Colores.BLANCO) {

    IconButton(onClick = onClick) {
        Icon(
            painter = painterResource(id = R.drawable.ic_edit),
            contentDescription = "delete",
            tint = color,
            modifier = Modifier.size(54.dp)
        )
    }

}