package id.itborneo.moca.series

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import id.itborneo.moca.core.model.response.SeriesListResponse
import id.itborneo.moca.core.repository.MocaRepository
import id.itborneo.moca.core.utils.Resource
import kotlinx.coroutines.launch

class SeriesViewModel(private val repo: MocaRepository) : ViewModel() {

    private lateinit var series: LiveData<Resource<SeriesListResponse>>

    init {
        initSeries()
    }

    fun initSeries() = viewModelScope.launch {
        series = repo.getSeries()
    }

    fun getSeries() = series

}