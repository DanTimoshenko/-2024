package com.example.lab_7

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.lab_7.databinding.Fragment1Binding


class FragmentFirst : Fragment() {
    private lateinit var binding: Fragment1Binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = Fragment1Binding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonToFragment2.setOnClickListener {
            val login = binding.editFragmentLogin.text.toString()
            val password = binding.editFragmentPassword.text.toString()
            val action = FragmentFirstDirections.actionFragment1ToFragment2(login, password)
            findNavController().navigate(action)
        }
    }
}
