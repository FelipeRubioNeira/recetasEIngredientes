package com.app.recetasEIngredientes.mainMenu.recetas.listadoRecetas

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.recetasEIngredientes.R
import com.app.recetasEIngredientes.common.componentes.BotonAgregar
import com.app.recetasEIngredientes.common.componentes.BotonEditar
import com.app.recetasEIngredientes.common.componentes.BotonEliminar
import com.app.recetasEIngredientes.constantes.Colores
import com.app.recetasEIngredientes.constantes.Fuentes
import com.app.recetasEIngredientes.mainMenu.recetas.Modal
import com.app.recetasEIngredientes.common.model.Receta
import com.app.recetasEIngredientes.navegacion.Routes

@Composable
fun ListadoRecetasView(listadoRecetasVM: ListadoRecetasViewModel) {

    // --------------------- variables ---------------------
    val modalVisible: Boolean by listadoRecetasVM.modalVisible.observeAsState(false)
    val listadoRecetas: List<Receta> by listadoRecetasVM.listadoRecetas.observeAsState(listOf())

    // --------------------- efectos ---------------------
    LaunchedEffect(true) {
        listadoRecetasVM.obtenerListadoRecetas()
    }

    // --------------------- UI ---------------------
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(top = 16.dp)
    ) {

        Column {
            Buscador(listadoRecetasVM)
            Spacer(modifier = Modifier.height(16.dp))
            ListadoRecetas(listadoRecetas, listadoRecetasVM)
        }

        BotonAgregar(
            modifier = Modifier.align(alignment = Alignment.BottomEnd),
            color = Colores.ROJO,
            onPress = { listadoRecetasVM.navegarCrearReceta() }
        )
    }

    // modal para aplicar filtros
    Modal(
        title = "Listado ingredientes",
        modalVisible = modalVisible,
        cerrarModal = { listadoRecetasVM.cerrarModal() }
    ) {
        //TODO BODY DEL MODAL
    }


}

@Composable
fun ListadoRecetas(listadoRecetas: List<Receta>, listadoRecetasVM: ListadoRecetasViewModel) {

    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {

        items(listadoRecetas.size) { index ->
            RecetaItem(
                receta = listadoRecetas[index],
                listadoRecetasVM = listadoRecetasVM
            )
        }

    }

}

@Composable
fun RecetaItem(receta: Receta, listadoRecetasVM: ListadoRecetasViewModel) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp)
            .padding(vertical = 8.dp)
            .border(
                width = 2.dp,
                color = Colores.GRIS,
                shape = RoundedCornerShape(8.dp)
            )
            .clip(shape = RoundedCornerShape(8.dp))
    ) {

        // header
        Row(
            //contentAlignment = Alignment.CenterStart,
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .height(40.dp)
                .background(Colores.ROJO)
                .padding(horizontal = 8.dp, vertical = 4.dp)

        ) {

            Text(
                text = "#${receta.id} ${receta.nombre}",
                color = Colores.BLANCO,
                fontSize = 16.sp,
                fontFamily = Fuentes.REM_BOLD
            )

            Row {
                BotonEliminar(onClick = { listadoRecetasVM.eliminarReceta(receta.id) })
                BotonEditar(onClick = { listadoRecetasVM.navegarEditarReceta(receta.id) })
            }

        }

        // body
        Box(
            modifier = Modifier.padding(8.dp)
        ) {
            Text(
                text = receta.descripcion,
                color = Colores.NEGRO,
                fontFamily = Fuentes.REM_LIGHT
            )
        }

    }

}

@Composable
fun Buscador(listadoRecetasVM: ListadoRecetasViewModel) {

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
            .padding(horizontal = 16.dp)
    ) {
        Busqueda(listadoRecetasVM, Modifier.weight(9f))
    }
}

@Composable
fun Busqueda(
    listadoRecetasVM: ListadoRecetasViewModel,
    modifier: Modifier = Modifier
) {

    val valueBusquedaRecetas: String by listadoRecetasVM.valueBusquedaRecetas.observeAsState("")

    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .height(50.dp)
            .fillMaxWidth()
    ) {

        TextField(
            value = valueBusquedaRecetas,
            onValueChange = { listadoRecetasVM.buscarReceta(it) },
            textStyle = TextStyle(
                fontFamily = Fuentes.REM_LIGHT,
                color = Colores.NEGRO,
                fontSize = 16.sp
            ),
            label = null,
            maxLines = 1,
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

            modifier = Modifier.fillMaxSize(),

            )
    }

}

@Composable
fun Filtro(
    onPress: () -> Unit,
    modifier: Modifier = Modifier
) {

    IconButton(
        modifier = modifier,
        onClick = onPress
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_tune),
            modifier = Modifier.size(40.dp),
            tint = Colores.GRIS_OSCURO,
            contentDescription = "icono de filtro"
        )
    }

}