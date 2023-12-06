package com.app.recetasEIngredientes.mainMenu.recetas

import android.widget.Space
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.recetasEIngredientes.R
import com.app.recetasEIngredientes.common.componentes.BotonAgregar
import com.app.recetasEIngredientes.constantes.Colores
import com.app.recetasEIngredientes.constantes.Fuentes

@Composable
fun ListadoRecetasView() {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp)
    ) {

        Buscador()

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


}

@Composable
fun Buscador() {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
    ) {
        Busqueda(Modifier.weight(9f))
        Spacer(modifier = Modifier.width(8.dp))
        Filtro(Modifier.weight(1f))
    }
}

@Preview
@Composable
fun Busqueda(modifier: Modifier = Modifier) {

    var value by rememberSaveable { mutableStateOf("") }

    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .height(50.dp)
            .fillMaxWidth()
    ) {

        TextField(
            value = value,
            onValueChange = { value = it },
            textStyle = TextStyle(
                fontFamily = Fuentes.REM_LIGHT,
                color = Colores.NEGRO,
                fontSize = 16.sp
            ),
            label = null,
            singleLine = true,
            placeholder = { Text(text = "Buscar", fontFamily = Fuentes.REM_LIGHT) },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Colores.ROJO,
                unfocusedBorderColor = Colores.GRIS_OSCURO,
                cursorColor = Colores.GRIS_OSCURO,
                focusedLabelColor = Colores.GRIS_OSCURO,
            ),

            trailingIcon = {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        modifier = Modifier.size(40.dp),
                        tint = Colores.GRIS_OSCURO,
                        painter = painterResource(id = R.drawable.ic_search),
                        contentDescription = "icono de busqueda"
                    )
                }

            },

            modifier = Modifier.fillMaxWidth(),

            )
    }

}

@Composable
fun Filtro(modifier: Modifier = Modifier) {

    IconButton(
        modifier = modifier,
        onClick = { }
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_tune),
            modifier = Modifier.size(40.dp),
            tint = Colores.GRIS_OSCURO,
            contentDescription = "icono de filtro"
        )
    }

}