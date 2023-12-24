package com.app.recetasEIngredientes.mainMenu.perfil

class PerfilModel {

    fun obtenerDatosPerfil(): List<ItemPerfil> {

        return listOf(
            ItemPerfil(preguntaId = 1, pregunta = "Edad", respuesta = ""),
        )
    }

}

/* corresponde a las preguntas que vienen en el perfil
*   - Edad
*   - Peso
*   - Sexo
*     etc
* */
data class ItemPerfil(
    val preguntaId: Int,
    val pregunta: String,
    val respuesta: String
)