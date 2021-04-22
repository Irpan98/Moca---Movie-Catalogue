package id.itborneo.moca.series

import androidx.lifecycle.*
import id.itborneo.moca.core.model.response.SeriesListResponse
import id.itborneo.moca.core.repository.MocaRepository
import id.itborneo.moca.core.utils.Resource
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch

@FlowPreview
class SeriesViewModel(private val repo: MocaRepository) : ViewModel() {

    private lateinit var series: LiveData<Resource<SeriesListResponse>>
    private val searchQuery = MutableLiveData<String>()
    private val searchedSeries = object : MutableLiveData<Resource<SeriesListResponse>>() {
        override fun onActive() {
            value?.let { return }
            viewModelScope.launch {
                searchQuery.asFlow()
                    .debounce(300) // Wait
                    .distinctUntilChanged() // Ignore same value (This is the default operator)
                    .collect {
                        repo.searchSeries(it).collect { getValue ->
                            value = getValue
                        }
                    }
            }
        }
    }

    init {
        initSeries()
    }

    fun initSeries() = viewModelScope.launch {
        series = repo.getSeries().asLiveData()
    }

    fun setSearch(query: String) {
        searchQuery.postValue(query)
    }

    fun getSeries() = series

    fun getSearched() = searchedSeries


}