package com.app.recetasEIngredientes.mainMenu.recetas.nuevaReceta

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.recetasEIngredientes.common.componentes.BotonApp
import com.app.recetasEIngredientes.common.componentes.TopBarApp
import com.app.recetasEIngredientes.constantes.Colores
import com.app.recetasEIngredientes.constantes.Fuentes

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NuevaReceta(
    nuevaRecetaVM: NuevaRecetaViewModel,
    recetaId: Int?
) {

    LaunchedEffect(key1 = recetaId) {
        nuevaRecetaVM.cargarReceta(recetaId ?: 0)
    }

    Scaffold(
        topBar = {
            TopBarApp(
                titulo = "Nueva Receta",
                goBack = { nuevaRecetaVM.goBack() }
            )
        },
    ) {

        FormularioNuevaReceta(
            modifier = Modifier.padding(it),
            nuevaRecetaVM = nuevaRecetaVM,
            recetaId = recetaId
        )

    }
}

// --------------------- composables ---------------------

@Composable
fun FormularioNuevaReceta(
    modifier: Modifier = Modifier,
    nuevaRecetaVM: NuevaRecetaViewModel,
    recetaId: Int?
) {

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Colores.BLANCO)
            .padding(top = 16.dp)
            .padding(horizontal = 16.dp)

    ) {

        TituloReceta(nuevaRecetaVM)
        Spacer(modifier = Modifier.size(16.dp))
        DescripcionReceta(nuevaRecetaVM)
        Spacer(modifier = Modifier.size(16.dp))
        Spacer(modifier = Modifier.size(16.dp))

        BotonApp(
            value = "Guardar",
            onPress = { nuevaRecetaVM.guardarReceta(recetaId ?: 0) }
        )

    }

}

@Composable
fun TituloReceta(nuevaRecetaVM: NuevaRecetaViewModel) {

    val nombreReceta: String by nuevaRecetaVM.nombreReceta.observeAsState("caca")

    // nombre
    Encabezado(value = "Nombre de la receta")

    // input
    TextField(
        value = nombreReceta,
        onValueChange = { nuevaRecetaVM.setNombreReceta(it) },
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
fun Encabezado(value: String) {

    Text(
        text = value,
        fontFamily = Fuentes.REM_MEDIUM,
        fontSize = 18.sp,
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
fun DescripcionReceta(nuevaRecetaVM: NuevaRecetaViewModel) {

    val descripcionReceta: String by nuevaRecetaVM.descripcionReceta.observeAsState(initial = "")


    Encabezado(value = "Descripción")

    Spacer(modifier = Modifier.size(8.dp))

    OutlinedTextField(
        value = descripcionReceta,
        onValueChange = { nuevaRecetaVM.setDescripcionReceta(it) },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            textColor = Colores.NEGRO,
            focusedBorderColor = Colores.ROJO,
            backgroundColor = Colores.BLANCO
        ),
        textStyle = TextStyle(
            fontSize = 18.sp,
            fontFamily = Fuentes.REM_LIGHT
        ),
        placeholder = { PlaceholderApp(text = "Escriba una descripción de maximo 500 caracteres.") },
        maxLines = 10,
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)

    )

}
