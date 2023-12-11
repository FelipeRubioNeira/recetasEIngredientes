package com.app.recetasEIngredientes.mainMenu.recetas.nuevaReceta

import android.graphics.fonts.FontStyle
import android.widget.Space
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.recetasEIngredientes.common.componentes.BotonApp
import com.app.recetasEIngredientes.common.componentes.Titulo
import com.app.recetasEIngredientes.common.componentes.TopBarApp
import com.app.recetasEIngredientes.constantes.Colores
import com.app.recetasEIngredientes.constantes.Fuentes

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showSystemUi = true)
@Composable
fun NuevaReceta() {

    Scaffold(
        topBar = {
            TopBarApp(
                titulo = "Nueva Receta",
                goBack = { }
            )
        },
    ) {

        FormularioNuevaReceta(
            modifier = Modifier.padding(it),
            guardarFormulario = { }
        )

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormularioNuevaReceta(
    modifier: Modifier = Modifier,
    guardarFormulario: () -> Unit
) {


    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(top = 16.dp)
            .padding(horizontal = 16.dp)

    ) {

        BotonApp(
            value = "Guardar",
            onPress = guardarFormulario
        )

        Spacer(modifier = Modifier.size(16.dp))

        TituloReceta()

        DescripcionReceta()


    }

}

@Composable
fun TituloReceta() {

    var value by rememberSaveable {
        mutableStateOf("")
    }

    // titulo
    Text(
        text = "Título de la receta",
        fontFamily = Fuentes.REM_MEDIUM,
        fontSize = 18.sp,
    )

    Spacer(modifier = Modifier.size(4.dp))

    // input
    TextField(
        value = value,
        onValueChange = {value = it},
        placeholder = { PlaceholderApp("Nombre de la receta") },
        textStyle = TextStyle(
            fontFamily = Fuentes.REM_LIGHT,
            fontSize = 18.sp,
        ),
        colors = TextFieldDefaults.textFieldColors(
            textColor = Colores.NEGRO,
            backgroundColor = Colores.BLANCO,
            focusedIndicatorColor = Colores.ROJO,
        ),
        maxLines = 1,

        modifier = Modifier
            .fillMaxWidth()

    )
}

@Composable
fun PlaceholderApp(text: String) {

    Text(
        text = text,
        fontFamily = Fuentes.REM_LIGHT,
        fontSize = 18.sp,
        color = Colores.GRIS
    )

}

@Composable
fun DescripcionReceta(){

}