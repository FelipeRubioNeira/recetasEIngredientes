package com.app.recetasEIngredientes.mainMenu.minutas.nuevaMinuta

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.app.recetasEIngredientes.mainMenu.minutas.listadoMinutas.ListadoMinutasViewModel
import java.time.LocalDate


/*
    Gestiona la informacion y las acciones para la pantalla de minutas

*/

class NuevaMinutaViewModel(
    val _navController: NavController,
    val _listadoMinutasVM: ListadoMinutasViewModel,
) : ViewModel() {


    // ------------------------------ variables locales ----------------------------------------------------

    private val _tituloPantalla = MutableLiveData<String> ()
    val tituloPantalla = _tituloPantalla

    // titulo de la minuta
    private val _tituloMinuta = MutableLiveData<String>()
    val tituloMinuta = _tituloMinuta

    // fecha de la minuta
    @RequiresApi(Build.VERSION_CODES.O)
    private val _fechaMinuta = MutableLiveData(LocalDate.now())

    @RequiresApi(Build.VERSION_CODES.O)
    val fechaMinuta = _fechaMinuta

    // valores seleccionados para cada dia
    private val _diasRecetas = MutableLiveData(mapOf<String, String>())
    val diasRecetas = _diasRecetas

    // dia seleccionado en el selector desplegable
    private val _diaSeleccionado = MutableLiveData<String>()

    private val _modalRecetasVisible = MutableLiveData<Boolean>()
    val modalRecetasVisible = _modalRecetasVisible

    private val _esNuevaMinuta = MutableLiveData<Boolean>()
    val esNuevaMinuta = _esNuevaMinuta

    // ------------------------------ fin de las variables -----------------------------------------

    fun goBack() {
        _navController.popBackStack()
    }

    fun setTituloMinuta(titulo: String) {
        _tituloMinuta.value = titulo
    }

    fun mostrarModalRecetas(nombreDia: String) {

        // guardar el nombre del dia seleccionado en el selector desplegable
        _diaSeleccionado.value = nombreDia

        // mostrar el modal
        _modalRecetasVisible.value = true
    }

    fun seleccionarReceta(valor: String) {
        val dia = _diaSeleccionado.value ?: return

        // esto como decirle al mapa que agregue un valor donde dia es la clave y valor es el valor
        // mapa = mapa + (clave to valor)
        _diasRecetas.value = _diasRecetas.value?.plus((dia to valor))

        _modalRecetasVisible.value = false
    }

    fun ocultarModalRecetas() {
        _modalRecetasVisible.value = false
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun agregarNuevaMinuta() {

        _listadoMinutasVM.agregarMinuta(
            titulo = _tituloMinuta.value ?: "",
            fecha = _fechaMinuta.value.toString(),
            diasRecetas = _diasRecetas.value ?: mapOf()
        )

        goBack()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun editarMinuta(minutaId: Int) {

        _listadoMinutasVM.editarMinuta(
            idMinuta = minutaId,
            titulo = _tituloMinuta.value ?: "",
            fecha = _fechaMinuta.value.toString(),
            diasRecetas = _diasRecetas.value ?: mapOf()
        )

        goBack()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun resetearFormulario() {
        _tituloPantalla.value = "Nueva minuta"
        _tituloMinuta.value = "Nueva minuta"
        _fechaMinuta.value = LocalDate.now()
        _diasRecetas.value = mapOf()
        _esNuevaMinuta.value = true
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun cargarMinuta(minutaId: Int) {

        if (minutaId == 0) return

        val minutaEncontrada = _listadoMinutasVM.minutas.value?.find { it.id == minutaId }

        if (minutaEncontrada != null) {
            _tituloPantalla.value = "Editar minuta"
            _tituloMinuta.value = minutaEncontrada.titulo
            _fechaMinuta.value = LocalDate.parse(minutaEncontrada.fecha)
            _diasRecetas.value = minutaEncontrada.dias
        }

        _esNuevaMinuta.value = false

    }

}