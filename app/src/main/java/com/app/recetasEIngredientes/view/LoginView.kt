package com.app.recetasEIngredientes.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuDefaults.outlinedTextFieldColors
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.recetasEIngredientes.R
import com.app.recetasEIngredientes.constantes.Colores
import com.app.recetasEIngredientes.constantes.Fuentes


@Preview(showBackground = true, device = Devices.DEFAULT)
@Composable
fun LoginView() {

    Image(
        painter = painterResource(R.drawable.imagen_principal),
        contentDescription = "imagen principal",
        contentScale = ContentScale.FillHeight,
        modifier = Modifier.fillMaxSize()
    )

    Column(modifier = Modifier.padding(16.dp)) {

        Header(Modifier.weight(2f))
        Body(Modifier.weight(7f))
        Footer(Modifier.weight(2f))

    }
}

@Composable
fun Header(modifier: Modifier) {

    Box(
        modifier = modifier
            .fillMaxSize(),

        ) {

        Text(
            text = "Bienvenido a recetas e ingredientes",
            textAlign = TextAlign.Center,
            fontSize = 24.sp,
            color = Colores.BLANCO,
            fontWeight = FontWeight.Bold,
            fontFamily = Fuentes.REM_BOLD,


            modifier = Modifier
                .align(Alignment.Center)
                .fillMaxWidth()
        )
    }

}

@Composable
fun Body(modifier: Modifier) {

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center
    ) {
        Label("Usuario")
        TextInputUsuario()

        Spacer(modifier = Modifier.padding(8.dp))

        Label("Contraseña")
        TextInputPassword()

        Spacer(modifier = Modifier.padding(16.dp))

        BotonLogin()
    }

}

@Composable
fun Footer(modifier: Modifier) {

    Column(
        modifier = modifier
            .fillMaxSize()
            .clip(shape = RoundedCornerShape(16.dp))
            .background(color = Colores.GRIS_TRANSPARENTE),

        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally,

        ) {
        Column(modifier = Modifier.padding(vertical = 8.dp)) {
            CrearCuenta()
            Spacer(modifier = Modifier.padding(8.dp))
            BotonesRedesSociales()
        }

    }
}

@Composable
fun CrearCuenta() {
    // crea una cuenta o ingresa con
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()

    ) {
        BotonRegistro("Crear una cuenta ")
        Text(text = "o ingresar con:", fontFamily = Fuentes.REM_MEDIUM)
    }

}

@Composable
fun BotonesRedesSociales() {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,

        modifier = Modifier
            .fillMaxWidth()

    ) {
        BotonRedSocial("Facebook")
        Spacer(modifier = Modifier.padding(8.dp))
        BotonRedSocial("Google")
    }
}

/* nuevos componentes */
@Composable
fun Label(value: String) {

    Text(
        text = value,
        textAlign = TextAlign.Center,
        fontSize = 24.sp,
        color = Colores.BLANCO,
        fontFamily = Fuentes.REM_LIGHT,

        modifier = Modifier
            .fillMaxWidth()

    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextInputUsuario() {

    var value by rememberSaveable { mutableStateOf("") }

    OutlinedTextField(
        value = value,
        singleLine = true,
        onValueChange = { value = it },
        label = { Text("Ingrese usuario", fontFamily = Fuentes.REM_LIGHT) },
        textStyle = TextStyle(fontFamily = Fuentes.REM_LIGHT),

        colors = outlinedTextFieldColors(
            focusedLabelColor = Colores.BLANCO,
            focusedBorderColor = Colores.BLANCO,

            unfocusedBorderColor = Colores.GRIS_TRANSPARENTE,
            unfocusedLabelColor = Colores.GRIS_TRANSPARENTE,

            cursorColor = Colores.BLANCO,
            textColor = Colores.BLANCO
        ),


        modifier = Modifier.fillMaxWidth()
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextInputPassword() {

    var value by rememberSaveable { mutableStateOf("") }
    var passwordVisible by rememberSaveable { mutableStateOf(false) }

    OutlinedTextField(
        value = value,
        onValueChange = { value = it },
        singleLine = true,
        label = { Text("Ingrese contraseña") },
        textStyle = TextStyle(fontFamily = Fuentes.REM_LIGHT),
        visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
        trailingIcon = {
            Icon(
                painter = if (!passwordVisible) painterResource(id = R.drawable.ic_ojo_cerrado)
                else painterResource(
                    id = R.drawable.ic_ojo
                ),
                contentDescription = "mostrar password",
                modifier = Modifier.clickable {
                    passwordVisible = !passwordVisible
                },
                tint = Colores.GRIS_TRANSPARENTE
            )
        },

        colors = outlinedTextFieldColors(
            focusedLabelColor = Colores.BLANCO,
            focusedBorderColor = Colores.BLANCO,

            unfocusedBorderColor = Colores.GRIS_TRANSPARENTE,
            unfocusedLabelColor = Colores.GRIS_TRANSPARENTE,

            cursorColor = Colores.BLANCO,
            textColor = Colores.BLANCO
        ),


        modifier = Modifier.fillMaxWidth()
    )
}

@Composable
fun BotonLogin() {
    Button(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp),
        colors = ButtonDefaults.buttonColors(
            contentColor = Colores.BLANCO,
            containerColor = Colores.ROJO
        ),
        onClick = { /*TODO*/ }) {
        Text(
            text = "Ingresar",
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp,
            fontFamily = Fuentes.REM_BOLD
        )
    }
}

@Composable
fun BotonRegistro(value: String) {
    Text(
        text = value,
        color = Colores.ARANDANO,
        fontFamily = Fuentes.REM_MEDIUM,
        modifier = Modifier.clickable { }
    )
}

@Composable
fun BotonRedSocial(value: String) {

    val logo = when (value) {
        "Facebook" -> R.drawable.facebook_logo
        "Google" -> R.drawable.google_logo
        else -> -1
    }

    Image(
        painter = painterResource(logo),
        contentDescription = "logo red social",

        modifier = Modifier
            .clickable { }
    )


}