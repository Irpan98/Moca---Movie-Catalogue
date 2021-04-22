package id.itborneo.moca.series

import androidx.lifecycle.*
import id.itborneo.moca.core.model.response.SeriesListResponse
import id.itborneo.moca.core.repository.MocaRepository
import id.itborneo.moca.core.utils.Resource
import kotlinx.coroutines.launch

class SeriesViewModel(private val repo: MocaRepository) : ViewModel() {

    private lateinit var series: LiveData<Resource<SeriesListResponse>>
    private val searchQuery = MutableLiveData<String>()
    private var searchedSeries = Transformations.switchMap(searchQuery) {
        repo.searchSeries(it).asLiveData()
    } as MutableLiveData<Resource<SeriesListResponse>>

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