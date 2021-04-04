package id.itborneo.moca.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import id.itborneo.moca.core.model.response.MoviesResponse
import id.itborneo.moca.core.networks.ApiConfig
import id.itborneo.moca.core.repository.MocaRepository
import id.itborneo.moca.core.utils.Resource
import kotlinx.coroutines.Dispatchers

class HomeViewModel : ViewModel() {

    private val trendingMovies: LiveData<Resource<MoviesResponse>> = reqTrendingMovies()
    private val trendingSeries: LiveData<Resource<MoviesResponse>> = reqTrendingSeries()
    private val nowPlayingMovie: LiveData<Resource<MoviesResponse>> = reqPlayingMovies()
    private val nowPlayingSeries: LiveData<Resource<MoviesResponse>> = reqPlayingSeries()

    val repo = MocaRepository()



    fun getTrendingSeries() = trendingSeries
    fun getTrendingMovies() = trendingMovies
    fun getNowPlayingMovies() = nowPlayingMovie
    fun getNowPlayingSeries() = nowPlayingSeries


}