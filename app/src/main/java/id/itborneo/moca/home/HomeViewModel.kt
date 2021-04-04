package id.itborneo.moca.home

import androidx.lifecycle.ViewModel
import id.itborneo.moca.core.repository.MocaRepository

class HomeViewModel : ViewModel() {

    private val repo = MocaRepository()

    private val trendingMovies = repo.getTrendingMovies()
    private val trendingSeries = repo.getTrendingSeries()

    private val nowPlayingMovie = repo.getNowPlayingMovies()
    private val airingTodaySeries = repo.getAiringTodaySeries()

    fun getTrendingSeries() = trendingSeries
    fun getTrendingMovies() = trendingMovies

    fun getNowPlayingMovies() = nowPlayingMovie
    fun getAiringTodaySeries() = airingTodaySeries

}