package id.itborneo.moca.detail.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import id.itborneo.moca.core.local.enitity.FavoriteMovieEntity
import id.itborneo.moca.core.model.credits.CreditsModel
import id.itborneo.moca.core.model.detail.MovieDetailModel
import id.itborneo.moca.core.repository.MocaRepository
import id.itborneo.moca.core.utils.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class DetailMovieViewModel(private val repo: MocaRepository, private val id: Int) : ViewModel() {
    private lateinit var detail: LiveData<Resource<MovieDetailModel>>
    private lateinit var credits: LiveData<Resource<CreditsModel>>

    var isFavorite = MutableLiveData(false)

    init {
        initDetailMovie()
        isFavoriteCheck()
    }

    private fun isFavoriteCheck() = viewModelScope.launch {
        withContext(Dispatchers.IO) {
            val movieFavorite = repo.getSingleMovieFavorite(id)
            if (movieFavorite != null) {
                isFavorite.postValue(true)
            } else {
                isFavorite.postValue(false)
            }
        }
    }

    fun initDetailMovie() = viewModelScope.launch {
        detail = repo.getDetailMovie(id)
        credits = repo.getCredits(id)
    }

    fun getDetailMovie() = detail

    fun getCredits() = credits

    fun addFavorite(favorite: FavoriteMovieEntity) = viewModelScope.launch {
        withContext(Dispatchers.IO) {
            repo.addMovieFavorite(favorite)
            isFavorite.postValue(true)
        }
    }

    fun removeFavorite(favorite: FavoriteMovieEntity) = viewModelScope.launch {
        withContext(Dispatchers.IO) {
            repo.removeMovieFavorite(favorite)
            isFavorite.postValue(false)
        }
    }

}