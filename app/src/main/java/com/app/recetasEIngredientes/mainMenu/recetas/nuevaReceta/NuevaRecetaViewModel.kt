package com.app.recetasEIngredientes.mainMenu.recetas.nuevaReceta

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.app.recetasEIngredientes.mainMenu.recetas.listadoRecetas.ListadoRecetasViewModel

class NuevaRecetaViewModel(
    val appNavigator: NavController,
    val listadoRecetasVM: ListadoRecetasViewModel,
) : ViewModel() {


    // ------------------------------ variables locales ------------------------------------
    private val _nombreReceta = MutableLiveData("")
    val nombreReceta = _nombreReceta

    private val _descripcionReceta = MutableLiveData("")
    val descripcionReceta = _descripcionReceta


    // ------------------------------ funciones -----------------------------------------

    fun setNombreReceta(nombre: String) {
        _nombreReceta.value = nombre
    }

    fun setDescripcionReceta(descripcion: String) {
        _descripcionReceta.value = descripcion
    }

    fun goBack() {
        appNavigator.popBackStack()
    }

    fun agregarNuevaReceta() {

        listadoRecetasVM.agregarReceta(
            nombre = nombreReceta.value ?: "",
            descripcion = descripcionReceta.value ?: "",
        )
        limpiarFormulario()
        goBack()

    }

    fun limpiarFormulario (){
        _nombreReceta.value = ""
        _descripcionReceta.value = ""
    }
}