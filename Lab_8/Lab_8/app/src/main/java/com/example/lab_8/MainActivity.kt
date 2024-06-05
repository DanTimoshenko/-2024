package com.example.lab_8

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lab_8.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)

        binding.recyclerViewVert.layoutManager = LinearLayoutManager(this)
        val animals = listOf(
            Pair("Cat", "https://images.unsplash.com/photo-1495360010541-f48722b34f7d"),
            Pair("Dog", "https://images.unsplash.com/photo-1530281700549-e82e7bf110d6"),
            Pair("Wolf", "https://images.unsplash.com/photo-1559736139-6531cc82432e"),
            Pair("Elephant", "https://images.unsplash.com/photo-1557050543-4d5f4e07ef46?q=80&w=1932&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"),
        )

        val adapter = AnimalAdapter(animals){ position: Int ->
            val intent = Intent(this, AnimalDetailsActivity::class.java)
            intent.putExtra("animalName", animals[position].first)
            startActivity(intent)
        }

        binding.recyclerViewVert.adapter = adapter
        binding.recyclerViewHor.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        val animalsNames = listOf(
            "Cat",
            "Dog",
            "Wolf",
            "Elephant",
        )
        val adapterSecond = HorizontalViewAdapter(animalsNames)
        binding.recyclerViewHor.adapter = adapterSecond
    }
}