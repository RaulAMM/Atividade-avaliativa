package com.example.primeiroprojeto.model

class MediaHarmonica : MediaStrategy {
    override fun calcular(valores: List<Double>, pesos: List<Double>): Double {
        val somaInversos = valores.sumOf { 1 / it }
        return valores.size / somaInversos
    }
}