package com.app.recetasEIngredientes.common.model

/* Dado que las recetas no solo se usan para crear nuevas recetas
    sino tambien para cargar minutas, entonces es necesario declarar esta clase
    en un paquete que sea comun a ambos modulos */
data class Receta(val id: Int, val nombre: String, val descripcion: String) {

}