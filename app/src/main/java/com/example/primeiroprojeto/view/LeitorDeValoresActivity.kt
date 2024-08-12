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
import com.example.primeiroprojeto.view.adapters.ValorAdapter

class LeitorDeValoresActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ValorAdapter
    private val valores = mutableListOf<Double>()

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.leitor_de_valores)

        recyclerView = findViewById(R.id.recyclerViewValores)
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = ValorAdapter(valores)
        recyclerView.adapter = adapter

        val buttonAdd: Button = findViewById(R.id.buttonAdicionar)
        val editValor: EditText = findViewById(R.id.editTextValores)

        buttonAdd.setOnClickListener {
            val value = editValor.text.toString().toDoubleOrNull()
            if (value != null) {
                valores.add(value)
                adapter.notifyDataSetChanged()
                editValor.text.clear()
            }
        }

        val buttonCalcular: Button = findViewById(R.id.buttonCalcular)
        buttonCalcular.setOnClickListener {
            val mediaType = intent.getStringExtra("MEDIA_TYPE") ?: "Aritimetica"
            startActivity(Intent(this, PesosActivity::class.java).apply {
                putExtra("MEDIA_TYPE", mediaType)
                putExtra("VALORES", valores.toDoubleArray())
            })
        }

    }

}