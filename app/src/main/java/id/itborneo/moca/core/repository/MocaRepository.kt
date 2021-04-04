package id.itborneo.moca.core.repository

import id.itborneo.moca.core.source.RemoteDataSource

class MocaRepository {

    private val remoteDataSource = RemoteDataSource()

    fun getMovies() = remoteDataSource.getMovies()
    fun getDetailMovie(id: Int) = remoteDataSource.getDetailMovie(id)

    fun getTrendingMovies() = remoteDataSource.getTrendingMovies()
    fun getTrendingSeries() = remoteDataSource.getTrendingSeries()

    fun getNowPlayingMovies() = remoteDataSource.getNowPlayingMovies()
    fun getAiringTodaySeries() = remoteDataSource.getAiringTodaySeries()

    fun getCredits(id: Int) = remoteDataSource.getCreditsMovie(id)
}