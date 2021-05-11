package id.itborneo.moca.detail.viewmodels

import androidx.lifecycle.*
import id.itborneo.core.domain.usecase.MocaUseCase
import id.itborneo.core.utils.Resource
import id.itborneo.moca.model.SeriesModel
import id.itborneo.moca.model.credits.CreditsModel
import id.itborneo.moca.model.detail.SeriesDetailModel
import id.itborneo.moca.utils.ModelDataMapper
import id.itborneo.moca.utils.ModelSingleDataMapper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class DetailSeriesViewModel(private val useCase: MocaUseCase, private val id: Int) : ViewModel() {

    private var favoriteTrigger = MutableLiveData(false)
    private var favorite: LiveData<SeriesModel?> =
        Transformations.switchMap(favoriteTrigger) {
            useCase.getSingleSeriesFavorite(id)
                .map {
                    ModelSingleDataMapper.seriesFromDomain(it)
                }.asLiveData()
        }

    private lateinit var detail: LiveData<Resource<SeriesDetailModel>>
    private lateinit var credits: LiveData<Resource<CreditsModel>>

    init {
        initDetailSeries()
    }

    fun initDetailSeries() = viewModelScope.launch {
        detail = useCase.getDetailSeries(id).map {
            ModelSingleDataMapper.seriesDetailFromDomain(it)

        }
        credits = useCase.getCredits(id).map {
            ModelDataMapper.creditListFromDomain(it)
        }
    }

    fun getDetail() = detail
    fun getCredits() = credits
    fun getFavorites() = favorite

    fun addFavorite(favorite: SeriesDetailModel) = viewModelScope.launch(Dispatchers.IO) {
        useCase.addSeriesFavorite(
            ModelSingleDataMapper.seriesDetailToDomain(favorite)
        )
        favoriteTrigger
    }

    fun removeFavorite(favorite: SeriesDetailModel) = viewModelScope.launch(Dispatchers.IO) {
        useCase.removeSeriesFavorite(
            ModelSingleDataMapper.seriesDetailToDomain(favorite)

        )
        favoriteTrigger
    }
}

