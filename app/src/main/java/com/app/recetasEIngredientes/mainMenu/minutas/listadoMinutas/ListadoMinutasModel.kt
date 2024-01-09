package com.app.recetasEIngredientes.mainMenu.minutas.listadoMinutas

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Query
import androidx.room.Upsert

@Entity(tableName = "semana")
data class Semana(
    @PrimaryKey(autoGenerate = true)
    val sem_id: Int? = 0, // id de la minuta
    val sem_titulo: String,
    val sem_fecha: String,
) {
}

@Dao
interface SemanaDao {
    @Query("SELECT * FROM semana ORDER BY sem_id ASC")
    fun selectAll(): List<Semana>

    @Upsert()
    suspend fun insert(semana: Semana)

    @Delete
    suspend fun delete(sem_id: Int?)
}