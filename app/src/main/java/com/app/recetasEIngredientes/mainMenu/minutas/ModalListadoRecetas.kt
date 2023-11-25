package com.app.recetasEIngredientes.mainMenu.minutas

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.recetasEIngredientes.constantes.Colores
import com.app.recetasEIngredientes.constantes.Fuentes
import com.app.recetasEIngredientes.mainMenu.minutas.nuevaMinuta.NuevaMinutaViewModel

@Composable
fun ModalListadoRecetas(nuevaMinutaViewModel: NuevaMinutaViewModel) {

    // variable para mostrar u ocultar el modal
    val modalVisible: Boolean by nuevaMinutaViewModel.modalRecetasVisible.observeAsState(false)

    // si modalVisible es false, no se muestra nada
    if (!modalVisible) return

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Colores.TRANSPARENTE_OSCURO),

        ) {

        Card(
            elevation = 16.dp,
            modifier = Modifier
                .fillMaxSize(0.8f)
                .clip(shape = RoundedCornerShape(8.dp))
                .background(Colores.BLANCO)
                .align(Alignment.Center)
                .border(
                    width = 1.dp,
                    color = Colores.GRIS,
                    shape = RoundedCornerShape(8.dp),
                )
        ) {

            Column {
                HeaderModal("Recetas", nuevaMinutaViewModel)
                BodyModal(nuevaMinutaViewModel)
            }

        }
    }
}

@Composable
fun HeaderModal(title: String, nuevaMinutaViewModel: NuevaMinutaViewModel) {

    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,

        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
            .background(Colores.ROJO)
            .padding(start = 16.dp)
    ) {

        // titulo
        Text(
            text = title,
            color = Colores.BLANCO,
            fontSize = 20.sp,
            fontFamily = Fuentes.REM_BOLD,
        )

        // boton cerrar
        IconButton(onClick = { nuevaMinutaViewModel.ocultarModalRecetas() }) {
            Icon(
                imageVector = Icons.Default.Close,
                tint = Colores.BLANCO,
                contentDescription = "cerrar",
                modifier = Modifier.size(32.dp)
            )
        }


    }
}


@Composable
fun BodyModal(nuevaMinutaViewModel: NuevaMinutaViewModel) {

    // listado de recetas provisorio
    val ListaRecetas = listOf(
        "Receta 1",
        "Receta 2",
        "Receta 3",
        "Receta 4",
        "Receta 5",
    )

    LazyColumn(
        content = {
            items(ListaRecetas.size) { index ->
                RecetaItem(
                    ListaRecetas[index],
                    nuevaMinutaViewModel
                )
                Divider(color = Colores.GRIS_TRANSPARENTE)
            }
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    )
}

@Composable
fun RecetaItem(titulo: String, nuevaMinutaViewModel: NuevaMinutaViewModel) {

    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .height(42.dp)
    ) {
        TextButton(onClick = {
            nuevaMinutaViewModel.seleccionarReceta(titulo)
        }) {
            Text(
                titulo,
                fontSize = 16.sp,
                fontFamily = Fuentes.REM_LIGHT,
                color = Colores.NEGRO,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}
