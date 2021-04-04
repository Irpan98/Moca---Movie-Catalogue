package id.itborneo.moca.detail

import androidx.lifecycle.ViewModel
import id.itborneo.moca.core.model.MovieModel
import id.itborneo.moca.core.repository.MocaRepository

class DetailViewModel(private val movie: MovieModel) : ViewModel() {

    private val repo = MocaRepository()

    private var userDetail = repo.getDetailMovie(movie.id ?: 0)
    private var credits = repo.getCredits(movie.id ?: 0)


    fun getDetailMovie() = userDetail

    fun getCredits() = credits
}

