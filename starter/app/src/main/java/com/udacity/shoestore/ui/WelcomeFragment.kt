package com.udacity.shoestore.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentLoginBinding
import com.udacity.shoestore.databinding.FragmentWelcomeBinding


class WelcomeFragment : Fragment() {



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding : FragmentWelcomeBinding = DataBindingUtil.inflate(inflater , R.layout.fragment_welcome , container , false)

        binding.welcomeNextButton.setOnClickListener {
            navigateToInstructionScreen()
        }

        return binding.root
    }


    private fun navigateToInstructionScreen() {
        val action =
            WelcomeFragmentDirections.actionWelcomeFragmentToInstructionFragment()
        findNavController().navigate(action)
    }

}