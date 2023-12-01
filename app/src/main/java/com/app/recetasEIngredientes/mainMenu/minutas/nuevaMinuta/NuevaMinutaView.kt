package com.app.recetasEIngredientes.mainMenu.minutas.nuevaMinuta

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.recetasEIngredientes.R
import com.app.recetasEIngredientes.constantes.Colores
import com.app.recetasEIngredientes.constantes.Fuentes
import com.app.recetasEIngredientes.mainMenu.Titulo
import com.app.recetasEIngredientes.mainMenu.minutas.ModalListadoRecetas


@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NuevaMinutaView(
    nuevaMinutasVM: NuevaMinutaViewModel,
    minutaId: Int?,
) {


    // ------------------------------ variables locales ----------------------------------------------------

    val tituloPantalla: String by nuevaMinutasVM.tituloPantalla.observeAsState("Nueva minuta")



    // ------------------------------ efectos -----------------------------------------

    // es un effecto que se ejecuta la primera vez que se renderiza el componente
    LaunchedEffect(key1 = minutaId) {
        nuevaMinutasVM.resetearFormulario()
        nuevaMinutasVM.cargarMinuta(minutaId?: 0)
    }


    // ------------------------------ composables -----------------------------------------


    Scaffold(
        topBar = { TopBar(nuevaMinutasVM, tituloPantalla) },
    ) { innerPadding ->

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {

                Header(nuevaMinutasVM)

                Spacer(modifier = Modifier.size(24.dp))

                Body(nuevaMinutasVM)

                Spacer(modifier = Modifier.size(16.dp))

                Footer(nuevaMinutasVM, minutaId?: 0)

            }

            ModalListadoRecetas(nuevaMinutasVM)

        }

    }
}


@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Header(nuevaMinutasVM: NuevaMinutaViewModel) {

    val tituloMinuta: String by nuevaMinutasVM.tituloMinuta.observeAsState("Nueva minuta")


    Column {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                text = "Nueva minuta: ",
                fontFamily = Fuentes.REM_LIGHT,
                modifier = Modifier.weight(1f)
            )
            TextField(
                value = tituloMinuta,
                onValueChange = { nuevaMinutasVM.setTituloMinuta(it) },
                placeholder = { PlaceholderApp("Nombre de la minuta") },
                singleLine = true,

                textStyle = TextStyle(
                    fontFamily = Fuentes.REM_LIGHT,
                    fontSize = 16.sp,
                    color = Colores.GRIS_OSCURO
                ),
                modifier = Modifier
                    .weight(3f)

            )
        }

        Spacer(modifier = Modifier.size(16.dp))

        Row {
            Text(
                text = "Fecha: ",
                fontFamily = Fuentes.REM_LIGHT,
                modifier = Modifier.weight(1f)
            )
            Text(
                text = nuevaMinutasVM.fechaMinuta.value.toString(),
                fontFamily = Fuentes.REM_LIGHT,
                modifier = Modifier.weight(3f)
            )
        }
    }

}

