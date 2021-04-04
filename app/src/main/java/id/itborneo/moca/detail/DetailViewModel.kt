package id.itborneo.moca.detail

import androidx.lifecycle.ViewModel
import id.itborneo.moca.core.model.MovieModel
import id.itborneo.moca.core.repository.MocaRepository

class DetailViewModel(private val id: Int) : ViewModel() {

    private val repo = MocaRepository()

    private var detail = repo.getDetailMovie(id ?: 0)
    private var credits = repo.getCredits(id ?: 0)


    fun getDetailMovie() = detail

    fun getCredits() = credits
}

