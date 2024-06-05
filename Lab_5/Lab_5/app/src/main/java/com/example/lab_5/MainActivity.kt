package com.example.lab_5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import com.example.lab_5.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button1.setOnClickListener {
            showText("Button 1 OnClickListener called")
        }

        binding.button2.setOnClickListener {
            showText("Button 2 OnClickListener called")
        }

        binding.editText.setOnFocusChangeListener { v, hasFocus ->
            if (hasFocus) {
                showText("EditText has focus")
            } else {
                showText("EditText lost focus")
            }
        }

        binding.editText2.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                showText("beforeTextChanged called")
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                showText("onTextChanged called: ${s.toString()}")
            }

            override fun afterTextChanged(s: Editable?) {
                binding.textView.text = s.toString()
                showText("afterTextChanged called")
            }
        })
    }

    private fun showText(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}