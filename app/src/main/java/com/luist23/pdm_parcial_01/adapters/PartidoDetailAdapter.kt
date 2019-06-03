package com.luist23.pdm_parcial_01.adapters;

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.luist23.pdm_parcial_01.R
import com.luist23.pdm_parcial_01.Utilities.Utils
import com.luist23.pdm_parcial_01.database.entities.Partido
import kotlinx.android.synthetic.main.recyclerview_partido_details.view.*
import okhttp3.internal.Util

class PartidoDetailAdapter (var partidos: List<Partido>, val clickListener: (Partido) -> Unit)
        : RecyclerView.Adapter<PartidoDetailAdapter.PartidoViewHolder>() ,Utils {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PartidoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_partido_details, parent, false)

        return PartidoViewHolder(view)
        }

        override fun getItemCount(): Int = partidos.size

        override fun onBindViewHolder(holder: PartidoViewHolder, position: Int) = holder.bind(partidos[position], clickListener)

        override fun changeDataSet(newDataSet: List<Partido>) {
        this.partidos = newDataSet
        notifyDataSetChanged()
        }
   /*fun setBooks(book: List<Book>){
        this.books = books
        notifyDataSetChanged()

    }*/

class PartidoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(partido: Partido, clickListener: (Partido) -> Unit) = with(itemView) {
                textView_teamA_detail.text = partido.equipoA
                textView_teamB_detail.text = partido.equipoB
                itemView.setOnClickListener { clickListener(partido) }
        }
}
}