package com.example.simplemoviesdetails.ui.movie

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.simplemoviesdetails.data.DefaultRepository
import com.example.simplemoviesdetails.data.model.Movie

class MoviesPaging(private val s: String, private val repo : DefaultRepository) : PagingSource<Int, Movie>() {

    override fun getRefreshKey(state: PagingState<Int, Movie>): Int? =
        state.anchorPosition?.let {
            val anchorPage = state.closestPageToPosition(it)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Movie> {
        val currentPage = params.key ?: 1

        /** Get the next page of data **/

        return try{
            val data = repo.getMoviesAndSeriesBySearch(search = s, page = currentPage).data
            LoadResult.Page(
                data = data?.Search!!,
                prevKey = if (currentPage==1) null else currentPage-1,
                nextKey = if (data.Search.isEmpty()) null else currentPage+1
            )
        } catch (e: Exception){
            LoadResult.Error(e)
        }
    }


}