package id.itborneo.moca.movie

import androidx.lifecycle.*
import id.itborneo.moca.core.model.response.MovieListResponse
import id.itborneo.moca.core.repository.MocaRepository
import id.itborneo.moca.core.utils.Resource
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch

@FlowPreview
class MovieViewModel(private val repo: MocaRepository) : ViewModel() {

    private lateinit var listMovie: LiveData<Resource<MovieListResponse>>

    private val searchQuery = MutableLiveData<String>()
    private val searchedMovies = object : MutableLiveData<Resource<MovieListResponse>>() {
        override fun onActive() {
            value?.let { return }
            viewModelScope.launch {
                searchQuery.asFlow()
                    .debounce(300) // Wait
                    .distinctUntilChanged() // Ignore same value (This is the default operator)
                    .collect {
                        repo.searchMovies(it).collect { getValue ->
                            value = getValue
                        }
                    }
            }
        }
    }

    init {
        initMovies()
    }

    fun initMovies() = viewModelScope.launch {
        listMovie = repo.getMovies().asLiveData()
    }


    fun setSearch(query: String) = viewModelScope.launch {
        searchQuery.postValue(query)
    }


    fun getMovies() = listMovie
    fun getSearched() = searchedMovies


}
