package com.example.simplemoviesdetails.data

import com.example.simplemoviesdetails.data.model.DetailsResponse
import com.example.simplemoviesdetails.data.model.MovieResponse
import com.example.simplemoviesdetails.utils.API_KEY
import retrofit2.Response

interface DefaultDataSource {

    suspend fun getMoviesAndSeriesBySearch(search: String, page: Int = 1, apikey: String = API_KEY)
            : Response<MovieResponse>

    suspend fun getMoviesBySearch(search: String, type: String = "movie", page: Int = 1, apikey: String = API_KEY)
            : Response<MovieResponse>

    suspend fun getSeriesBySearch(search: String, type: String = "series", page: Int = 1, apikey: String = API_KEY)
            : Response<MovieResponse>

    suspend fun getDetailsById(id: String, apikey: String = API_KEY)
            : Response<DetailsResponse>

}