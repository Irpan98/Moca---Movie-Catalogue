package id.itborneo.moca.detail.viewmodels

import androidx.lifecycle.*
import id.itborneo.moca.core.domain.model.SeriesModel
import id.itborneo.moca.core.domain.model.credits.CreditsModel
import id.itborneo.moca.core.domain.model.detail.SeriesDetailModel
import id.itborneo.moca.core.domain.usecase.MocaUseCase
import id.itborneo.moca.core.utils.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DetailSeriesViewModel(private val useCase: MocaUseCase, private val id: Int) : ViewModel() {

    private var favoriteTrigger = MutableLiveData(false)
    private var favorite: LiveData<SeriesModel?> = Transformations.switchMap(favoriteTrigger) {
        useCase.getSingleSeriesFavorite(id).asLiveData()
    }

    private lateinit var detail: LiveData<Resource<SeriesDetailModel>>
    private lateinit var credits: LiveData<Resource<CreditsModel>>

    init {
        initDetailSeries()
    }

    private fun initDetailSeries() = viewModelScope.launch {
        detail = useCase.getDetailSeries(id).asLiveData()
        credits = useCase.getCredits(id).asLiveData()
    }

    fun getDetail() = detail
    fun getCredits() = credits
    fun getFavorites() = favorite

    fun addFavorite(favorite: SeriesDetailModel) = viewModelScope.launch(Dispatchers.IO) {
        useCase.addSeriesFavorite(favorite)
        favoriteTrigger
    }

    fun removeFavorite(favorite: SeriesDetailModel) = viewModelScope.launch(Dispatchers.IO) {
        useCase.removeSeriesFavorite(favorite)
        favoriteTrigger
    }
}

