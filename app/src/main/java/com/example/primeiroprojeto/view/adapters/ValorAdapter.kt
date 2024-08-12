package com.example.primeiroprojeto.view.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.primeiroprojeto.R

class ValorAdapter (private val valores: List<Double>) : RecyclerView.Adapter<ValorAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val textValor: TextView = itemView.findViewById(R.id.textValor)

        fun bind(valor: Double) {
            textValor.text = valor.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.valor_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(valores[position])
    }

    override fun getItemCount(): Int = valores.size
}
