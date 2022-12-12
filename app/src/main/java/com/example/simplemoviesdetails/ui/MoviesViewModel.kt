package com.example.simplemoviesdetails.ui

import androidx.lifecycle.*
import androidx.paging.*
import com.example.simplemoviesdetails.data.DefaultRepository
import com.example.simplemoviesdetails.data.model.DetailsResponse
import com.example.simplemoviesdetails.data.model.Movie
import com.example.simplemoviesdetails.ui.movie.MoviesPaging
import com.example.simplemoviesdetails.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MoviesViewModel
@Inject
constructor(private val repo : DefaultRepository) : ViewModel(){

    /** MoviesFragment **/
//    When the user edit the text of the search bar, he updates 'query'
    private val query = MutableLiveData<String>("")
    fun setQuery(text : String){
        query.postValue(text)
    }

    /**
     So, when 'query' change, the 'query.switchMap()' triggered and get a new paginated list.
     Then returns back as lifeData to update 'lista'.
     **/

    val lista : LiveData<PagingData<Movie>> = query.switchMap {
        Pager(PagingConfig(pageSize = 18)) {
            MoviesPaging(it, repo)
        }.liveData.cachedIn(viewModelScope)
    }


    /** DetailsFragment **/

    private val _currentShowDetails = MutableLiveData<Resource<DetailsResponse>>()
    val currentShowDetails : LiveData<Resource<DetailsResponse>>
        get() = _currentShowDetails

    fun getShowDetails(id: String) = viewModelScope.launch {
        _currentShowDetails.postValue(Resource.Loading())
        _currentShowDetails.postValue(repo.getDetailsById(id))
    }

}