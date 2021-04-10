package id.itborneo.moca.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import id.itborneo.moca.core.model.response.MovieListResponse
import id.itborneo.moca.core.repository.MocaRepository
import id.itborneo.moca.core.utils.Resource
import kotlinx.coroutines.launch

class MovieViewModel(private val repo: MocaRepository) : ViewModel() {

    private lateinit var listMovie: LiveData<Resource<MovieListResponse>>

    init {
        initMovies()
    }

    fun initMovies() = viewModelScope.launch {
        listMovie = repo.getMovies()
    }

    fun getMovies(): LiveData<Resource<MovieListResponse>> {
        return listMovie
    }
}