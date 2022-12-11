package com.example.simplemoviesdetails.data.remote

import com.example.simplemoviesdetails.data.MovieResponse
import com.example.simplemoviesdetails.utils.API_KEY
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieAPIs {

    //GET /users?sort_by=desc(last_modified),asc(email)
    // or
    //GET /users?sort_by=-last_modified,+email

    // https://www.omdbapi.com/?s=hulk&apikey=e7a0b90a
    @GET("/")
    suspend fun getMoviesAndSeriesBySearch(
        @Query("s") search: String,
        @Query("page") page: Int = 1,
        @Query("apikey") apikey: String = API_KEY,
    ):Response<MovieResponse>

    // https://www.omdbapi.com/?s=hulk&apikey=e7a0b90a&type=movie
    @GET("/")
    suspend fun getMoviesBySearch(
        @Query("s") search: String,
        @Query("page") page: Int = 1,
        @Query("type") type: String = "movie",
        @Query("apikey") apikey: String = API_KEY,
    ):Response<MovieResponse>

    // https://www.omdbapi.com/?s=hulk&apikey=e7a0b90a&type=movie&y=2009
    @GET("/")
    suspend fun getMoviesBySearchAndYear(
        @Query("s") search: String,
        @Query("page") page: Int = 1,
        @Query("type") type: String = "movie",
        @Query("y") year: String = "2022",
        @Query("apikey") apikey: String = API_KEY,
    ):Response<MovieResponse>

    @GET("/")
    suspend fun getSeriesBySearch(
        @Query("s") search: String,
        @Query("page") page: Int = 1,
        @Query("type") type: String = "series",
        @Query("apikey") apikey: String = API_KEY,
    ):Response<MovieResponse>

    @GET("/")
    suspend fun getSeriesBySearchAndYear(
        @Query("s") search: String,
        @Query("page") page: Int = 1,
        @Query("type") type: String = "series",
        @Query("y") year: String = "2022",
        @Query("apikey") apikey: String = API_KEY,
    ):Response<MovieResponse>

    // https://www.omdbapi.com/?i=tt10857160&apikey=e7a0b90a
    @GET("/")
    suspend fun getMovieOrSeriesById(
        @Query("i") id: String,
        @Query("apikey") apikey: String = API_KEY,
    ):Response<MovieResponse>


}