package id.itborneo.moca.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import id.itborneo.moca.core.model.MovieModel
import id.itborneo.moca.core.model.detail.MovieDetailModel
import id.itborneo.moca.core.repository.MocaRepository
import id.itborneo.moca.core.utils.Resource

class DetailViewModel(private val movie: MovieModel) : ViewModel() {

    private val repo = MocaRepository()

    private var userDetail: LiveData<Resource<MovieDetailModel>> = repo.getDetailMovie(movie.id ?: 0)

    fun getDetailMovie() = userDetail
}

