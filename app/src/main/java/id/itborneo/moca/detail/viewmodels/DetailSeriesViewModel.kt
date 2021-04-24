package id.itborneo.moca.detail.viewmodels

import androidx.lifecycle.*
import id.itborneo.moca.core.data.local.database.enitity.FavoriteSeriesEntity
import id.itborneo.moca.core.domain.model.SeriesModel
import id.itborneo.moca.core.domain.model.credits.CreditsModel
import id.itborneo.moca.core.domain.model.detail.SeriesDetailModel
import id.itborneo.moca.core.domain.usecase.MocaUseCase
import id.itborneo.moca.core.utils.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class DetailSeriesViewModel(private val userCase: MocaUseCase, private val id: Int) : ViewModel() {

    private lateinit var detail: LiveData<Resource<SeriesDetailModel>>
    private lateinit var credits: LiveData<Resource<CreditsModel>>
    var isFavorite = MutableLiveData(false)

    init {
        initDetailSeries()
        isFavoriteCheck()

    }

    private fun isFavoriteCheck() = viewModelScope.launch {
        withContext(Dispatchers.IO) {
            val seriesFavorite = userCase.getSingleSeriesFavorite(id)
            if (seriesFavorite != null) {
                isFavorite.postValue(true)
            } else {
                isFavorite.postValue(false)
            }
        }
    }

    private fun initDetailSeries() = viewModelScope.launch {
        detail = userCase.getDetailSeries(id).asLiveData()
        credits = userCase.getCredits(id).asLiveData()
    }

    fun getDetail() = detail
    fun getCredits() = credits

    fun addFavorite(favorite: SeriesDetailModel) = viewModelScope.launch {
        withContext(Dispatchers.IO) {
            userCase.addSeriesFavorite(favorite)
            isFavorite.postValue(true)
        }
    }

    fun removeFavorite(favorite: SeriesDetailModel) = viewModelScope.launch {
        withContext(Dispatchers.IO) {
            userCase.removeSeriesFavorite(favorite)
            isFavorite.postValue(false)
        }
    }
}

