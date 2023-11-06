package com.app.recetasEIngredientes.login

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.platform.SoftwareKeyboardController
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import com.app.recetasEIngredientes.constantes.Colores
import com.app.recetasEIngredientes.navegacion.Routes

class LoginViewModel(navController: NavHostController) : ViewModel() {

    val _navController = navController

    // user
    private val _user = MutableLiveData<String>()
    val user: LiveData<String> = _user

    // password
    private val _password = MutableLiveData<String>()
    val password: LiveData<String> = _password

    // password visible
    private val _passwordVisible = MutableLiveData<Boolean>()
    val passwordVisible: LiveData<Boolean> = _passwordVisible

    // boton login habilitado
    private val _colorBotonLogin = MutableLiveData<Color>()
    val colorBotonLogin: LiveData<Color> = _colorBotonLogin

    private val _isLoginEnabled = MutableLiveData<Boolean>()
    val isLoginEnabled: LiveData<Boolean> = _isLoginEnabled

    // interaction del teclado u otros gestos para el boton de login (se usa para ocultar el teclado)
    private val _interactionSource = MutableLiveData<MutableInteractionSource>()
    val interactionSource: LiveData<MutableInteractionSource> = _interactionSource


    // funcion para actualizar el user y el password
    fun onUserPasswordChanged(user: String = "", password: String = "") {

        _user.value = user
        _password.value = password

        // habilitar el boton de login si el user y el password tienen al menos 1 caracteres
        if (user.length == 0 || password.length == 0) {
            _colorBotonLogin.value = Colores.GRIS_TRANSPARENTE
            _isLoginEnabled.value = false

        } else {
            _colorBotonLogin.value = Colores.ROJO
            _isLoginEnabled.value = true
        }


    }

    fun onPasswordVisibleChanged(passwordVisible: Boolean = false) {
        _passwordVisible.value = passwordVisible
    }

    // navegar a la pantalla de crear cuenta
    fun navigateToCreateAccount() {
        _navController.navigate(Routes.CREATE_ACCOUNT)
    }

    // navegar a la pantalla principal
    fun navigateToDashboard() {

        // solo navegamos si el login esta habilitado
        if (_isLoginEnabled.value == true) {
            _navController.navigate(Routes.DASHBOARD)
        }

    }

    // ocultar el teclado
    @OptIn(ExperimentalComposeUiApi::class)
    @Composable
    fun getKeyboardController(): SoftwareKeyboardController? {
        return LocalSoftwareKeyboardController.current
    }


}