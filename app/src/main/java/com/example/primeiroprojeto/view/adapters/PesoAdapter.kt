package com.example.primeiroprojeto.view.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.primeiroprojeto.R

class PesoAdapter (private val pesos: List<Double>) : RecyclerView.Adapter<PesoAdapter.ViewHolder>(){
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val textPeso: TextView = itemView.findViewById(R.id.textPeso)

        fun bind(peso: Double) {
            textPeso.text = peso.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.peso_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(pesos[position])
    }

    override fun getItemCount(): Int = pesos.size
}