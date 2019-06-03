package com.luist23.pdm_parcial_01

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.luist23.pdm_parcial_01.adapters.PartidosAdapter
import com.luist23.pdm_parcial_01.database.entities.Partido
import com.luist23.pdm_parcial_01.viewmodels.PartidoViewModel
import kotlinx.android.synthetic.main.activity_new_partido.*
import kotlinx.android.synthetic.main.recyclerview_item.*
import java.util.*

class NewPartidoActivity : AppCompatActivity() {

    private lateinit var partidoViewModel: PartidoViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_partido)
        partidoViewModel = ViewModelProviders.of(this).get(PartidoViewModel::class.java)

        bind()
    }

    companion object{

    }

    fun bind(){
        bt_iniciar_partido.setOnClickListener {
            var partido =
                Partido(
                    PartidosAdapter.getPartidos(),
                    textView_teamA.text.toString(),
                    textView_teamB.text.toString(),
                    0,
                    0,
                    Date(et_fecha_año.text.toString().toInt(),et_fecha_mes.text.toString().toInt(),et_fecha_dia.text.toString().toInt()).time.toInt(),
                    et_hora.text.toString().toInt(),
                    ""
                )
            val intent = Intent(this@NewPartidoActivity, NewPartidoActivity::class.java)
            intent.putExtra("partido",partido.toString())
            startActivityForResult(intent,1)


        }

    }
}
