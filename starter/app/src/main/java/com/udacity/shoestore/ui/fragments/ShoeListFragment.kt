package com.udacity.shoestore.ui.fragments

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.databinding.ItemViewLayoutBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.ui.viewModels.SharedViewModel


class ShoeListFragment : Fragment() {

    private val viewModel: SharedViewModel by activityViewModels()

    private var _binding: FragmentShoeListBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        setHasOptionsMenu(true)
        _binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_shoe_list, container, false
        )

        viewModel.shoeList.observe(viewLifecycleOwner) { shoes ->
            shoes.forEach {
                addViewItem(it, inflater)
            }
        }

        binding.addShoeButton.setOnClickListener {
            navigateToShoeDetailsScreen()
        }
        return binding.root
    }

    override fun onPrepareOptionsMenu(menu: Menu) {
        menu.findItem(R.id.logout).isVisible = true
        super.onPrepareOptionsMenu(menu)
    }

    private fun addViewItem(shoe: Shoe, inflater: LayoutInflater) {
        val itemView: ItemViewLayoutBinding = ItemViewLayoutBinding.inflate(
            inflater,
            binding.linearLayout,
            false
        )

        with(itemView) {
            shoeName.text = shoe.name
            company.text = shoe.company
            shoeSize.text = shoe.size.toString()
            description.text = shoe.description
        }
        binding.linearLayout.addView(itemView.root)
    }

    private fun navigateToShoeDetailsScreen() {
        val action =
            ShoeListFragmentDirections.actionShoeListFragmentToShoeDetailFragment()
        findNavController().navigate(action)
    }
}