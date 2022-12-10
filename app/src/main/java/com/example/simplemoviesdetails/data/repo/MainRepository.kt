package com.example.simplemoviesdetails.data.repo

import com.example.simplemoviesdetails.data.MovieResponse
import com.example.simplemoviesdetails.data.remote.MovieAPIs
import retrofit2.Response

class MainRepository(private val moviesAPI : MovieAPIs) : DefaultRepository {
    override suspend fun getMoviesBySearch(
        search: String,
        page: Int,
        apikey: String
    ): Response<MovieResponse> {
        TODO("Not yet implemented")
    }

    override suspend fun getMoviesById(
        search: String,
        page: Int,
        apikey: String
    ): Response<MovieResponse> {
        TODO("Not yet implemented")
    }
}