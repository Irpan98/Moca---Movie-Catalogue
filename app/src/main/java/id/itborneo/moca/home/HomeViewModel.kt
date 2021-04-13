package id.itborneo.moca.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import id.itborneo.moca.core.model.response.MovieListResponse
import id.itborneo.moca.core.model.response.SeriesListResponse
import id.itborneo.moca.core.repository.MocaRepository
import id.itborneo.moca.core.utils.Resource
import kotlinx.coroutines.launch

class HomeViewModel(private val repo: MocaRepository) : ViewModel() {


    private lateinit var trendingMovies: LiveData<Resource<MovieListResponse>>
    private lateinit var trendingSeries: LiveData<Resource<SeriesListResponse>>

    private lateinit var nowPlayingMovie: LiveData<Resource<MovieListResponse>>
    private lateinit var airingTodaySeries: LiveData<Resource<SeriesListResponse>>

    init {
        initData()
    }

    fun initData() = viewModelScope.launch {
        trendingMovies = repo.getTrendingMovies()
        trendingSeries = repo.getTrendingSeries()

        nowPlayingMovie = repo.getNowPlayingMovies()
        airingTodaySeries = repo.getAiringTodaySeries()
    }


    fun getTrendingSeries() = trendingSeries
    fun getTrendingMovies() = trendingMovies

    fun getNowPlayingMovies() = nowPlayingMovie
    fun getAiringTodaySeries() = airingTodaySeries

}