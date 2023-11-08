package com.app.recetasEIngredientes.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
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
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.app.recetasEIngredientes.R
import com.app.recetasEIngredientes.constantes.Colores
import com.app.recetasEIngredientes.constantes.Fuentes


@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun LoginView(navController: NavHostController) {

    // view model que gestiona la vista de esta pantalla
    val loginViewModel = LoginViewModel(navController)

    // controlador del teclado que se usa para ocultar el teclado cuando se hace click en cualquier parte de la pantalla
    val controller = loginViewModel.getKeyboardController()

    // interaction del teclado u otros gestos para el boton de login (se usa para ocultar el teclado)
    val source: MutableInteractionSource by loginViewModel.interactionSource.observeAsState(initial = MutableInteractionSource())


    // imagen de fondo
    Image(
        painter = painterResource(R.drawable.imagen_principal),
        contentDescription = "imagen principal",
        contentScale = ContentScale.FillHeight,
        modifier = Modifier
            .fillMaxSize()
            .clickable(
                interactionSource = source,
                indication = null
            ) {
                controller?.hide()
            }
    )

    // contenedor principal
    Column(modifier = Modifier.padding(16.dp)) {

        Header(Modifier.weight(2f))
        Body(loginViewModel, Modifier.weight(7f))
        Footer(loginViewModel, Modifier.weight(2f))

    }

}

@Composable
fun Header(modifier: Modifier) {

    Box(
        modifier = modifier
            .fillMaxSize(),

        ) {

        // TODO: este podria ser un H1 perfectamente
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
fun Body(loginViewModel: LoginViewModel, modifier: Modifier) {

    val user: String by loginViewModel.user.observeAsState(initial = "")
    val password: String by loginViewModel.password.observeAsState(initial = "")
    val passwordVisible: Boolean by loginViewModel.passwordVisible.observeAsState(initial = false)
    val colorBotonLogin: Color by loginViewModel.colorBotonLogin.observeAsState(initial = Colores.GRIS_TRANSPARENTE)
    val isLoginEnabled: Boolean by loginViewModel.isLoginEnabled.observeAsState(initial = false)


    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center
    ) {

        // usuario
        Label("Usuario")
        TextInputUser(user, loginViewModel, password)
        Spacer(modifier = Modifier.padding(8.dp))

        // contraseña
        Label("Contraseña")
        TextInputPassword(
            password,
            passwordVisible,
            { loginViewModel.onUserPasswordChanged(user, it) },
            { loginViewModel.onPasswordVisibleChanged(it) }
        )


        Spacer(modifier = Modifier.padding(16.dp))

        BotonLogin(isLoginEnabled, colorBotonLogin, loginViewModel)

    }

}

@Composable
fun Footer(loginViewModel: LoginViewModel, modifier: Modifier) {

    Column(
        modifier = modifier
            .fillMaxSize()
            .clip(shape = RoundedCornerShape(16.dp))
            .background(color = Colores.GRIS_TRANSPARENTE),

        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally,

        ) {
        Column(modifier = Modifier.padding(vertical = 8.dp)) {
            CrearCuenta({ loginViewModel.navigateToCreateAccount() })
            Spacer(modifier = Modifier.padding(8.dp))
            BotonesRedesSociales()
        }

    }
}

@Composable
fun CrearCuenta(navigateToCreateAccount: () -> Unit) {

    // crea una cuenta o ingresa con
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()

    ) {
        Text(
            text = "Crear una cuenta ",
            color = Colores.ARANDANO,
            fontFamily = Fuentes.REM_MEDIUM,
            modifier = Modifier.clickable { navigateToCreateAccount() }
        )
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

@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun TextInputUser(user: String, loginViewModel: LoginViewModel, password: String) {

    OutlinedTextField(
        value = user,
        onValueChange = {
            loginViewModel.onUserPasswordChanged(
                it,
                password
            )
        }, // evento que se ejecuta cuando cambia el valor
        singleLine = true,
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

        modifier = Modifier
            .fillMaxWidth()

    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextInputPassword(
    password: String,
    passwordVisible: Boolean,
    onValueChange: (String) -> Unit,
    onPasswordVisibleChange: (Boolean) -> Unit
) {

    OutlinedTextField(
        value = password,
        onValueChange = { onValueChange(it) },
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
                    onPasswordVisibleChange(!passwordVisible)
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
fun BotonLogin(
    isLoginEnabled: Boolean,
    colorBotonLogin: Color,
    loginViewModel: LoginViewModel
) {

    Button(
        enabled = isLoginEnabled,
        colors = ButtonDefaults.buttonColors(
            containerColor = colorBotonLogin,
            contentColor = Colores.BLANCO,
            disabledContainerColor = colorBotonLogin,
            disabledContentColor = Colores.BLANCO
        ),
        onClick = { loginViewModel.navigateToDashboard() },

        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
    )

    {
        Text(
            text = "Ingresar",
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp,
            fontFamily = Fuentes.REM_BOLD
        )
    }
}

@Composable
fun BotonRegistro(value: String, navigateToCreateAccount: () -> Unit = {}) {
    Text(
        text = value,
        color = Colores.ARANDANO,
        fontFamily = Fuentes.REM_MEDIUM,
        modifier = Modifier.clickable { navigateToCreateAccount() }
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