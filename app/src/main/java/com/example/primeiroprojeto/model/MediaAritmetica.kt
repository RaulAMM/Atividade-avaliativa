package com.example.primeiroprojeto.model

class MediaAritmetica : MediaStrategy{
    override fun calcular(valores: List<Double>, pesos: List<Double>): Double {
        return valores.average()
    }
}