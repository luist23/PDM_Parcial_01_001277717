package com.luist23.pdm_parcial_01.database.repositories

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.luist23.pdm_parcial_01.database.daos.PartidoDao
import com.luist23.pdm_parcial_01.database.entities.Partido
import kotlinx.coroutines.Deferred
import retrofit2.Response

class PartidoRepository (private val partidoDao : PartidoDao){

    /*fun retrieveRepoAsync(user:String): Deferred<Response<List<Partido>>> {
        return PartidoService.getGithubService().getRepos(user)
    }*/

    @WorkerThread
    suspend fun insert(partido:Partido){
        partidoDao.insert(partido)
    }

    fun getAll(): LiveData<List<Partido>> {
        return partidoDao.getAllPartidos()
    }

    @WorkerThread
    suspend fun nuke(){
        return partidoDao.nukeTable()
    }

}