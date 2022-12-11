package com.example.simplemoviesdetails.data.remote

import com.example.simplemoviesdetails.data.DefaultDataSource
import com.example.simplemoviesdetails.data.DetailsResponse
import com.example.simplemoviesdetails.data.MovieResponse
import dagger.hilt.android.HiltAndroidApp
import retrofit2.Response
import javax.inject.Inject

@HiltAndroidApp
class OMDBsource
@Inject
constructor (private val moviesAPI : MovieAPIs) : DefaultDataSource {

    override suspend fun getMoviesAndSeriesBySearch(search: String, page: Int, apikey: String): Response<MovieResponse> =
        moviesAPI.getMoviesAndSeriesBySearch(search, page)

    override suspend fun getMoviesBySearch(search: String, type: String, page: Int, apikey: String): Response<MovieResponse> =
        moviesAPI.getMoviesBySearch(search, page)

    override suspend fun getSeriesBySearch(search: String, type: String, page: Int, apikey: String): Response<MovieResponse> =
        moviesAPI.getSeriesBySearch(search, page)

    override suspend fun getDetailsById(id: String, apikey: String): Response<DetailsResponse> =
        moviesAPI.getMovieOrSeriesDetailsById(id)

}