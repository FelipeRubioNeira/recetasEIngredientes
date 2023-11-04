package com.app.recetasEIngredientes.login

import androidx.compose.ui.graphics.Color
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.app.recetasEIngredientes.constantes.Colores

class LoginViewModel : ViewModel() {

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

    // funcion para actualizar el user y el password
    fun onUserPasswordChanged(user: String = "", password: String = "") {

        _user.value = user
        _password.value = password

        // habilitar el boton de login si el user y el password tienen al menos 1 caracteres
        if (user.length == 0 || password.length == 0){
            _colorBotonLogin.value = Colores.GRIS_TRANSPARENTE
            _isLoginEnabled.value = false

        }else{
            _colorBotonLogin.value = Colores.ROJO
            _isLoginEnabled.value = true
        }


    }

    fun onPasswordVisibleChanged(passwordVisible: Boolean = false) {
        _passwordVisible.value = passwordVisible
    }

}