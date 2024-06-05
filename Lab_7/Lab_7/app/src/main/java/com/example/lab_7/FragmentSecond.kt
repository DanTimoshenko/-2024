package com.example.lab_7

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.lab_7.FragmentSecondArgs
import com.example.lab_7.databinding.Fragment2Binding

class FragmentSecond : Fragment() {
    private lateinit var binding: Fragment2Binding
    private val args: FragmentSecondArgs by navArgs()

    private var login = ""
    private var password = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = Fragment2Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        login = args.login
        password = args.password
        binding.textView.text = "login: $login\npassword: $password"
    }
}
