package com.example.lab6

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Parcelable
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.lab6.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var student: Student

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val studentParam = intent.getParcelableExtra<Student>("student")
        if (studentParam != null) {
            binding.nameText.setText(student.name)
            binding.courseText.setText(student.course)
        }

        student = Student("Tom Holland", 25)
        binding.button.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            intent.putExtra("student", Student(binding.nameText.text.toString(), binding.courseText.text.toString().toInt()))
            startActivity(intent)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putParcelable("student", student)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        student = savedInstanceState.getParcelable("student")!!
    }
}