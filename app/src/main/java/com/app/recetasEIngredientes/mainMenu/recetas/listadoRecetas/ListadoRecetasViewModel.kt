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

    private val _listadoRecetasOriginal = MutableLiveData(listOf<Receta>())
    private val _listadoRecetas = MutableLiveData(mutableListOf<Receta>())
    val listadoRecetas = _listadoRecetas

    // --------------------- variables de clase  ---------------------

    private val _modalVisible = MutableLiveData(false)
    val modalVisible = _modalVisible

    private val _valueBusquedaRecetas = MutableLiveData("")
    val valueBusquedaRecetas = _valueBusquedaRecetas


    // --------------------- funciones publicas ---------------------


    fun buscarReceta(valorBusqueda: String) {

        // 1- actualizar el valor de la variable de clase
        _valueBusquedaRecetas.value = valorBusqueda

        // 2- filtrar el listado de recetas
        if (valorBusqueda.isEmpty()) {
            _listadoRecetas.value = _listadoRecetasOriginal.value?.toMutableList()

        } else {
            _listadoRecetas.value = _listadoRecetasOriginal.value?.filter {
                it.nombre.contains(valorBusqueda, ignoreCase = true)
                        || it.descripcion.contains(valorBusqueda, ignoreCase = true)
            }?.toMutableList()

        }

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

    fun obtenerListadoRecetas() {
        _listadoRecetasOriginal.value = listadoRecetasModel.obtenerRecetas()
        _listadoRecetas.value = listadoRecetasModel.obtenerRecetas().toMutableList()
    }


}