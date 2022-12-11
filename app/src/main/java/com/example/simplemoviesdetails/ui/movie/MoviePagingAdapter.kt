package com.example.simplemoviesdetails.ui.movie

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.simplemoviesdetails.data.Movie
import com.example.simplemoviesdetails.databinding.ItemMovieBinding

class MoviePagingAdapter : PagingDataAdapter<Movie, MoviePagingAdapter.MovieItemViewHolder>(MovieDiffCallback()) {

    private var clickListener: ((id :String) -> Unit)? = null
    fun onClick(listener: (id :String) -> Unit) {
        clickListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieItemViewHolder {
        return MovieItemViewHolder.fromInflating(parent)
    }

    override fun onBindViewHolder(holder: MovieItemViewHolder, position: Int) {
        holder.bind(getItem(position)!!, clickListener)
    }

    class MovieItemViewHolder private constructor(private val binding: ItemMovieBinding)
        : RecyclerView.ViewHolder(binding.root) {

        fun bind(data: Movie, clickListener: ((id :String) -> Unit)?) {
            binding.data = data
            binding.root.setOnClickListener {
                clickListener?.let {
                    it(data.imdbID)
                }
            }
            binding.executePendingBindings()
        }

        /** private methods**/


        /** static variable(s) or method(s)**/
        companion object {
            fun fromInflating(parent: ViewGroup): MovieItemViewHolder {
                val binding: ItemMovieBinding = ItemMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                return MovieItemViewHolder(binding)
            }
        }
    }


    class MovieDiffCallback : DiffUtil.ItemCallback<Movie>() {
        override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
            return oldItem.imdbID == newItem.imdbID
        }
        override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
            return oldItem == newItem
        }
    }
}