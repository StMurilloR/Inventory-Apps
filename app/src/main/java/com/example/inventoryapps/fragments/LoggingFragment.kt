package com.example.inventoryapps.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.fragment.app.Fragment
import com.example.inventoryapps.R
import com.example.inventoryapps.databinding.FragmentLoggingBinding
import com.google.android.material.snackbar.Snackbar

class LoggingFragment : Fragment() {

    private var _binding: FragmentLoggingBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View
    {
        _binding = FragmentLoggingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.profileButton.setOnClickListener {
            if(binding.emailEditText.text.toString().isNotEmpty()
                    && binding.passwordEditText.text.toString().isNotEmpty()
            ){
                var name = binding.emailEditText.text.toString()
                var password = binding.passwordEditText.text.toString()
                Navigation.findNavController(this.requireView()).navigate(R.id.action_loggingFragment_to_profileFragment)
            } else {
            Snackbar.make(view, this.requireContext().getText(R.string.fill_user), Snackbar.LENGTH_LONG).show()
            }

        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}