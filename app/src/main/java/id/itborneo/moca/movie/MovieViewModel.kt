package id.itborneo.moca.movie

import androidx.lifecycle.*
import id.itborneo.core.domain.model.MovieModel
import id.itborneo.core.domain.usecase.MocaUseCase
import id.itborneo.core.utils.Resource
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch

@FlowPreview
class MovieViewModel(private val useCase: MocaUseCase) : ViewModel() {

    private lateinit var listMovie: Flow<Resource<List<MovieModel>>>

    private val searchQuery = MutableLiveData<String>()

    private val searchedMovies = object : MutableLiveData<Resource<List<MovieModel>>>() {
        override fun onActive() {
            value?.let { return }
            viewModelScope.launch {
                searchQuery.asFlow()
                    .debounce(300) // Wait
                    .distinctUntilChanged() // Ignore same value (This is the default operator)
                    .collect {
                        useCase.searchMovies(it).collect { getValue ->
                            value = getValue
                        }
                    }
            }
        }
    }

    init {
        initMovies()
    }

    fun initMovies() = viewModelScope.launch {
        listMovie = useCase.getMovies()
    }


    fun setSearch(query: String): Unit = searchQuery.postValue(query)
    fun getMovies() = listMovie.asLiveData()
    fun getSearched() = searchedMovies


}
