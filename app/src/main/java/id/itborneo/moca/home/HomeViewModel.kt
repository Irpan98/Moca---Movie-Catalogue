package id.itborneo.moca.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import id.itborneo.moca.core.model.response.MoviesResponse
import id.itborneo.moca.core.repository.MocaRepository
import id.itborneo.moca.core.utils.Resource

class HomeViewModel : ViewModel() {

    private val repo = MocaRepository()

    private val trendingMovies: LiveData<Resource<MoviesResponse>> = repo.getTrendingMovies()
    private val trendingSeries: LiveData<Resource<MoviesResponse>> = repo.getTrendingSeries()

    fun getTrendingSeries() = trendingSeries
    fun getTrendingMovies() = trendingMovies
    fun getNowPlayingMovies() = nowPlayingMovie
    fun getNowPlayingSeries() = nowPlayingSeries

}