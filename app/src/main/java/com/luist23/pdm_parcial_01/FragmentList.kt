package com.luist23.pdm_parcial_01

import android.content.Context
import android.content.res.Configuration
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.luist23.pdm_parcial_01.adapters.PartidoDetailAdapter
import com.luist23.pdm_parcial_01.adapters.PartidoListAdapter
import com.luist23.pdm_parcial_01.adapters.PartidosAdapter
import com.luist23.pdm_parcial_01.database.entities.Partido
import com.luist23.pdm_parcial_01.viewmodels.PartidoViewModel
import kotlinx.android.synthetic.main.content_main.view.*


class FragmentList : Fragment() {

    private lateinit var viewModel: PartidoViewModel
    private val partidosList = ArrayList<Partido>()
    private lateinit var partidoAdapter: PartidoListAdapter
    private var listenerTools: ListenerTools? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.content_main, container, false)

        initRecyclerView(resources.configuration.orientation, view)

        return view
    }



    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is ListenerTools) {
            listenerTools = context
        } else {
            throw RuntimeException("Se necesita una implementación de la interfaz")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listenerTools = null
    }


    interface ListenerTools {
        fun portraitClick(partido: Partido)
        fun landscapeClick(partido: Partido)
    }







    fun initRecyclerView(orientation: Int, container: View) {
        val gridLayoutManager = GridLayoutManager(this.context, 2)
        val linearLayoutManager = LinearLayoutManager(this.context)
        val recyclerView = container.recyclerview



        if (orientation == Configuration.ORIENTATION_PORTRAIT) {
            partidoAdapter = PartidoListAdapter(
                partidos = partidosList,
                clickListener = { partido: Partido -> listenerTools?.portraitClick(partido) })
            recyclerView.apply {
                adapter = partidoAdapter as PartidoListAdapter
                setHasFixedSize(true)
                layoutManager = linearLayoutManager//gridLayoutManager
            }
        } else {
            val partidoAdapter = PartidoDetailAdapter(
                partidos = partidosList,
                clickListener = { partido: Partido -> listenerTools?.landscapeClick(partido) })
            recyclerView.apply {
                adapter = partidoAdapter as PartidoDetailAdapter
                setHasFixedSize(true)
                layoutManager = linearLayoutManager
            }

        }

        viewModel = ViewModelProviders.of(this).get(PartidoViewModel::class.java)

        /*var partidosLista: List<Partido>

        viewModel.getAll().observe(this, Observer { partidos ->
            partidos?.let {
                var all: ArrayList<Partido> = ArrayList<Partido>()
//                Log.i("BOOKTABLE",viewModel.getAllBooks().value.toString())
                partidosLista=partidos
            }
        })*/
    }


}
