package com.example.primeiroprojeto.model

interface MediaStrategy {
    fun calcular(valores: List<Double>, pesos: List<Double> = emptyList()): Double
}