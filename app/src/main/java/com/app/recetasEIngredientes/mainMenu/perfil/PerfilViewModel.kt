package com.app.recetasEIngredientes.mainMenu.perfil

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PerfilViewModel : ViewModel() {


    // -------------------------- atributos --------------------------

    // .. valores de los items del perfil
    private val _nombre = MutableLiveData<String>()
    val nombre = _nombre

    private val _edad = MutableLiveData<String>()
    val edad = _edad

    private val _peso = MutableLiveData<String>()
    val peso = _peso

    private val _altura = MutableLiveData<String>()
    val altura = _altura

    private val _sexo = MutableLiveData<String>()
    val sexo = _sexo

    private val _actividadFisica = MutableLiveData<String>()
    val actividadFisica = _actividadFisica


    // .. estado de los iconos de los items del perfil
    private val _estadoIconoNombre = MutableLiveData(PerfilModel.ESTADO_ICONO.EDITAR)
    val estadoIconoNombre = _estadoIconoNombre

    private val _estadoIconoEdad = MutableLiveData(PerfilModel.ESTADO_ICONO.EDITAR)
    val estadoIconoEdad = _estadoIconoEdad

    private val _estadoIconoPeso = MutableLiveData(PerfilModel.ESTADO_ICONO.EDITAR)
    val estadoIconoPeso = _estadoIconoPeso

    private val _estadoIconoAltura = MutableLiveData(PerfilModel.ESTADO_ICONO.EDITAR)
    val estadoIconoAltura = _estadoIconoAltura

    private val _estadoIconoSexo = MutableLiveData(PerfilModel.ESTADO_ICONO.EDITAR)
    val estadoIconoSexo = _estadoIconoSexo



    // -------------------------- metodos --------------------------

    val actualizarValor: (String, String) -> Unit = { itemPerfil, valor ->

        when (itemPerfil) {
            PerfilModel.ITEMS_PERFIL.NOMBRE -> _nombre.value = valor
            PerfilModel.ITEMS_PERFIL.EDAD -> _edad.value = valor
            PerfilModel.ITEMS_PERFIL.PESO -> _peso.value = valor
            PerfilModel.ITEMS_PERFIL.SEXO -> _sexo.value = valor
            PerfilModel.ITEMS_PERFIL.ALTURA -> _altura.value = valor
            PerfilModel.ITEMS_PERFIL.ACTIVIDAD_FISICA -> _actividadFisica.value = valor
        }

    }

    val activarEdicion: (String) -> Unit = { itemPerfil ->

        when (itemPerfil) {
            PerfilModel.ITEMS_PERFIL.NOMBRE -> _estadoIconoNombre.value = PerfilModel.ESTADO_ICONO.GUARDAR
            PerfilModel.ITEMS_PERFIL.EDAD -> _estadoIconoEdad.value = PerfilModel.ESTADO_ICONO.GUARDAR
            PerfilModel.ITEMS_PERFIL.PESO -> _estadoIconoPeso.value = PerfilModel.ESTADO_ICONO.GUARDAR
            PerfilModel.ITEMS_PERFIL.ALTURA -> _estadoIconoAltura.value = PerfilModel.ESTADO_ICONO.GUARDAR
            PerfilModel.ITEMS_PERFIL.SEXO -> _estadoIconoSexo.value = PerfilModel.ESTADO_ICONO.GUARDAR
        }
    }

    val guardarEdicion: (String) -> Unit = { itemPerfil ->

        when (itemPerfil) {
            PerfilModel.ITEMS_PERFIL.NOMBRE -> _estadoIconoNombre.value = PerfilModel.ESTADO_ICONO.EDITAR
            PerfilModel.ITEMS_PERFIL.EDAD -> _estadoIconoEdad.value = PerfilModel.ESTADO_ICONO.EDITAR
            PerfilModel.ITEMS_PERFIL.PESO -> _estadoIconoPeso.value = PerfilModel.ESTADO_ICONO.EDITAR
            PerfilModel.ITEMS_PERFIL.ALTURA -> _estadoIconoAltura.value = PerfilModel.ESTADO_ICONO.EDITAR
            PerfilModel.ITEMS_PERFIL.SEXO -> _estadoIconoSexo.value = PerfilModel.ESTADO_ICONO.EDITAR
        }

    }

}