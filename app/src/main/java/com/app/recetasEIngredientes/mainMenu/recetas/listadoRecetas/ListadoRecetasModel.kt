package com.app.recetasEIngredientes.mainMenu.recetas.listadoRecetas

import com.app.recetasEIngredientes.common.model.Receta

class ListadoRecetasModel {

    /* de momento vamos a crear un listado en duro,
        pero este metodo se encarga de buscar donde sea necesario la informacion*/
    fun obtenerRecetas(): List<Receta> {

        val listadoRecetas = listOf(
            Receta(1, "Cazuela de Vacuno", "Guiso tradicional con carne, verduras y maíz."),
            Receta(2, "Cazuela de Pollo", "Guiso tradicional con ave, verduras y papa."),
            Receta(3, "Empanadas de Pino", "Empanadas de carne molida, cebolla, huevo y aceituna."),
            Receta(4, "Porotos Granados", "Guiso de porotos con zapallo, choclo y albahaca."),
            Receta(5, "Pastel de Choclo", "Pastelera de choclo con carne, cebolla, huevo y aceituna."),
            Receta(6, "Tallarines", "Pasta con salsa de tomate y carne."),
            Receta(7, "Charquicán", "Guiso de carne, verduras y papas."),
            Receta(8, "Humitas", "Pasta de choclo envuelta en hojas de choclo."),
        )

        return listadoRecetas

    }

}
