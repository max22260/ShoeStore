package com.udacity.shoestore.ui

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.models.Shoe
import kotlinx.android.synthetic.main.item_view_layout.view.*


class ShoeListFragment : Fragment() {

    private val viewModel: SharedViewModel by  activityViewModels()

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
                addViewItem(it)
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

    private fun addViewItem(shoe: Shoe) {

        val itemView = LayoutInflater.from(requireContext()).inflate(R.layout.item_view_layout,
            binding.linearLayout,
            false)

        itemView.shoeName.text = shoe.name
        itemView.company.text = shoe.company
        itemView.shoeSize.text = shoe.size.toString()
        itemView.description.text = shoe.description

        binding.linearLayout.addView(itemView)
    }

    private fun navigateToShoeDetailsScreen() {
        val action =
            ShoeListFragmentDirections.actionShoeListFragmentToShoeDetailFragment()
        findNavController().navigate(action)
    }
}