package com.example.simplemoviesdetails.ui.movie


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.example.simplemoviesdetails.R
import com.example.simplemoviesdetails.databinding.FragmentMoviesBinding
import com.example.simplemoviesdetails.utils.hideSoftInput
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MoviesFragment : Fragment(R.layout.fragment_movies) {

    private lateinit var binding : FragmentMoviesBinding
    private val viewModel: MoviesViewModel by viewModels()
    private val movieAdapter = MoviePagingAdapter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        // Inflate the layout for this fragment
        binding = FragmentMoviesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        setRecyclerView()

        binding.searchMovie.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                query?.let {
                    viewModel.setQuery(it)
                }
                binding.searchMovie.hideSoftInput()
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }
        })

        viewModel.lista.observe(viewLifecycleOwner) {
            movieAdapter.submitData(lifecycle, it)
        }

    }

    private fun setRecyclerView() {
        binding.recyclerMovie.apply {
            adapter = movieAdapter
            layoutManager = GridLayoutManager(requireContext(), 2)
        }
    }

}
