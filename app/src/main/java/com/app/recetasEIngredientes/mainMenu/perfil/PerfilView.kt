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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
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
import com.app.recetasEIngredientes.common.componentes.BotonGuardar
import com.app.recetasEIngredientes.constantes.Colores
import com.app.recetasEIngredientes.constantes.Fuentes
import retrofit2.http.Body


@Composable
fun PerfilView(perfilVM: PerfilViewModel) {

    val valorNombre: String by perfilVM.nombre.observeAsState("")
    val estadoIconoNombre: String by perfilVM.estadoIcono.observeAsState("")

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Colores.BLANCO)

    ) {

        HeaderPerfil(titulo = "Perfil de usuario")

        BodyPerfil {

            DescripcionPerfil()

            Spacer(modifier = Modifier.height(8.dp))

            ItemPerfil(
                "Nombre",
                valor = valorNombre,
                actualizarValor = { valor ->
                    perfilVM.actualizarValor(
                        PerfilModel.ITEMS_PERFIL.NOMBRE,
                        valor
                    )
                },
                estadoIcono = estadoIconoNombre,
                perfilVM = perfilVM,
                itemPerfil = PerfilModel.ITEMS_PERFIL.NOMBRE,
            )

            Spacer(modifier = Modifier.height(4.dp))

//            ItemPerfil("Edad")
//            Spacer(modifier = Modifier.height(4.dp))
//
//            ItemPerfil("Peso")
//            Spacer(modifier = Modifier.height(4.dp))
//
//            ItemPerfil("Sexo")
//            Spacer(modifier = Modifier.height(4.dp))
//
//            ItemPerfil("Estatura (cms)")
//            Spacer(modifier = Modifier.height(16.dp))
//
//            ItemPerfil("Actividad fisica")
//            Spacer(modifier = Modifier.height(4.dp))
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

    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        itemsFormulario()
    }

}

@Composable
fun DescripcionPerfil() {

    Text(
        text = "Puedes editar cualquiera de tus estadisticas presionando sobre el icono de lapiz:",
        color = Colores.GRIS,
        fontSize = 16.sp,
        fontFamily = Fuentes.REM_MEDIUM,
        textAlign = TextAlign.Left,
        modifier = Modifier.fillMaxWidth()
    )

}

@Composable
fun ItemPerfil(
    titulo: String = "",
    valor: String = "",
    actualizarValor: (String) -> Unit = { },
    estadoIcono: String = PerfilModel.ESTADO_ICONO.EDITAR, // por defecto el estado es editar
    perfilVM: PerfilViewModel,
    itemPerfil: String,
) {

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
    ) {

        // nombre del campo
        Etiqueta(titulo = titulo, Modifier.weight(1f))

        // campo de texto
        CampoTexto(
            Modifier.weight(2f),
            valor,
            actualizarValor,
            estadoIcono
        )

        // icono de editar o guardar
        IconoEditarGuardar(estadoIcono, perfilVM, itemPerfil)
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
fun CampoTexto(
    modifier: Modifier,
    valor: String,
    actualizarValor: (String) -> Unit = { },
    estadoIcono: String
) {

    BasicTextField(
        value = valor,
        onValueChange = actualizarValor,
        maxLines = 1,
        textStyle = TextStyle(
            color = Color.Black,
            fontSize = 20.sp,
            fontFamily = Fuentes.REM_LIGHT,
        ),
        modifier = modifier,
        readOnly = estadoIcono === PerfilModel.ESTADO_ICONO.EDITAR
    )
}

/* Icono que por defecto aparece con un lapiz para editar,
    pero inmediatamente al presionarlo se convierte en un disquet para guardar*/
@Composable
fun IconoEditarGuardar(
    estadoIcono: String,
    perfilVM: PerfilViewModel,
    itemPerfil: String
) {

    if (estadoIcono === PerfilModel.ESTADO_ICONO.EDITAR) {

        BotonEditar(
            onClick = { perfilVM.activarEdicion(itemPerfil) },
            color = Colores.GRIS_OSCURO
        )

    } else {
        BotonGuardar(
            onClick = { perfilVM.guardarEdicion(itemPerfil) },
            color = Colores.GRIS_OSCURO
        )
    }

}



        

