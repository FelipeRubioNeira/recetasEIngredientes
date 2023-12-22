package com.app.recetasEIngredientes.mainMenu.minutas.listadoMinutas

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import com.app.recetasEIngredientes.mainMenu.minutas.nuevaMinuta.NuevaMinutaModel
import com.app.recetasEIngredientes.navegacion.Routes

class ListadoMinutasViewModel(val navController: NavController) : ViewModel() {

    private val _minutas = MutableLiveData<MutableList<NuevaMinutaModel>>()
    val minutas = _minutas

    fun navegarCrearNuevaMinuta() {
        navController.navigate("$Routes.NUEVA_MINUTA?minutaId=")
    }

    fun navegarEditarMinuta(minutaId: Int) {
        navController.navigate("$Routes.NUEVA_MINUTA?minutaId=$minutaId")
    }

    fun agregarMinuta(titulo: String, fecha: String, diasRecetas: Map<String, String>) {

        val nuevaMinuta = NuevaMinutaModel(
            id = (_minutas.value?.size ?: 0) + 1, // cuento cuantos elementos hay en la lista y le sumo 1
            titulo = titulo,
            fecha = fecha,
            dias = diasRecetas,
        )

        // 1- Obtener el valor actual de MutableLiveData
        val listaActual = _minutas.value ?: mutableListOf()

        // 2- Agregar un nuevo elemento a la lista
        listaActual.add(nuevaMinuta)

        // 3- Actualizar el valor de MutableLiveData con la lista modificada
        _minutas.value = listaActual
    }

    fun editarMinuta(
        idMinuta: Int,
        titulo: String,
        fecha: String,
        diasRecetas: Map<String, String>
    ) {

        val minutaEditada = NuevaMinutaModel(
            id = idMinuta,
            titulo = titulo,
            fecha = fecha,
            dias = diasRecetas,
        )

        val indexElemento = _minutas.value?.indexOfFirst { it.id == idMinuta }

        if(indexElemento != -1 && indexElemento != null){
            _minutas.value?.set(indexElemento, minutaEditada)
        }

    }

    fun eliminarMinuta(idMinuta: Int) {
        val nuevaLista = _minutas.value?.filter { it.id != idMinuta }
        _minutas.value = nuevaLista as MutableList<NuevaMinutaModel>?
    }


}