package id.itborneo.moca.detail.viewmodels

import androidx.lifecycle.*
import id.itborneo.moca.core.domain.model.credits.CreditsModel
import id.itborneo.moca.core.domain.model.detail.MovieDetailModel
import id.itborneo.moca.core.domain.usecase.MocaUseCase
import id.itborneo.moca.core.utils.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DetailMovieViewModel(private val useCase: MocaUseCase, private val id: Int) : ViewModel() {

    private var favoriteTrigger = MutableLiveData(false)
    private var favorite = Transformations.switchMap(favoriteTrigger) {
        useCase.getSingleMovieFavorite(id).asLiveData()
    }

    private lateinit var detail: LiveData<Resource<MovieDetailModel>>
    private lateinit var credits: LiveData<Resource<CreditsModel>>

    init {
        initDetailMovie()
    }

    private fun initDetailMovie() = viewModelScope.launch {
        detail = useCase.getDetailMovie(id).asLiveData()
        credits = useCase.getCredits(id).asLiveData()
    }

    fun getDetailMovie() = detail
    fun getCredits() = credits
    fun getFavorites() = favorite

    fun addFavorite(favorite: MovieDetailModel) = viewModelScope.launch(Dispatchers.IO) {
        useCase.addMovieFavorite(favorite)
        favoriteTrigger
    }

    fun removeFavorite(favorite: MovieDetailModel) = viewModelScope.launch(Dispatchers.IO) {
        useCase.removeMovieFavorite(favorite)
        favoriteTrigger
    }
}

