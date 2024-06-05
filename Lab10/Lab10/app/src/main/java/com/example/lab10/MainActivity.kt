package com.example.lab10

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.lab10.databinding.ActivityMainBinding
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getTodos()

        binding.button.setOnClickListener {
            addTodo()
        }
    }

    private fun getTodos(){
        val retrofit = RetrofitClient.getInstance()
        val apiInterface = retrofit.create(ApiInterface::class.java)
        lifecycleScope.launch {
            val response = apiInterface.getTodo(1)
            binding.textView.text = response.body()?.title
        }
    }

    private fun addTodo(){
        val retrofit = RetrofitClient.getInstance()
        val apiInterface = retrofit.create(ApiInterface::class.java)
        lifecycleScope.launch {
            try {
                val todo = Todo(
                    id = binding.todoId.text.toString().toInt(),
                    title = binding.todoTitle.text.toString(),
                    userId = binding.userId.text.toString().toInt(),
                    completed = false
                )
                val response = apiInterface.addUser(todo)
                if (response.isSuccessful && response.body() != null) {
                    Toast.makeText(applicationContext, "new todo: (${response.body()?.id}) added", Toast.LENGTH_SHORT).show()
                }
            } catch (Ex: Exception) {
                Toast.makeText(applicationContext, "error adding todo", Toast.LENGTH_SHORT).show()
            }
        }
    }
}