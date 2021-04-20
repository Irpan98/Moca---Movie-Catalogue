package id.itborneo.moca.favorite.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagedList
import id.itborneo.moca.core.local.enitity.FavoriteSeriesEntity
import id.itborneo.moca.core.repository.MocaRepository
import kotlinx.coroutines.launch

class FavoriteSeriesViewModel(private val repo: MocaRepository) : ViewModel() {

    private lateinit var listSeries: LiveData<PagedList<FavoriteSeriesEntity>>

    init {
        initSeries()
    }

    private fun initSeries() = viewModelScope.launch {
        listSeries = repo.getSeriesFavorite()
    }

    fun getSeries() = listSeries

}