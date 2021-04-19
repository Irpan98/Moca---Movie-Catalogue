package id.itborneo.moca.core.repository

import id.itborneo.moca.core.local.enitity.FavoriteMovieEntity
import id.itborneo.moca.core.source.LocalDataSource
import id.itborneo.moca.core.source.RemoteDataSource

class MocaRepository(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource
) {

    fun getMovies() = remoteDataSource.getMovies()
    fun getSeries() = remoteDataSource.getSeries()

    fun getDetailMovie(id: Int) = remoteDataSource.getDetailMovie(id)
    fun getDetailSeries(id: Int) = remoteDataSource.getDetailSeries(id)

    fun getTrendingMovies() = remoteDataSource.getTrendingMovies()
    fun getTrendingSeries() = remoteDataSource.getTrendingSeries()

    fun getNowPlayingMovies() = remoteDataSource.getNowPlayingMovies()
    fun getAiringTodaySeries() = remoteDataSource.getAiringTodaySeries()

    fun getCredits(id: Int) = remoteDataSource.getCreditsMovie(id)

    fun addMovieFavorite(movieFavorite: FavoriteMovieEntity) =
        localDataSource.addMovieFavorite(movieFavorite)

    fun removeMovieFavorite(movieFavorite: FavoriteMovieEntity) =
        localDataSource.removeMovieFavorite (movieFavorite)


    fun getSingleMovieFavorite(id: Int) = localDataSource.getSingleMovieFavorite(id)
}