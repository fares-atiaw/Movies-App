package com.example.simplemoviesdetails.ui.details

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.simplemoviesdetails.R
import com.example.simplemoviesdetails.databinding.FragmentDetailsBinding
import com.example.simplemoviesdetails.databinding.FragmentMoviesBinding
import com.example.simplemoviesdetails.ui.MoviesViewModel
import com.example.simplemoviesdetails.utils.Resource
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailsFragment : Fragment(R.layout.fragment_details) {

    val args: DetailsFragmentArgs by navArgs()
    val viewModel: MoviesViewModel by viewModels()
    private lateinit var binding : FragmentDetailsBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = FragmentDetailsBinding.inflate(inflater, container, false)

        viewModel.getShowDetails(args.id)

        binding.backPress.setOnClickListener {
            findNavController().popBackStack()
        }

        viewModel.currentShowDetails.observe(viewLifecycleOwner) {
            when (it) {
                is Resource.Error -> {
                    binding.detailsProgress.visibility = View.GONE
                    Toast.makeText(context, "Check your internet connection" , Toast.LENGTH_SHORT).show()
                }
                is Resource.Success -> {
                    binding.detailsProgress.visibility = View.GONE
                    binding.details = it.data
                }
                else -> { // Resource.Loading
                    binding.detailsProgress.visibility = View.VISIBLE
                }
            }
        }

        return binding.root
    }

}