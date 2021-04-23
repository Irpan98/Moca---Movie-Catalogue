package id.itborneo.moca.detail

import androidx.lifecycle.*
import id.itborneo.moca.core.data.local.database.enitity.FavoriteMovieEntity
import id.itborneo.moca.core.domain.model.credits.CreditsModel
import id.itborneo.moca.core.domain.model.detail.MovieDetailModel
import id.itborneo.moca.core.domain.usecase.MocaUseCase
import id.itborneo.moca.core.utils.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class DetailMovieViewModel(private val useCase: MocaUseCase, private val id: Int) : ViewModel() {
    private lateinit var detail: LiveData<Resource<MovieDetailModel>>
    private lateinit var credits: LiveData<Resource<CreditsModel>>

    var isFavorite = MutableLiveData(false)

    init {
        initDetailMovie()
        isFavoriteCheck()
    }

    private fun isFavoriteCheck() = viewModelScope.launch {
        withContext(Dispatchers.IO) {
//            val movieFavorite = useCase.getSingleMovieFavorite(id)
//            if (movieFavorite != null) {
//                isFavorite.postValue(true)
//            } else {
//                isFavorite.postValue(false)
//            }
        }
    }

    fun initDetailMovie() = viewModelScope.launch {
//        detail = useCase.getDetailMovie(id).asLiveData()
//        credits = useCase.getCredits(id).asLiveData()
    }

    fun getDetailMovie() = detail

    fun getCredits() = credits

    fun addFavorite(favorite: FavoriteMovieEntity) = viewModelScope.launch {
        withContext(Dispatchers.IO) {
//            useCase.addMovieFavorite(favorite)
            isFavorite.postValue(true)
        }
    }

    fun removeFavorite(favorite: FavoriteMovieEntity) = viewModelScope.launch {
        withContext(Dispatchers.IO) {
//            useCase.removeMovieFavorite(favorite)
            isFavorite.postValue(false)
        }
    }

}