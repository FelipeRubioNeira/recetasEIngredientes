package com.app.recetasEIngredientes.mainMenu.minutas.nuevaMinuta

data class NuevaMinutaModel(
    val id: Int,
    val titulo: String,
    val fecha: String,
    val dias: Map<String, String>
)