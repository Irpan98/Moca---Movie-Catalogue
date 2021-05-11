package id.itborneo.mocafavorite.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import id.itborneo.core.domain.model.SeriesDomainModel
import id.itborneo.core.domain.usecase.MocaUseCase
import id.itborneo.core.utils.PagedListUtils
import kotlinx.coroutines.launch

class FavoriteSeriesViewModel(private val useCase: MocaUseCase) : ViewModel() {

    private lateinit var listSeries: LiveData<PagedList<SeriesDomainModel>>

    init {
        initSeries()
    }

    private fun initSeries() = viewModelScope.launch {
        listSeries =
            LivePagedListBuilder(useCase.getSeriesFavorite(), PagedListUtils.config()).build()
    }

    fun getSeries() = listSeries
}