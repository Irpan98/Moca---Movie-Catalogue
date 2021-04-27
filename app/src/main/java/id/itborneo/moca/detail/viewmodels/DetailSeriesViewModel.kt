package id.itborneo.moca.detail.viewmodels

import androidx.lifecycle.*
import id.itborneo.core.domain.model.SeriesModel
import id.itborneo.core.domain.model.credits.CreditsModel
import id.itborneo.core.domain.model.detail.SeriesDetailModel
import id.itborneo.core.domain.usecase.MocaUseCase
import id.itborneo.core.utils.Resource
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

    fun initDetailSeries() = viewModelScope.launch {
        detail = useCase.getDetailSeries(id)
        credits = useCase.getCredits(id)
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

