package id.itborneo.moca.core.repository

import id.itborneo.moca.core.source.RemoteDataSource

object MocaRepository {

    private val remoteDataSource = RemoteDataSource()

     fun getMovies() = remoteDataSource.getMovies()
    fun getSeries() = remoteDataSource.getSeries()


    fun getDetailMovie(id: Int) = remoteDataSource.getDetailMovie(id)
    fun getDetailSeries(id: Int) = remoteDataSource.getDetailSeries(id)

    fun getTrendingMovies() = remoteDataSource.getTrendingMovies()
    fun getTrendingSeries() = remoteDataSource.getTrendingSeries()

    fun getNowPlayingMovies() = remoteDataSource.getNowPlayingMovies()
    fun getAiringTodaySeries() = remoteDataSource.getAiringTodaySeries()

    fun getCredits(id: Int) = remoteDataSource.getCreditsMovie(id)
}