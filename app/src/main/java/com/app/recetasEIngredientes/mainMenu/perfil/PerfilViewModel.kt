package com.app.recetasEIngredientes.mainMenu.perfil

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PerfilViewModel : ViewModel() {


    // -------------------------- atributos --------------------------
    private val _nombre = MutableLiveData<String>()
    val nombre = _nombre

    private val _estadoIcono = MutableLiveData(PerfilModel.ESTADO_ICONO.EDITAR)
    val estadoIcono = _estadoIcono


    private val _edad = MutableLiveData<Int>()
    val edad = _edad

    private val _peso = MutableLiveData<Int>()
    val peso = _peso

    private val _sexo = MutableLiveData<String>()
    val sexo = _sexo

    private val _altura = MutableLiveData<Int>()
    val altura = _altura

    private val _actividadFisica = MutableLiveData<String>()
    val actividadFisica = _actividadFisica


    // -------------------------- metodos --------------------------

    val actualizarValor: (String, String) -> Unit = { itemPerfil, valor ->

        when (itemPerfil) {
            PerfilModel.ITEMS_PERFIL.NOMBRE -> _nombre.value = valor
            PerfilModel.ITEMS_PERFIL.EDAD -> _edad.value = valor.toInt()
            PerfilModel.ITEMS_PERFIL.PESO -> _peso.value = valor.toInt()
            PerfilModel.ITEMS_PERFIL.SEXO -> _sexo.value = valor
            PerfilModel.ITEMS_PERFIL.ALTURA -> _altura.value = valor.toInt()
            PerfilModel.ITEMS_PERFIL.ACTIVIDAD_FISICA -> _actividadFisica.value = valor
        }

    }

    val actualizarNombre: (String) -> Unit = { nombre ->

        // 1- actualizar el valor del atributo
        _nombre.value = nombre

        /* 2- si el valor es diferente del estado anterior entonces cambiamos
            el estado del boton de editar */
        _estadoIcono.value =
            if (nombre != PerfilModel.ESTADO_ICONO.EDITAR) PerfilModel.ESTADO_ICONO.GUARDAR
            else PerfilModel.ESTADO_ICONO.EDITAR


    }

    val activarEdicion: (String) -> Unit = { itemPerfil ->

        when (itemPerfil) {
            PerfilModel.ITEMS_PERFIL.NOMBRE -> _estadoIcono.value = PerfilModel.ESTADO_ICONO.GUARDAR
        }
    }

    val guardarEdicion: (String) -> Unit = { itemPerfil ->

        when (itemPerfil) {
            PerfilModel.ITEMS_PERFIL.NOMBRE -> _estadoIcono.value = PerfilModel.ESTADO_ICONO.EDITAR
        }

    }

}