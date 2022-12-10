package com.example.simplemoviesdetails.data.repo

import com.example.simplemoviesdetails.data.MovieResponse
import com.example.simplemoviesdetails.utils.API_KEY
import retrofit2.Response

interface DefaultRepository {

    suspend fun getMoviesBySearch(search: String, page: Int = 1, apikey: String = API_KEY)
    : Response<MovieResponse>

    suspend fun getMoviesById(search: String, page: Int = 1, apikey: String = API_KEY)
    : Response<MovieResponse>
}