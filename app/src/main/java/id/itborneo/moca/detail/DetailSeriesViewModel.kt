package id.itborneo.moca.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import id.itborneo.moca.core.local.enitity.FavoriteSeriesEntity
import id.itborneo.moca.core.model.credits.CreditsModel
import id.itborneo.moca.core.model.detail.SeriesDetailModel
import id.itborneo.moca.core.repository.MocaRepository
import id.itborneo.moca.core.utils.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class DetailSeriesViewModel(private val repo: MocaRepository, private val id: Int) : ViewModel() {

    private lateinit var detail: LiveData<Resource<SeriesDetailModel>>
    private lateinit var credits: LiveData<Resource<CreditsModel>>
    var isFavorite = MutableLiveData(false)

    init {
        initDetailSeries()
    }

    private fun isFavoriteCheck() = viewModelScope.launch {
        withContext(Dispatchers.IO) {
            val SeriesFavorite = repo.getSingleSeriesFavorite(id)
            if (SeriesFavorite != null) {
                isFavorite.postValue(true)
            } else {
                isFavorite.postValue(false)
            }
        }
    }
    
    fun initDetailSeries() = viewModelScope.launch {
        detail = repo.getDetailSeries(id)
        credits = repo.getCredits(id)
    }

    fun getDetail() = detail
    fun getCredits() = credits

    fun addFavorite(favorite: FavoriteSeriesEntity) = viewModelScope.launch {
        withContext(Dispatchers.IO) {
            repo.addSeriesFavorite(favorite)
            isFavorite.postValue(true)
        }
    }

    fun removeFavorite(favorite: FavoriteSeriesEntity) = viewModelScope.launch {
        withContext(Dispatchers.IO) {
            repo.removeSeriesFavorite(favorite)
            isFavorite.postValue(false)
        }
    }
}

