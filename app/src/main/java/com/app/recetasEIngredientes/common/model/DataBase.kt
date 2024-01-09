package com.app.recetasEIngredientes.common.model

import androidx.room.Database
import androidx.room.RoomDatabase
import com.app.recetasEIngredientes.mainMenu.minutas.listadoMinutas.Semana
import com.app.recetasEIngredientes.mainMenu.minutas.listadoMinutas.SemanaDao

/* Clase que representa la base de datos de la aplicacion */
@Database(
    entities = [Semana::class], // lista de entidades que se van a guardar en la base de datos
    version = 1
)
abstract class DataBase : RoomDatabase() {

    abstract val dao: SemanaDao
}