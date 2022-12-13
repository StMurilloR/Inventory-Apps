package com.example.inventoryapps.fragments

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.inventoryapps.R
import com.example.inventoryapps.databinding.FragmentOrderBinding
import com.google.android.material.snackbar.Snackbar

class OrderFragment: Fragment() {
    private var _binding: FragmentOrderBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View
    {
        _binding = FragmentOrderBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.sendButton.setOnClickListener {
            if (binding.editText.text.toString().isNotEmpty() && binding.editText2.text.toString().isNotEmpty()
                && binding.editText4.text.toString().isNotEmpty()){
                if((binding.editText.text.toString() == "M000" && binding.editText4.text.toString().toInt() >= 3201)
                    || (binding.editText.text.toString() == "M001" && binding.editText4.text.toString().toInt() >= 2801)
                    || (binding.editText.text.toString() == "C000" && binding.editText4.text.toString().toInt() >= 101)
                    || (binding.editText.text.toString() == "R000" && binding.editText4.text.toString().toInt() >= 6001)
                    || (binding.editText.text.toString() == "C001" && binding.editText4.text.toString().toInt() >= 1001)
                    || (binding.editText.text.toString() == "C002" && binding.editText4.text.toString().toInt() >= 89333223)){
                    Snackbar.make(view, this.requireContext().getText(R.string.product_NO_ONE), Snackbar.LENGTH_LONG).show()
                }else if ((binding.editText5.text.toString() == "M000" && binding.editText7.text.toString().toInt() >= 3201)
                        || (binding.editText5.text.toString() == "M001" && binding.editText7.text.toString().toInt() >= 2801)
                        || (binding.editText5.text.toString() == "C000" && binding.editText7.text.toString().toInt() >= 101)
                        || (binding.editText5.text.toString() == "R000" && binding.editText7.text.toString().toInt() >= 6001)
                        || (binding.editText5.text.toString() == "C001" && binding.editText7.text.toString().toInt() >= 1001)
                        || (binding.editText5.text.toString() == "C002" && binding.editText7.text.toString().toInt() >= 89333223)){
                    Snackbar.make(view, this.requireContext().getText(R.string.product_NO_TWO), Snackbar.LENGTH_LONG).show()
                } else if ((binding.editText6.text.toString() == "M000" && binding.editText10.text.toString().toInt() >= 3201)
                        || (binding.editText6.text.toString() == "M001" && binding.editText10.text.toString().toInt() >= 2801)
                        || (binding.editText6.text.toString() == "C000" && binding.editText10.text.toString().toInt() >= 101)
                        || (binding.editText6.text.toString() == "R000" && binding.editText10.text.toString().toInt() >= 6001)
                        || (binding.editText6.text.toString() == "C001" && binding.editText10.text.toString().toInt() >= 1001)
                        || (binding.editText6.text.toString() == "C002" && binding.editText10.text.toString().toInt() >= 89333223)){
                    Snackbar.make(view, this.requireContext().getText(R.string.product_NO_THREE), Snackbar.LENGTH_LONG).show()
                } else if ((binding.editText9.text.toString() == "M000" && binding.editText12.text.toString().toInt() >= 3201)
                        || (binding.editText9.text.toString() == "M001" && binding.editText12.text.toString().toInt() >= 2801)
                        || (binding.editText9.text.toString() == "C000" && binding.editText12.text.toString().toInt() >= 101)
                        || (binding.editText9.text.toString() == "R000" && binding.editText12.text.toString().toInt() >= 6001)
                        || (binding.editText9.text.toString() == "C001" && binding.editText12.text.toString().toInt() >= 1001)
                        || (binding.editText9.text.toString() == "C002" && binding.editText12.text.toString().toInt() >= 89333223)){
                    Snackbar.make(view, this.requireContext().getText(R.string.product_NO_FOUR), Snackbar.LENGTH_LONG).show()
                }else {
                    Snackbar.make(view, this.requireContext().getText(R.string.product_ok), Snackbar.LENGTH_LONG).show()
                    Navigation.findNavController(this.requireView()).navigate(R.id.action_orderFragment_to_mapsFragment2)
                }

            } else{
                Snackbar.make(view, this.requireContext().getText(R.string.fill_user_order), Snackbar.LENGTH_LONG).show()
            }


        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}