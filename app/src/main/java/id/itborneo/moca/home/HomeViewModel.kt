package id.itborneo.moca.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.map
import androidx.lifecycle.viewModelScope
import id.itborneo.core.domain.usecase.MocaUseCase
import id.itborneo.core.utils.Resource
import id.itborneo.moca.model.MovieModel
import id.itborneo.moca.model.SeriesModel
import id.itborneo.moca.utils.ModelDataMapper
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
        trendingMovies = useCase.getTrendingMovies().map {
            ModelDataMapper.movieListFromDomain(it)
        }
        trendingSeries = useCase.getTrendingSeries().map {
            ModelDataMapper.seriesListFromDomain(it)
        }

        nowPlayingMovie = useCase.getNowPlayingMovies().map {
            ModelDataMapper.movieListFromDomain(it)
        }
        airingTodaySeries = useCase.getAiringTodaySeries().map {
            ModelDataMapper.seriesListFromDomain(it)
        }
    }

    fun getTrendingSeries() = trendingSeries
    fun getTrendingMovies() = trendingMovies

    fun getNowPlayingMovies() = nowPlayingMovie
    fun getAiringTodaySeries() = airingTodaySeries


}