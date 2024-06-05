package com.example.lab_8

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.lab_8.databinding.AnimalDetailsBinding

class AnimalDetailsActivity : AppCompatActivity() {
    private lateinit var binding: AnimalDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = AnimalDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val animalName = intent.getStringExtra("animalName")
        binding.animalDetailsButton.text = animalName
    }
}
