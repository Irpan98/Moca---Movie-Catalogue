package id.itborneo.moca.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import id.itborneo.moca.core.data.remote.response.MovieListResponse
import id.itborneo.moca.core.data.remote.response.SeriesListResponse
import id.itborneo.moca.core.domain.usecase.MocaUseCase
import id.itborneo.moca.core.utils.Resource
import kotlinx.coroutines.launch

class HomeViewModel(private val useCase: MocaUseCase) : ViewModel() {


    private lateinit var trendingMovies: LiveData<Resource<MovieListResponse>>
    private lateinit var trendingSeries: LiveData<Resource<SeriesListResponse>>

    private lateinit var nowPlayingMovie: LiveData<Resource<MovieListResponse>>
    private lateinit var airingTodaySeries: LiveData<Resource<SeriesListResponse>>

    init {
        initData()
    }

    private fun initData() = viewModelScope.launch {
//        trendingMovies = useCase.getTrendingMovies().asLiveData()
//        trendingSeries = useCase.getTrendingSeries().asLiveData()
//
//        nowPlayingMovie = useCase.getNowPlayingMovies().asLiveData()
//        airingTodaySeries = useCase.getAiringTodaySeries().asLiveData()
    }


    fun getTrendingSeries() = trendingSeries
    fun getTrendingMovies() = trendingMovies

    fun getNowPlayingMovies() = nowPlayingMovie
    fun getAiringTodaySeries() = airingTodaySeries

}