package com.example.simplemoviesdetails.di

import com.example.simplemoviesdetails.data.DefaultDataSource
import com.example.simplemoviesdetails.data.remote.MovieAPIs
import com.example.simplemoviesdetails.data.remote.OmdbSource
import com.example.simplemoviesdetails.data.DefaultRepository
import com.example.simplemoviesdetails.data.repo.MainRepository
import com.example.simplemoviesdetails.utils.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    // API from omdbapi.com
    @Provides
    @Singleton
    fun provideRetrofit_omdbApi() : MovieAPIs =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MovieAPIs::class.java)

    // DataSource
    @Provides
    @Singleton
    fun provideRemoteDataSource(api : MovieAPIs) : DefaultDataSource =
        OmdbSource(api)


    // Repository
    @Provides
    @Singleton
    fun provideRepository(dateSource : DefaultDataSource) : DefaultRepository =
        MainRepository(dateSource)

}