package id.itborneo.moca.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import id.itborneo.core.domain.model.MovieModel
import id.itborneo.core.domain.model.SeriesModel
import id.itborneo.core.domain.usecase.MocaUseCase
import id.itborneo.core.utils.Resource
import kotlinx.coroutines.launch

class HomeViewModel(private val useCase: MocaUseCase) : ViewModel() {

    private lateinit var trendingMovies: LiveData<Resource<List<MovieModel>>>
    private lateinit var trendingSeries: LiveData<Resource<List<SeriesModel>>>

    private lateinit var nowPlayingMovie: LiveData<Resource<List<MovieModel>>>
    private lateinit var airingTodaySeries: LiveData<Resource<List<SeriesModel>>>

    init {
        initData()
    }

    fun initData() = viewModelScope.launch {
        trendingMovies = useCase.getTrendingMovies()
        trendingSeries = useCase.getTrendingSeries()

        nowPlayingMovie = useCase.getNowPlayingMovies()
        airingTodaySeries = useCase.getAiringTodaySeries()
    }

    fun getTrendingSeries() = trendingSeries
    fun getTrendingMovies() = trendingMovies

    fun getNowPlayingMovies() = nowPlayingMovie
    fun getAiringTodaySeries() = airingTodaySeries


}