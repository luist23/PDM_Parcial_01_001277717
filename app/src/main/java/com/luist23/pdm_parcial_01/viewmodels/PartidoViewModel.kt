package com.luist23.pdm_parcial_01.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.luist23.pdm_parcial_01.database.PartidoRoomDatabase
import com.luist23.pdm_parcial_01.database.entities.Partido
import com.luist23.pdm_parcial_01.database.repositories.PartidoRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PartidoViewModel (app :Application) : AndroidViewModel(app){

    private val repository : PartidoRepository

    val Partidos : LiveData<List<Partido>>

    init {
        val partidoDao = PartidoRoomDatabase.getDatabase(app, viewModelScope).partidoDao()
        repository = PartidoRepository(partidoDao)
        Partidos = repository.getAll()
    }

    fun insert(partido: Partido) = viewModelScope.launch(Dispatchers.IO) {
        repository.insert(partido)
    }

    fun getAll(): LiveData<List<Partido>> {
        return repository.getAll()
    }

}