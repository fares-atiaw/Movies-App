package com.example.simplemoviesdetails.ui.details

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.simplemoviesdetails.R
import com.example.simplemoviesdetails.databinding.FragmentDetailsBinding
import com.example.simplemoviesdetails.databinding.FragmentMoviesBinding
import com.example.simplemoviesdetails.ui.MoviesViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailsFragment : Fragment(R.layout.fragment_details) {

    val args: DetailsFragmentArgs by navArgs()
    val viewModel: MoviesViewModel by viewModels()
    private lateinit var binding : FragmentDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = FragmentDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

}