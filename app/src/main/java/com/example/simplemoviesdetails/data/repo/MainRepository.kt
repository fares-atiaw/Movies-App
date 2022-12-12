package com.example.simplemoviesdetails.data.repo

import com.example.simplemoviesdetails.data.DefaultDataSource
import com.example.simplemoviesdetails.data.DefaultRepository
import com.example.simplemoviesdetails.data.model.DetailsResponse
import com.example.simplemoviesdetails.data.model.MovieResponse
import com.example.simplemoviesdetails.utils.Resource
import retrofit2.Response
import javax.inject.Inject

class MainRepository
@Inject
constructor (private val remoteSource : DefaultDataSource) : DefaultRepository {

    override suspend fun getMoviesAndSeriesBySearch(search: String, page: Int, apikey: String): Resource<MovieResponse> {
        val response = remoteSource.getMoviesAndSeriesBySearch(search, page)
        return try {
            if (response.isSuccessful)
                Resource.Success(response.body())
            else
                Resource.Error("No data", response.body())

        } catch(e: Exception) {
            Resource.Error("An error occurred \n $e", response.body())
        }
    }

    override suspend fun getMoviesBySearch(search: String, type: String, page: Int, apikey: String): Resource<MovieResponse> {
        val response = remoteSource.getMoviesBySearch(search)
        return try {
            if (response.isSuccessful)
                Resource.Success(response.body())
            else
                Resource.Error("No data", response.body())

        } catch(e: Exception) {
            Resource.Error("An error occurred \n $e", response.body())
        }
    }

    override suspend fun getSeriesBySearch(search: String, type: String, page: Int, apikey: String): Resource<MovieResponse> {
        val response = remoteSource.getSeriesBySearch(search)
        return try {
            if (response.isSuccessful)
                Resource.Success(response.body())
            else
                Resource.Error("No data", response.body())

        } catch(e: Exception) {
            Resource.Error("An error occurred \n $e", response.body())
        }
    }

    override suspend fun getDetailsById(id: String, apikey: String): Resource<DetailsResponse> {
        val response = remoteSource.getDetailsById(id)
         return try {
            if (response.isSuccessful)
                Resource.Success(response.body())
             else
                Resource.Error("Data not found", response.body())

        } catch(e: Exception) {
             Resource.Error("An error occurred \n $e", response.body())
         }
    }


}