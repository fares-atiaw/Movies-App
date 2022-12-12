package com.example.simplemoviesdetails.data.remote

import com.example.simplemoviesdetails.data.DefaultDataSource
import com.example.simplemoviesdetails.data.model.DetailsResponse
import com.example.simplemoviesdetails.data.model.MovieResponse
import retrofit2.Response
import javax.inject.Inject

class OmdbRemoteDataSource
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