package id.itborneo.moca.favorite.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagedList
import id.itborneo.moca.core.data.local.database.enitity.FavoriteSeriesEntity
import id.itborneo.moca.core.domain.usecase.MocaUseCase
import kotlinx.coroutines.launch

class FavoriteSeriesViewModel(private val useCase: MocaUseCase) : ViewModel() {

    private lateinit var listSeries: LiveData<PagedList<FavoriteSeriesEntity>>

    init {
        initSeries()
    }

    private fun initSeries() = viewModelScope.launch {
//        listSeries = useCase.getSeriesFavorite()
    }

    fun getSeries() = listSeries

}