package com.luist23.pdm_parcial_01.database.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.luist23.pdm_parcial_01.database.entities.Partido

@Dao
interface PartidoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(partido: Partido)

    @Query("SELECT*FROM partidos")
    fun getAllPartidos(): LiveData<List<Partido>>

    @Query("DELETE FROM partidos")
    suspend fun nukeTable()

}