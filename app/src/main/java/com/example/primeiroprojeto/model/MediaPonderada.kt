package com.example.primeiroprojeto.model

class MediaPonderada : MediaStrategy {
    override fun calcular(valores: List<Double>, pesos: List<Double>): Double {
        if (valores.size != pesos.size) throw IllegalArgumentException("Número de valores e pesos deve ser o mesmo")
        val somaPesos = pesos.sum()
        val somaPonderada = valores.zip(pesos).sumOf { it.first * it.second }
        return somaPonderada / somaPesos
    }
}