package com.luist23.pdm_parcial_01.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.luist23.pdm_parcial_01.R
import com.luist23.pdm_parcial_01.database.entities.Partido


class PartidosAdapter internal constructor(
    context: Context
) : RecyclerView.Adapter<PartidosAdapter.PartidoViewHolder>() {



    private val inflater: LayoutInflater = LayoutInflater.from(context)


    inner class PartidoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val teamA: TextView = itemView.findViewById(R.id.textView_teamA)
        val teamB: TextView = itemView.findViewById(R.id.textView_teamB)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PartidoViewHolder {
        val itemView = inflater.inflate(R.layout.recyclerview_item, parent, false)
        return PartidoViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: PartidoViewHolder, position: Int) {
        val current = partidos[position]
        holder.teamA.text = current.equipoA
        holder.teamB.text = current.equipoB
    }

    internal fun setWords(partido: List<Partido>) {
        partidos = partido
        notifyDataSetChanged()
    }

    override fun getItemCount() = partidos.size

    companion object{
        private var partidos = emptyList<Partido>() // Cached copy of words
        fun getPartidos() : Int = partidos.size
    }
}