package com.example.primeiroprojeto.view

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.primeiroprojeto.R
import com.example.primeiroprojeto.view.adapters.PesoAdapter

class PesosActivity  : AppCompatActivity(){
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: PesoAdapter
    private val pesos = mutableListOf<Double>()

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.pesos)

        recyclerView = findViewById(R.id.recyclerViewPesos)
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = PesoAdapter(pesos)
        recyclerView.adapter = adapter

        val buttonAdd: Button = findViewById(R.id.buttonAdicionar)
        val editPeso: EditText = findViewById(R.id.editTextPesos)

        buttonAdd.setOnClickListener {
            val peso = editPeso.text.toString().toDoubleOrNull()
            if (peso != null) {
                pesos.add(peso)
                adapter.notifyDataSetChanged()
                editPeso.text.clear()
            }
        }

        val btnCalculate: Button = findViewById(R.id.buttonCalcular)
        btnCalculate.setOnClickListener {
            val mediaType = intent.getStringExtra("MEDIA_TYPE") ?: "ARITMETICA"
            val valores = intent.getDoubleArrayExtra("VALORES")?.toList() ?: emptyList()
            startActivity(Intent(this, CalcularActivity::class.java).apply {
                putExtra("MEDIA_TYPE", mediaType)
                putExtra("VALORES", valores.toDoubleArray())
                putExtra("PESOS", pesos.toDoubleArray())
            })
        }
    }
}