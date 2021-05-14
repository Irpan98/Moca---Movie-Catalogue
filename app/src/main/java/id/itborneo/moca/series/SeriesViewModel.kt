package id.itborneo.moca.series

import androidx.lifecycle.*
import id.itborneo.core.domain.usecase.MocaUseCase
import id.itborneo.core.utils.Resource
import id.itborneo.moca.model.SeriesModel
import id.itborneo.moca.utils.ModelDataMapper
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch

@FlowPreview
class SeriesViewModel(private val useCase: MocaUseCase) : ViewModel() {

    private lateinit var series: LiveData<Resource<List<SeriesModel>>>
    private val searchQuery = MutableLiveData<String>()
    private val searchedSeries = object : MutableLiveData<Resource<List<SeriesModel>>>() {
        override fun onActive() {
            value?.let { return }
            viewModelScope.launch {
                searchQuery.asFlow()
                    .debounce(300) // Wait
                    .distinctUntilChanged() // Ignore same value (This is the default operator)
                    .collect {
                        useCase.searchSeries(it).collect { getValue ->
                            value = ModelDataMapper.seriesListFromDomain(getValue)
                        }
                    }
            }
        }
    }

    init {
        initSeries()
    }

    fun initSeries() = viewModelScope.launch {
        series = useCase.getSeries().map {
            ModelDataMapper.seriesListFromDomain(it)
        }
    }

    fun setSearch(query: String): Unit = searchQuery.postValue(query)
    fun getSeries() = series
    fun getSearched() = searchedSeries


}