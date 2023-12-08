package com.app.recetasEIngredientes.mainMenu.recetas

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.recetasEIngredientes.R
import com.app.recetasEIngredientes.constantes.Colores
import com.app.recetasEIngredientes.constantes.Fuentes

@Composable
fun Modal(
    title: String = "Modal",
    modalVisible: Boolean = true,
    cerrarModal: () -> Unit = {},
    body: @Composable () -> Unit = {},
) {

    if (!modalVisible) return

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
    ) {

        Column(
            modifier = Modifier
                .fillMaxHeight(0.9f)
                .fillMaxWidth(0.8f)
                .border(
                    width = 1.dp,
                    color = Colores.GRIS_OSCURO,
                    shape = RoundedCornerShape(10.dp)
                )

        ) {

            Header(title, cerrarModal = cerrarModal)
            Body(Modifier.weight(10f), body)
            BotonAceptar()
        }

    }
}

@Composable
fun Header(
    title: String,
    cerrarModal: () -> Unit
) {
    Row(

        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .clip(RoundedCornerShape(topStart = 10.dp, topEnd = 10.dp))
            .fillMaxWidth()
            .height(50.dp)
            .background(Colores.ROJO)
    ) {
        Text(
            text = title,
            color = Colores.BLANCO,
            fontSize = 20.sp,
            fontFamily = Fuentes.REM_MEDIUM,
            modifier = Modifier.padding(horizontal = 16.dp)
        )

        IconButton(onClick = cerrarModal, modifier = Modifier.padding(horizontal = 0.dp)) {
            Icon(
                painter = painterResource(id = R.drawable.ic_close),
                contentDescription = "close modal",
                tint = Colores.BLANCO,
                modifier = Modifier.size(30.dp)
            )
        }

    }
}

@Composable
fun Body(modifier: Modifier, body: @Composable () -> Unit) {

    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
    ) {
        body()
    }

}

@Composable
fun BotonAceptar(onPress: () -> Unit = {}) {

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
            .clip(shape = RoundedCornerShape(bottomStart = 10.dp, bottomEnd = 10.dp))
            .background(Colores.ROJO)

    ) {
        TextButton(onClick = onPress) {
            Text(
                text = "Aceptar",
                fontFamily = Fuentes.REM_MEDIUM,
                fontSize = 18.sp,
                color = Colores.BLANCO,
            )
        }
    }
}