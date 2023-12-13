package com.app.recetasEIngredientes.mainMenu.recetas.listadoRecetas

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.app.recetasEIngredientes.mainMenu.recetas.listadoRecetas.model.ListadoRecetasModel
import com.app.recetasEIngredientes.mainMenu.recetas.listadoRecetas.model.Receta

class ListadoRecetasViewModel(val navegadorPrincipal: NavController) : ViewModel() {

    // importamos el model
    val listadoRecetasModel = ListadoRecetasModel()

    private val _listadoRecetas = MutableLiveData(listOf<Receta>())
    val listadoRecetas = _listadoRecetas

    // --------------------- variables de clase  ---------------------

    private val _modalVisible = MutableLiveData(false)
    val modalVisible = _modalVisible

    private val _valueBusquedaRecetas = MutableLiveData("")
    val valueBusquedaRecetas = _valueBusquedaRecetas


    // --------------------- funciones publicas ---------------------

    fun actualizarValueBusquedaRecetas(nuevoValor: String) {
        _valueBusquedaRecetas.value = nuevoValor
    }

    fun mostrarModal() {
        _modalVisible.value = true
    }

    fun cerrarModal() {
        _modalVisible.value = false
    }

    fun navigateTo(ruta: String) {
        navegadorPrincipal.navigate(ruta)
    }

    fun obtenerListadoRecetas(){
        listadoRecetas.value = listadoRecetasModel.obtenerRecetas()
    }


}