package com.example.primeiroprojeto.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.primeiroprojeto.R
import com.example.primeiroprojeto.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), OnClickListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val buttonMediaAritmetica: Button = findViewById(R.id.button_media_aritmetica)
        val buttonMediaPonderada: Button = findViewById(R.id.button_media_ponderada)
        val buttonMediaHarmonica: Button = findViewById(R.id.button_media_harmonica)
    }

    override fun onClick(view: View) {
        if(view == binding.buttonMediaAritmetica){
            startActivity(Intent(this, LeitorDeValoresActivity::class.java).apply {
                putExtra("MEDIA_TYPE", "Aritimetica")
            })
        }else if(view == binding.buttonMediaPonderada){
            startActivity(Intent(this, LeitorDeValoresActivity::class.java).apply {
                putExtra("MEDIA_TYPE", "Ponderada")
            })
        }else{
            startActivity(Intent(this, LeitorDeValoresActivity::class.java).apply {
                putExtra("MEDIA_TYPE", "Harmonica")
            })
        }
    }
}