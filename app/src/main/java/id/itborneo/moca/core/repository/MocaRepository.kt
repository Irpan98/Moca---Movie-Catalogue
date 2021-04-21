package id.itborneo.moca.core.repository

import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import id.itborneo.moca.core.local.enitity.FavoriteMovieEntity
import id.itborneo.moca.core.local.enitity.FavoriteSeriesEntity
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

    fun getCredits(id: Int) = remoteDataSource.getCredits(id)

    fun addMovieFavorite(movieFavorite: FavoriteMovieEntity) =
        localDataSource.addMovieFavorite(movieFavorite)

    fun removeMovieFavorite(movieFavorite: FavoriteMovieEntity) =
        localDataSource.removeMovieFavorite(movieFavorite)

    fun getSingleMovieFavorite(id: Int) = localDataSource.getSingleMovieFavorite(id)

    fun addSeriesFavorite(SeriesFavorite: FavoriteSeriesEntity) =
        localDataSource.addSeriesFavorite(SeriesFavorite)

    fun removeSeriesFavorite(SeriesFavorite: FavoriteSeriesEntity) =
        localDataSource.removeSeriesFavorite(SeriesFavorite)

    fun getSingleSeriesFavorite(id: Int) = localDataSource.getSingleSeriesFavorite(id)

    fun getMovieFavorite() =
        LivePagedListBuilder(localDataSource.getMovieFavorites(), config()).build()

    fun getSeriesFavorite() =
        LivePagedListBuilder(localDataSource.getSeriesFavorites(), config()).build()

    private fun config(): PagedList.Config {
        return PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(4)
            .setPageSize(4)
            .build()
    }

    fun searchMovies(query: String) = remoteDataSource.searchMovies(query)
    fun searchSeries(query: String) = remoteDataSource.searchSeries(query)

}