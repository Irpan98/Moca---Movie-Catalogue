package id.itborneo.moca.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import id.itborneo.moca.core.model.credits.CreditsModel
import id.itborneo.moca.core.model.detail.MovieDetailModel
import id.itborneo.moca.core.repository.MocaRepository
import id.itborneo.moca.core.utils.Resource
import kotlinx.coroutines.launch

class DetailMovieViewModel(private val repo: MocaRepository, private val id: Int) : ViewModel() {
    private lateinit var detail: LiveData<Resource<MovieDetailModel>>
    private lateinit var credits: LiveData<Resource<CreditsModel>>

    init {
        initDetailMovie()
    }

    fun initDetailMovie() = viewModelScope.launch {
        detail = repo.getDetailMovie(id)
        credits = repo.getCredits(id)
    }

    fun getDetailMovie() = detail

    fun getCredits() = credits
}

