package com.app.recetasEIngredientes.mainMenu.recetas.listadoRecetas

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController

class ListadoRecetasViewModel(val navegadorPrincipal: NavController): ViewModel(){

    // --------------------- variables de clase  ---------------------

    private val _modalVisible = MutableLiveData(false)
    val modalVisible = _modalVisible

    private val _valueBusquedaRecetas = MutableLiveData("")
    val valueBusquedaRecetas = _valueBusquedaRecetas



    // --------------------- funciones publicas ---------------------

    fun actualizarValueBusquedaRecetas(nuevoValor: String){
        _valueBusquedaRecetas.value = nuevoValor
    }

    fun mostrarModal(){
        _modalVisible.value = true
    }

    fun cerrarModal(){
        _modalVisible.value = false
    }

    fun navigateTo(ruta: String){
        navegadorPrincipal.navigate(ruta)
    }


}