package com.udacity.shoestore.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding
import com.udacity.shoestore.models.Shoe
import timber.log.Timber


class ShoeDetailFragment : Fragment() {

    private val viewModel: SharedViewModel by  activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding :FragmentShoeDetailBinding  = DataBindingUtil.inflate(inflater ,
            R.layout.fragment_shoe_detail , container , false)

        val shoe = Shoe("",0.0, "","")
        binding.model = shoe

        binding.saveButton.setOnClickListener {
            viewModel.addNewShoe(shoe)
            findNavController().popBackStack()
        }

        binding.cancelButton.setOnClickListener {
            Timber.i(shoe.toString())
            findNavController().popBackStack()
        }

        return binding.root
    }
}