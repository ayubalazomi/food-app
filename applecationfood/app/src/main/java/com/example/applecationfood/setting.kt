package com.example.applecationfood

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Toast
import com.example.applecationfood.databinding.FragmentSettingBinding


class setting : Fragment(R.layout.fragment_setting) {

    private var _binding: FragmentSettingBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentSettingBinding.bind(view)
     val share = SharedPref(requireContext())

        binding.save.setOnClickListener {
            if (binding.small.isChecked) {
                share.saveFontSize("25")
                Toast.makeText(requireContext(),"fontsize is small",Toast.LENGTH_SHORT).show()
            }
            if (binding.madiam.isChecked) {
                share.saveFontSize("50")
                Toast.makeText(requireContext(), "fontsize is mediam", Toast.LENGTH_LONG).show()
            }
            if (binding.large.isChecked) {
               share.saveFontSize("75")
                Toast.makeText(requireContext(), "fontsize is large", Toast.LENGTH_LONG).show()
            }






        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}