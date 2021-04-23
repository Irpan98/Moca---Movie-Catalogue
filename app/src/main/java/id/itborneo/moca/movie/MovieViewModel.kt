package id.itborneo.moca.movie

import androidx.lifecycle.*
import id.itborneo.moca.core.data.remote.response.MovieListResponse
import id.itborneo.moca.core.domain.model.MovieModel
import id.itborneo.moca.core.domain.usecase.MocaUseCase
import id.itborneo.moca.core.utils.Resource
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.launch

@FlowPreview
class MovieViewModel(private val useCase: MocaUseCase) : ViewModel() {

    private lateinit var listMovie: LiveData<Resource<List<MovieModel>>>

    private val searchQuery = MutableLiveData<String>()
    private val searchedMovies = object : MutableLiveData<Resource<MovieListResponse>>() {
        override fun onActive() {
//            value?.let { return }
//            viewModelScope.launch {
//                searchQuery.asFlow()
//                    .debounce(300) // Wait
//                    .distinctUntilChanged() // Ignore same value (This is the default operator)
//                    .collect {
//                        useCase.searchMovies(it).collect { getValue ->
//                            value = getValue
//                        }
//                    }
//            }
        }
    }

    init {
        initMovies()
    }

    fun initMovies() = viewModelScope.launch {
        listMovie = useCase.getMovies().asLiveData()
    }


    fun setSearch(query: String): Unit = searchQuery.postValue(query)
    fun getMovies() = listMovie
    fun getSearched() = searchedMovies


}
