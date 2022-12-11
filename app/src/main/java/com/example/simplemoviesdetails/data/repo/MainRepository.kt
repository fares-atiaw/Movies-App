package com.example.simplemoviesdetails.data.repo

import com.example.simplemoviesdetails.data.DefaultDataSource
import com.example.simplemoviesdetails.data.DefaultRepository
import com.example.simplemoviesdetails.data.model.DetailsResponse
import com.example.simplemoviesdetails.data.model.MovieResponse
import retrofit2.Response
import javax.inject.Inject

class MainRepository
@Inject
constructor (private val remoteSource : DefaultDataSource) : DefaultRepository {

    override suspend fun getMoviesAndSeriesBySearch(search: String, page: Int, apikey: String): Response<MovieResponse> =
        remoteSource.getMoviesAndSeriesBySearch(search, page)

    override suspend fun getMoviesBySearch(search: String, type: String, page: Int, apikey: String): Response<MovieResponse> =
        remoteSource.getMoviesBySearch(search)

    override suspend fun getSeriesBySearch(search: String, type: String, page: Int, apikey: String): Response<MovieResponse> =
        remoteSource.getSeriesBySearch(search)

    override suspend fun getDetailsById(id: String, apikey: String): Response<DetailsResponse> =
        remoteSource.getDetailsById(id)

}