package id.itborneo.moca.detail.viewmodels

import androidx.lifecycle.*
import id.itborneo.core.domain.usecase.MocaUseCase
import id.itborneo.core.utils.Resource
import id.itborneo.moca.model.credits.CreditsModel
import id.itborneo.moca.model.detail.MovieDetailModel
import id.itborneo.moca.utils.ModelDataMapper
import id.itborneo.moca.utils.ModelSingleDataMapper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class DetailMovieViewModel(private val useCase: MocaUseCase, private val id: Int) : ViewModel() {

    private var favoriteTrigger = MutableLiveData(false)
    private var favorite = Transformations.switchMap(favoriteTrigger) {
        useCase.getSingleMovieFavorite(id)
            .map {
                ModelSingleDataMapper.movieFromDomain(it)
            }
            .asLiveData()
    }

    private lateinit var detail: LiveData<Resource<MovieDetailModel>>
    private lateinit var credits: LiveData<Resource<CreditsModel>>

    init {
        initDetailMovie()
    }

    fun initDetailMovie() = viewModelScope.launch {
        detail = useCase.getDetailMovie(id).map {
            ModelSingleDataMapper.movieDetailFromDomain(it)
        }
        credits = useCase.getCredits(id).map {
            ModelDataMapper.creditListFromDomain(it)
        }
    }

    fun getDetailMovie() = detail
    fun getCredits() = credits
    fun getFavorites() = favorite

    fun addFavorite(favorite: MovieDetailModel) = viewModelScope.launch(Dispatchers.IO) {
        useCase.addMovieFavorite(
            ModelSingleDataMapper.movieDetailToDomain(favorite)
        )
        favoriteTrigger
    }

    fun removeFavorite(favorite: MovieDetailModel) = viewModelScope.launch(Dispatchers.IO) {
        useCase.removeMovieFavorite(
            ModelSingleDataMapper.movieDetailToDomain(favorite)
        )
        favoriteTrigger
    }
}

