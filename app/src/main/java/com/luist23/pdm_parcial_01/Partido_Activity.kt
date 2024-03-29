package com.luist23.pdm_parcial_01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.aldana.ejemplo14.ScoreViewModel
import com.luist23.pdm_parcial_01.database.entities.Partido
import com.squareup.moshi.Json
import kotlinx.android.synthetic.main.activity_partido.*
import kotlinx.android.synthetic.main.activity_partido.view.*

class Partido_Activity : AppCompatActivity(), LifecycleOwner {
    lateinit var scoreViewModel: ScoreViewModel
    //lateinit var partido = Partido


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_partido)

        //partido = //intent.putExtras("partido")


        scoreViewModel = ViewModelProviders.of(this)
            .get(ScoreViewModel::class.java)

        val scoreObserverA = Observer<Int> { score ->
            // Update the UI, in this case, a TextView.
            tv_score_team_a.text = score.toString()
            //nameTextView.text = newName
        }

        val scoreObserverB = Observer<Int> { score ->
            // Update the UI, in this case, a TextView.
            tv_score_team_b.text = score.toString()
            //nameTextView.text = newName
        }

        scoreViewModel.scoreTeamA.observe(this, scoreObserverA)
        scoreViewModel.scoreTeamB.observe(this, scoreObserverB)

        scoreViewModel.scoreTeamA.setValue(0)
        scoreViewModel.scoreTeamB.setValue(0)


    }



    fun addOneTeamA(v: View) {
        scoreViewModel.scoreTeamA.value = scoreViewModel.scoreTeamA.value?.plus(1)
    }

    fun addOneTeamB(v: View) {
        scoreViewModel.scoreTeamB.value = scoreViewModel.scoreTeamB.value?.plus(1)
    }

    fun addTwoTeamA(v: View) {
        scoreViewModel.scoreTeamA.value = scoreViewModel.scoreTeamA.value?.plus(2)
    }

    fun addTwoTeamB(v: View) {
        scoreViewModel.scoreTeamB.value = (scoreViewModel.scoreTeamB.value)?.plus(2)
    }

    fun addThreeTeamA(v: View) {
        scoreViewModel.scoreTeamA.value = scoreViewModel.scoreTeamA.value?.plus(3)
    }

    fun addThreeTeamB(v: View) {
        scoreViewModel.scoreTeamB.value = scoreViewModel.scoreTeamB.value?.plus(3)
    }

    fun saveScores(v: View) {
        scoreViewModel.partido.value?.puntosA = v.tv_score_team_a.text.toString().toInt()
        scoreViewModel.partido.value?.puntosB = v.tv_score_team_a.text.toString().toInt()
    }

    fun displayScore(v: TextView, score: Int) {
        v.text = score.toString()
    }
}