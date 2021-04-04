package id.itborneo.moca.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import id.itborneo.moca.core.model.response.MovieListResponse
import id.itborneo.moca.core.repository.MocaRepository
import id.itborneo.moca.core.utils.Resource

class MovieViewModel : ViewModel() {

    private val repo = MocaRepository()
    private val movies: LiveData<Resource<MovieListResponse>> = repo.getMovies()

    fun getMovies() = movies
}