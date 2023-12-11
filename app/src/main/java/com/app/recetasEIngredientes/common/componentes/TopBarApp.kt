package com.app.recetasEIngredientes.common.componentes

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import com.app.recetasEIngredientes.constantes.Colores
import com.app.recetasEIngredientes.constantes.Fuentes


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBarApp(
    titulo: String = "",
    goBack: (() -> Unit)? = null // si es null no se muestra el icono de goBack
) {

    TopAppBar(
        title = { Titulo(titulo) },
        navigationIcon = {
            if (goBack != null) {
                IconoGoBack(
                    goBack = goBack
                )
            }
        },
        colors = TopAppBarDefaults.smallTopAppBarColors(
            containerColor = Colores.ROJO,
            titleContentColor = Colores.BLANCO,
        )
    )
}

@Composable
fun Titulo(titulo: String = "") {
    Text(
        text = titulo,
        textAlign = TextAlign.Center,
        fontFamily = Fuentes.REM_MEDIUM
    )
}

@Composable
fun IconoGoBack(goBack: () -> Unit) {

    IconButton(
        modifier = Modifier,
        onClick = goBack
    ) {
        Icon(
            imageVector = Icons.Default.ArrowBack,
            contentDescription = "back",
            tint = Colores.BLANCO
        )
    }
}