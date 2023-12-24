package com.app.recetasEIngredientes.mainMenu.perfil

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.recetasEIngredientes.common.componentes.BotonEditar
import com.app.recetasEIngredientes.constantes.Colores
import com.app.recetasEIngredientes.constantes.Fuentes
import retrofit2.http.Body

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PerfilView() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Colores.BLANCO)

    ) {

        HeaderPerfil(titulo = "Hola usuario")

        BodyPerfil {

           DescripcionPerfil()

            Spacer(modifier = Modifier.height(8.dp))

            ItemPerfil("Edad")
            Spacer(modifier = Modifier.height(4.dp))

            ItemPerfil("Peso")
            Spacer(modifier = Modifier.height(4.dp))

            ItemPerfil("Sexo")
            Spacer(modifier = Modifier.height(4.dp))

            ItemPerfil("Estatura")
        }

    }
}

@Composable
fun HeaderPerfil(titulo: String) {

    Box(
        contentAlignment = Alignment.CenterStart,
        modifier = Modifier
            .height(60.dp)
            .fillMaxWidth()
            .background(Colores.ROJO_OSCURO)
            .padding(16.dp)
    ) {
        Text(
            text = titulo,
            color = Colores.BLANCO,
            fontSize = 25.sp,
            fontFamily = Fuentes.REM_MEDIUM

        )
    }

}

@Composable
fun BodyPerfil(itemsFormulario: @Composable () -> Unit) {

    Column (
        modifier = Modifier.padding(16.dp)
    ){
        itemsFormulario()
    }

}

@Composable
fun DescripcionPerfil(){

    Text(text = "Puedes editar cualquiera de tus estadisticas presionando sobre el icono de lapiz:",
        color = Colores.GRIS,
        fontSize = 16.sp,
        fontFamily = Fuentes.REM_MEDIUM,
        textAlign = TextAlign.Left,
        modifier = Modifier.fillMaxWidth()
    )

}
@Composable
fun ItemPerfil(titulo: String = "Nombre"){

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
    ){
        Etiqueta(titulo = titulo, Modifier.weight(1f))
        CampoTexto(Modifier.weight(2f))
        IconoEditarGuardar()
    }
}

@Composable
fun Etiqueta(titulo: String, modifier: Modifier = Modifier) {

    Text(
        text = "${titulo}: ",
        color = Color.Black,
        fontSize = 20.sp,
        fontFamily = Fuentes.REM_MEDIUM,
        modifier = modifier
    )
}

@Composable
fun CampoTexto(modifier: Modifier) {

    BasicTextField(
        value = "",
        onValueChange = { },

        maxLines = 1,
        textStyle = TextStyle(
            color = Color.Black,
            fontSize = 20.sp,
            fontFamily = Fuentes.REM_LIGHT,
        ),

        modifier = modifier

    )
}

/* Icono que por defecto aparece con un lapiz para editar,
    pero inmediatamente al presionarlo se convierte en un disquet para guardar*/
@Composable
fun IconoEditarGuardar(){

    BotonEditar(
        onClick = {},
        color = Colores.GRIS_OSCURO
    )

}

        