@Composable
fun Body(nuevaMinutasVM: NuevaMinutaViewModel) {

    // lista de dias de la semana
    val diasSemana = listOf(
        "Lunes",
        "Martes",
        "Miércoles",
        "Jueves",
        "Viernes",
        "Sábado",
        "Domingo"
    )

    Column(
        modifier = Modifier.verticalScroll(rememberScrollState())
    ) {

        diasSemana.forEach { dia ->
            Fila(dia, nuevaMinutasVM)
            Spacer(modifier = Modifier.size(16.dp))
        }

    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun Footer(nuevaMinutasVM: NuevaMinutaViewModel, minutaIdParse: Int) {


    val esNuevaMinuta: Boolean by nuevaMinutasVM.esNuevaMinuta.observeAsState(true)


    Row {

        BotonCancelar(
            "Cancelar",
            onClick = { nuevaMinutasVM.goBack() },
            modifier = Modifier.weight(1f)
        )

        Spacer(modifier = Modifier.size(16.dp))


        BotonAceptar(
            text = if (esNuevaMinuta) "Guardar" else "Editar",
            onClick = {
                if (esNuevaMinuta) nuevaMinutasVM.agregarNuevaMinuta()
                else nuevaMinutasVM.editarMinuta(minutaIdParse)
            },
            modifier = Modifier.weight(1f)
        )

    }

}

@Composable
fun BotonAceptar(text: String, onClick: () -> Unit, modifier: Modifier = Modifier) {
    Button(
        onClick = { onClick() },
        colors = ButtonDefaults.buttonColors(
            containerColor = Colores.AZUL,
        ),
        modifier = modifier
            .height(50.dp)
            .clip(RoundedCornerShape(8.dp))
    ) {
        TextoBoton(text)
    }
}

@Composable
fun BotonCancelar(text: String, onClick: () -> Unit, modifier: Modifier = Modifier) {
    Button(
        onClick = { onClick() },
        colors = ButtonDefaults.buttonColors(
            containerColor = Colores.GRIS,
        ),
        modifier = modifier
            .height(50.dp)
            .clip(RoundedCornerShape(8.dp))
    ) {
        TextoBoton(text)
    }
}

@Composable
fun TextoBoton(text: String) {
    Text(
        text = text,
        fontSize = 16.sp,
        fontFamily = Fuentes.REM_BOLD,
    )
}

@Composable
fun Fila(dia: String, nuevaMinutasVM: NuevaMinutaViewModel) {

    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.height(42.dp)
    ) {
        Label(dia, Modifier.weight(1f))
        Spacer(modifier = Modifier.size(16.dp))
        SelectorReceta(
            Modifier.weight(3f),
            nuevaMinutasVM,
            dia
        )
    }
}

@Composable
fun Label(value: String, modifier: Modifier = Modifier) {
    Text(
        text = value,
        fontFamily = Fuentes.REM_LIGHT,
        color = Colores.NEGRO,
        fontSize = 16.sp,
        modifier = modifier
    )
}

@Composable
fun SelectorReceta(
    modifier: Modifier = Modifier,
    nuevaMinutasVM: NuevaMinutaViewModel,
    dia: String
) {

    // Obtiene una referencia al LocalFocusManager
    val focusManager = LocalFocusManager.current

    // vamos a observar la variable valueDia y por defecto comienza como un mapa vacio
    val values: Map<String, String> by nuevaMinutasVM.diasRecetas.observeAsState(emptyMap())
    val valueDia: String = values[dia] ?: "Seleccione receta"

    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxSize()
            .border(
                width = 1.dp,
                color = Colores.GRIS_OSCURO,
                shape = MaterialTheme.shapes.small,
            )
            .padding(vertical = 4.dp, horizontal = 8.dp)
            .clickable {
                nuevaMinutasVM.mostrarModalRecetas(dia)
                focusManager.clearFocus()
            }
    ) {
        Text(
            text = valueDia,
            color = Colores.NEGRO
        )
        Icon(
            painter = painterResource(id = R.drawable.ic_down),
            contentDescription = "down",
            tint = Colores.GRIS_OSCURO
        )

    }

}

@Composable
fun PlaceholderApp(value: String) {
    Text(
        text = value,
        fontFamily = Fuentes.REM_LIGHT,
        color = Colores.GRIS,
        fontSize = 16.sp
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(nuevaMinutasVM: NuevaMinutaViewModel, tituloPantalla: String) {

    TopAppBar(
        title = { Titulo(tituloPantalla) },
        navigationIcon = { IconoGoBack(nuevaMinutasVM) },
        colors = TopAppBarDefaults.smallTopAppBarColors(
            containerColor = Colores.ROJO,
            titleContentColor = Colores.BLANCO,
        )
    )
}

@Composable
fun IconoGoBack(nuevaMinutasVM: NuevaMinutaViewModel) {

    IconButton(
        modifier = Modifier,
        onClick = { nuevaMinutasVM.goBack() }
    ) {
        Icon(
            imageVector = Icons.Default.ArrowBack,
            contentDescription = "back",
            tint = Colores.BLANCO
        )
    }
}
