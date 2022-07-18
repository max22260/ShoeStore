package com.udacity.shoestore.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.ui.viewModels.SharedViewModel
import timber.log.Timber


class ShoeDetailFragment : Fragment() {

    private val viewModel: SharedViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding = FragmentShoeDetailBinding.inflate(
            inflater,
            container, false
        )

        val shoe = Shoe("", 0.0, "", "")

        with(binding) {
            model = shoe

            saveButton.setOnClickListener {
                viewModel.addNewShoe(shoe)
                findNavController().popBackStack()
            }

            cancelButton.setOnClickListener {
                Timber.i(shoe.toString())
                findNavController().popBackStack()
            }
        }
        return binding.root
    }
}