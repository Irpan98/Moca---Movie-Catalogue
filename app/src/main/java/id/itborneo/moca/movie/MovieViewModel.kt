package id.itborneo.moca.movie

import androidx.lifecycle.*
import id.itborneo.moca.core.model.response.MovieListResponse
import id.itborneo.moca.core.repository.MocaRepository
import id.itborneo.moca.core.utils.Resource
import kotlinx.coroutines.launch

class MovieViewModel(private val repo: MocaRepository) : ViewModel() {

    private lateinit var listMovie: LiveData<Resource<MovieListResponse>>

    private val searchQuery = MutableLiveData<String>()
    private var searchedMovies = Transformations.switchMap(searchQuery) {
        repo.searchMovies(it).asLiveData()
    } as MutableLiveData<Resource<MovieListResponse>>

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