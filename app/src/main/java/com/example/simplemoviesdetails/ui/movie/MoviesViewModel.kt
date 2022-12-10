package com.example.simplemoviesdetails.ui.movie

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.switchMap
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import androidx.paging.liveData
import com.example.simplemoviesdetails.data.remote.MovieAPIs
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MoviesViewModel
@Inject
constructor(private val moviesAPI : MovieAPIs) : ViewModel(){

    /**
    When the user edit the text of the search bar, he updates 'query'
     **/
    private val query = MutableLiveData<String>("")
    fun setQuery(text : String){
        query.postValue(text)
    }

    /**
     So, when 'query' change, the 'query.switchMap()' triggered and get the new list(page++).
     Then returns back as lifeData to update 'lista'.
     **/

    val lista = query.switchMap {
        Pager(PagingConfig(pageSize = 18)){ MoviesPaging(it, moviesAPI) }
            .liveData.cachedIn(viewModelScope)
    }
}