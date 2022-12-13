package com.example.inventoryapps.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.inventoryapps.R
import com.example.inventoryapps.databinding.FragmentRegisterBinding
import com.google.android.material.snackbar.Snackbar

class RegisterFragment: Fragment() {
    private var _binding: FragmentRegisterBinding? = null
    private val binding get() = _binding!!



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View
    {
        _binding = FragmentRegisterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.registerButton.setOnClickListener {
            binding.run {
                if(binding.nameEditText.text.toString().isNotEmpty()
                    && binding.secondNameEditText.text.toString().isNotEmpty()
                    && binding.emailEditText.text.toString().isNotEmpty()
                    && binding.identificationEditText.text.toString().isNotEmpty()
                    && binding.constratisET.text.toString().isNotEmpty()
                    && binding.codeET.text.isNotEmpty()
                    && binding.passwordEditText.text.toString().isNotEmpty()
                    && binding.cargoName.text.toString().isNotEmpty()
                ){
                    var name = binding.nameEditText.text.toString()
                    var secondName = binding.secondNameEditText.text.toString()
                    var email = binding.emailEditText.text.toString()
                    var identificationNumber = binding.identificationEditText.text.toString().toInt()
                    var contratist = binding.constratisET.text.toString()
                    var code = binding.codeET.text.toString().toLong()
                    var cargo = binding.cargoName.text.toString()
                    var password = binding.passwordEditText.text.toString()

                    val bundle = Bundle()
                    bundle.putString("name", binding.nameEditText.text.toString().trim())
                    bundle.putString("secondName", binding.secondNameEditText.text.toString().trim())
                    bundle.putString("email", binding.emailEditText.text.toString().trim())
                    bundle.putInt("identificationNumber", binding.identificationEditText.text.toString().toInt())
                    bundle.putString("contratist", binding.constratisET.text.toString().trim())
                    bundle.putLong("code", binding.codeET.text.toString().toLong())
                    bundle.putString("cargo", binding.cargoName.text.toString().trim())
                    bundle.putString("password", binding.passwordEditText.text.toString().trim())
                    parentFragmentManager.setFragmentResult("key", bundle)
                    Navigation.findNavController(this@RegisterFragment.requireView()).navigateUp()
                } else {
                    Snackbar.make(view, this@RegisterFragment.requireContext().getText(R.string.fill_user), Snackbar.LENGTH_LONG).show()
                }
            }
        }

    }

}