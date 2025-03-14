package com.app.recetasEIngredientes.mainMenu.recetas.listadoRecetas

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.app.recetasEIngredientes.common.model.Receta
import com.app.recetasEIngredientes.navegacion.Routes

class ListadoRecetasViewModel(val navegadorPrincipal: NavController) : ViewModel() {


    // --------------------- atributos  ---------------------
    val listadoRecetasModel = ListadoRecetasModel()

    private val _listadoRecetasOriginal = MutableLiveData(mutableListOf<Receta>())
    val listadoRecetasOriginal = _listadoRecetasOriginal
    private val _listadoRecetas = MutableLiveData(mutableListOf<Receta>())
    val listadoRecetas = _listadoRecetas


    private val _modalVisible = MutableLiveData(false)
    val modalVisible = _modalVisible


    private val _valueBusquedaRecetas = MutableLiveData("")
    val valueBusquedaRecetas = _valueBusquedaRecetas


    // --------------------- metodos ---------------------
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

        Log.d("agregarReceta", "se ha llamado a buscarReceta()")

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

    fun navegarCrearReceta() {
        navigateTo(Routes.NuevaReceta.sinParametro())
    }

    fun navegarEditarReceta(idReceta: Int) {
        val recetaParaEditar = _listadoRecetasOriginal.value?.find { it.id == idReceta }
        navigateTo(Routes.NuevaReceta.conParametro(recetaParaEditar?.id ?: 0))
    }

    fun obtenerListadoRecetas() {

        if (_listadoRecetas.value?.size!! > 0) return

        _listadoRecetasOriginal.value = listadoRecetasModel.obtenerRecetas().toMutableList()
        _listadoRecetas.value = listadoRecetasModel.obtenerRecetas().toMutableList()
    }

    fun agregarReceta(nombre: String, descripcion: String) {

        val nuevaReceta = Receta(
            id = (_listadoRecetas.value?.size ?: 0) + 1,
            nombre = nombre,
            descripcion = descripcion,
        )

        // 1- Obtener el valor actual de MutableLiveData
        val listaActual = _listadoRecetasOriginal.value ?: mutableListOf()

        // 2- Agregar un nuevo elemento a la lista
        listaActual.add(nuevaReceta)

        // 3- Actualizar el valor de MutableLiveData con la lista modificada
        _listadoRecetas.value = listaActual
        _listadoRecetasOriginal.value = listaActual

    }

    fun actualizarReceta(recetaId: Int, nombre: String, descripcion: String) {

        val recetaEditada = Receta(
            id = recetaId,
            nombre = nombre,
            descripcion = descripcion,
        )

        val indexElemento = _listadoRecetasOriginal.value?.indexOfFirst { it.id == recetaId }

        if (indexElemento != -1 && indexElemento != null) {
            _listadoRecetasOriginal.value?.set(indexElemento, recetaEditada)
            _listadoRecetas.value = _listadoRecetasOriginal.value?.toMutableList()
        }

    }

    fun eliminarReceta(idReceta: Int) {
        _listadoRecetas.value =
            _listadoRecetasOriginal.value?.filter { it.id != idReceta }?.toMutableList()
        _listadoRecetasOriginal.value = _listadoRecetas.value?.toMutableList()
    }


}