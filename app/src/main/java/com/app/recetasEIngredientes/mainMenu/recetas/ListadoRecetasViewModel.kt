package com.app.recetasEIngredientes.mainMenu.recetas

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ListadoRecetasViewModel: ViewModel(){

    // --------------------- variables de clase  ---------------------

    private val _modalVisible = MutableLiveData(false)
    val modalVisible = _modalVisible




    // --------------------- funciones publicas ---------------------
    fun mostrarModal(){
        _modalVisible.value = true
    }

    fun cerrarModal(){
        _modalVisible.value = false
    }


}