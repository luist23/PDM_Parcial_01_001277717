package com.aldana.ejemplo14

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.luist23.pdm_parcial_01.database.entities.Partido

class ScoreViewModel : ViewModel() {
    var scoreTeamA = MutableLiveData<Int>()
    var scoreTeamB = MutableLiveData<Int>()
    var partido = MutableLiveData<Partido>()
}