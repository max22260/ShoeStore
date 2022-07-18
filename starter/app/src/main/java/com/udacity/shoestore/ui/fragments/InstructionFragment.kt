package com.udacity.shoestore.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.databinding.FragmentInstructionBinding


class InstructionFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding =
            FragmentInstructionBinding.inflate(inflater, container, false)

        binding.instructionNextButton.setOnClickListener {
            navigateToShoeListScreen()
        }

        return binding.root
    }

    private fun navigateToShoeListScreen() {
        val action =
            InstructionFragmentDirections.actionInstructionFragmentToShoeListFragment()
        findNavController().navigate(action)
    }


}