package com.app.recetasEIngredientes.mainMenu.recetas.nuevaReceta

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.app.recetasEIngredientes.mainMenu.recetas.listadoRecetas.ListadoRecetasViewModel

class NuevaRecetaViewModel(
    val _appNavigator: NavController,
    val _listadoRecetasVM: ListadoRecetasViewModel,
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
        limpiarFormulario()
        _appNavigator.popBackStack()
    }

    fun guardarReceta(recetaId: Int = 0) {
        if (recetaId == 0) agregarNuevaReceta()
        else actualizarReceta(recetaId)
    }

    private fun agregarNuevaReceta() {
        _listadoRecetasVM.agregarReceta(
            nombre = nombreReceta.value ?: "",
            descripcion = descripcionReceta.value ?: "",
        )
        goBack()
    }

    private fun actualizarReceta(recetaId: Int) {

        _listadoRecetasVM.actualizarReceta(
            recetaId = recetaId,
            nombre = nombreReceta.value ?: "",
            descripcion = descripcionReceta.value ?: "",
        )
        goBack()
    }

    fun limpiarFormulario() {
        _nombreReceta.value = ""
        _descripcionReceta.value = ""
    }

    fun cargarReceta(recetaId: Int) {

        // si el id es 0, significa que se esta creando una nueva receta
        if (recetaId == 0) return

        val recetaEncontrada = _listadoRecetasVM.listadoRecetas.value?.find { it.id == recetaId }

        if (recetaEncontrada != null) {
            _nombreReceta.value = recetaEncontrada.nombre
            _descripcionReceta.value = recetaEncontrada.descripcion
        }

    }
}