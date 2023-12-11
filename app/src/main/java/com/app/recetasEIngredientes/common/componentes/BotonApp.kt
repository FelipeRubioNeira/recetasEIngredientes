package com.app.recetasEIngredientes.common.componentes

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.recetasEIngredientes.constantes.Colores
import com.app.recetasEIngredientes.constantes.Fuentes

@Preview(showSystemUi = true)
@Composable
fun BotonApp(
    value: String = "Inserte propiedad value",
    onPress: (() -> Unit)? = null
) {

    Button(
        colors = ButtonDefaults.buttonColors(
            containerColor = Colores.ROJO,
            contentColor = Colores.BLANCO
        ),
        onClick = { onPress?.invoke() },
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)


    ) {
        TextoBoton(text = value)
    }

}

@Composable
fun TextoBoton(text: String) {
    Text(
        text = text,
        color = Colores.BLANCO,
        fontFamily = Fuentes.REM_BOLD,
        fontSize = 18.sp
    )
}
