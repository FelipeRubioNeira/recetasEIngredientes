package com.app.recetasEIngredientes.mainMenu.minutas.listadoMinutas

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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.BottomEnd
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.recetasEIngredientes.R
import com.app.recetasEIngredientes.constantes.Colores
import com.app.recetasEIngredientes.constantes.Fuentes
import com.app.recetasEIngredientes.mainMenu.minutas.nuevaMinuta.NuevaMinutaModel
import com.app.recetasEIngredientes.navegacion.Routes


@Composable
fun ListadoMinutasView(listadoMinutasVM: ListadoMinutasViewModel) {


    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp)
    ) {


        ListadoMinutas(listadoMinutasVM)

        BotonAgregarMinuta(
            listadoMinutasVM,
            Modifier.align(alignment = BottomEnd)
        )
    }
}

@Composable
fun ListadoMinutas(listadoMinutasVM: ListadoMinutasViewModel) {

    val listadoMinutas: List<NuevaMinutaModel> by listadoMinutasVM.minutas.observeAsState(emptyList())

    LazyColumn(
        content = {
            items(listadoMinutas.size) { index ->
                val nuevoItem = listadoMinutas[index] // value del item de tipo NuevaMinutaModel
                MinutaItem(nuevoItem, listadoMinutasVM)
                Spacer(modifier = Modifier.padding(4.dp))
            }
        }
    )

}

@Composable
fun MinutaItem(
    minutaM: NuevaMinutaModel,
    listadoMinutasVM: ListadoMinutasViewModel
) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(shape = RoundedCornerShape(8.dp))
            .border(
                width = 2.dp,
                color = Colores.GRIS,
                shape = RoundedCornerShape(8.dp)
            )

    ) {

        // titulo de la minuta
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .height(40.dp)
                .background(Colores.ROJO)
                .padding(horizontal = 8.dp, vertical = 4.dp)

        ) {
            Text(
                text = minutaM.titulo, // value del item
                color = Colores.BLANCO,
                fontSize = 16.sp,
                fontFamily = Fuentes.REM_BOLD
            )
            IconButton(onClick = {listadoMinutasVM.eliminarMinuta(minutaM.id)}) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_delete),
                    contentDescription = "delete",
                    tint = Colores.BLANCO,
                    modifier = Modifier
                        .size(54.dp)
                )
            }
        }

        Spacer(modifier = Modifier.padding(8.dp))

        Column(modifier = Modifier.padding(8.dp)) {
            minutaM.dias.forEach { (dia, receta) ->
                Text(
                    text = "${dia}: ${receta}",
                    color = Colores.NEGRO,
                    fontFamily = Fuentes.REM_LIGHT
                )
            }
        }

        Spacer(modifier = Modifier.padding(2.dp))

        // fecha
        Text(
            text = minutaM.fecha, // value del item
            color = Colores.GRIS_OSCURO,
            textAlign = TextAlign.End,
            fontFamily = Fuentes.REM_MEDIUM,
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )
    }


}


@Composable
fun BotonAgregarMinuta(
    listadoMinutasVM: ListadoMinutasViewModel,
    modifier: Modifier,
) {

    FloatingActionButton(
        containerColor = Colores.ROJO,
        contentColor = Colores.BLANCO,
        modifier = modifier.padding(16.dp),
        onClick = { listadoMinutasVM.navigateTo(Routes.NUEVA_MINUTA) }
    ) {
        Icon(Icons.Default.Add, contentDescription = "Add")
    }
}


