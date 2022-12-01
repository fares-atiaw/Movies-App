package com.example.simplemoviesdetails.data.remote

import com.example.simplemoviesdetails.data.MovieResponse
import com.example.simplemoviesdetails.utils.API_KEY
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieAPIs {

    @GET("/")
    suspend fun getMoviesBySearch(
        @Query("s") search: String,
        @Query("page") page: Int = 1,
        @Query("apikey") apikey: String = API_KEY,
    ):Response<MovieResponse>

    @GET("/")
    suspend fun getMoviesById(
        @Query("i") search: String,
        @Query("page") page: Int = 1,
        @Query("apikey") apikey: String = API_KEY,
    ):Response<MovieResponse>

}