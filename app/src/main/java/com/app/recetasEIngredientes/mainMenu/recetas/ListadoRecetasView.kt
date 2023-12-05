package com.app.recetasEIngredientes.mainMenu.recetas

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.app.recetasEIngredientes.R
import com.app.recetasEIngredientes.common.componentes.BotonAgregar
import com.app.recetasEIngredientes.constantes.Colores

@Composable
fun ListadoRecetasView() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {

        ListadoRecetas()

        BotonAgregar(
            modifier = Modifier.align(alignment = Alignment.BottomEnd),
            color = Colores.AZUL,
            onPress = { }
        )
    }
}

@Composable
fun ListadoRecetas() {

    Buscador()

}

@Composable
fun Buscador() {

    Row() {
        Busqueda()
        Filtro()
    }
}

@Preview
@Composable
fun Busqueda() {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
            .border(1.dp, Colores.GRIS_OSCURO, shape = RoundedCornerShape(8.dp))
    ) {
        TextField(value = "", onValueChange = {})

        //BotonBuscar(onPress = {})
    }

}

@Composable
fun BotonBuscar(
    onPress: () -> Unit = {}
) {
    IconButton(onClick = { onPress() }) {
        Icon(
            modifier = Modifier.size(40.dp),
            tint = Colores.GRIS_OSCURO,
            painter = painterResource(id = R.drawable.search_ic),
            contentDescription = "icono de busqueda"
        )
    }
}

@Composable
fun Filtro() {

}