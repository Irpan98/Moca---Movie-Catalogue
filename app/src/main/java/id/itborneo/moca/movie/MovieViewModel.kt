package id.itborneo.moca.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import id.itborneo.moca.core.model.response.MoviesResponse
import id.itborneo.moca.core.networks.ApiConfig
import id.itborneo.moca.core.repository.MocaRepository
import id.itborneo.moca.core.utils.Resource
import kotlinx.coroutines.Dispatchers

class MovieViewModel : ViewModel() {

    private val repo = MocaRepository()
    private val movies: LiveData<Resource<MoviesResponse>> = repo.getMovies()

    fun getMovies() = movies
}