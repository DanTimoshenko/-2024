package com.example.Lab9

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.room.Room
import com.example.Lab9.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    companion object {
        lateinit var database: GradesDB
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        database = Room.databaseBuilder(
            applicationContext,
            GradesDB::class.java, "grades_db"
        ).build()
        val gradesDao = database.gradesDao()

        binding.allPlans.setOnClickListener{
            GlobalScope.launch {
                val grades = gradesDao.getAll()
                var gradesInfo = ""
                grades.forEach{
                    gradesInfo += "${it.id}: ${it.name} ${it.mark} ${it.markDate}\n"
                }
                runOnUiThread{
                    binding.textView.text = gradesInfo
                }
            }
        }

        binding.addBtn.setOnClickListener{
            val name = binding.name.text.toString()
            val mark = binding.mark.text.toString().toInt()
            val markDate = binding.markDate.text.toString()
            val grades = Grades(name = name, mark = mark, markDate = markDate)
            GlobalScope.launch {
                gradesDao.insertAll(grades)
            }
            Toast.makeText( applicationContext, "Grade added", Toast.LENGTH_LONG).show()
        }

        binding.deleteButton.setOnClickListener{
            val gradeId = binding.idText.text.toString().toIntOrNull()

            if (gradeId == null || gradeId < 0) {
                Toast.makeText(this, "Invalid index.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            lifecycleScope.launch(Dispatchers.IO) {
                gradesDao.deleteById(gradeId)
            }
        }
    }
}

