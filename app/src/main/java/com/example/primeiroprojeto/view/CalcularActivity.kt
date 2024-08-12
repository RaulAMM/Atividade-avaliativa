package com.example.primeiroprojeto.view

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.primeiroprojeto.R
import com.example.primeiroprojeto.model.MediaAritmetica
import com.example.primeiroprojeto.model.MediaHarmonica
import com.example.primeiroprojeto.model.MediaPonderada

class CalcularActivity : AppCompatActivity(){
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.calculo)

    val mediaType = intent.getStringExtra("MEDIA_TYPE") ?: "ARITMETICA"
    val valores = intent.getDoubleArrayExtra("VALORES")?.toList() ?: emptyList()
    val pesos = intent.getDoubleArrayExtra("PESOS")?.toList() ?: emptyList()

    val media: Double = when (mediaType) {
        "ARITMETICA" -> MediaAritmetica().calcular(valores)
        "PONDERADA" -> MediaPonderada().calcular(valores, pesos)
        "HARMONICA" -> MediaHarmonica().calcular(valores)
        else -> 0.0
    }

    val textResultado: TextView = findViewById(R.id.textResultado)
    textResultado.text = "Resultado: $media"
    }
}