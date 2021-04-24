package id.itborneo.moca.core.data

import androidx.paging.LivePagedListBuilder
import id.itborneo.moca.core.data.local.database.enitity.FavoriteMovieEntity
import id.itborneo.moca.core.data.local.database.enitity.FavoriteSeriesEntity
import id.itborneo.moca.core.domain.repository.IMocaRepository
import id.itborneo.moca.core.data.local.LocalDataSource
import id.itborneo.moca.core.data.remote.RemoteDataSource
import id.itborneo.moca.core.utils.PagedListUtils

class MocaRepository(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource
) : IMocaRepository {

    override fun getMovies() = remoteDataSource.getMovies()
    override fun getSeries() = remoteDataSource.getSeries()

    override fun getDetailMovie(id: Int) = remoteDataSource.getDetailMovie(id)
    override fun getDetailSeries(id: Int) = remoteDataSource.getDetailSeries(id)

    override fun getTrendingMovies() = remoteDataSource.getTrendingMovies()
    override fun getTrendingSeries() = remoteDataSource.getTrendingSeries()

    override fun getNowPlayingMovies() = remoteDataSource.getNowPlayingMovies()
    override fun getAiringTodaySeries() = remoteDataSource.getAiringTodaySeries()

    override fun getCredits(id: Int) = remoteDataSource.getCredits(id)

//    override fun addMovieFavorite(movieFavorite: FavoriteMovieEntity) =
//        localDataSource.addMovieFavorite(movieFavorite)
//
//    override fun removeMovieFavorite(movieFavorite: FavoriteMovieEntity) =
//        localDataSource.removeMovieFavorite(movieFavorite)
//
//    override fun getSingleMovieFavorite(id: Int) = localDataSource.getSingleMovieFavorite(id)
//
//    override fun addSeriesFavorite(SeriesFavorite: FavoriteSeriesEntity) =
//        localDataSource.addSeriesFavorite(SeriesFavorite)
//
//    override fun removeSeriesFavorite(SeriesFavorite: FavoriteSeriesEntity) =
//        localDataSource.removeSeriesFavorite(SeriesFavorite)
//
//    override fun getSingleSeriesFavorite(id: Int) = localDataSource.getSingleSeriesFavorite(id)
//
//    override fun getMovieFavorite() =
//        LivePagedListBuilder(localDataSource.getMovieFavorites(), PagedListUtils.config()).build()
//
//    override fun getSeriesFavorite() =
//        LivePagedListBuilder(localDataSource.getSeriesFavorites(), PagedListUtils.config()).build()
//
    override fun searchMovies(query: String) = remoteDataSource.searchMovies(query)
    override fun searchSeries(query: String) = remoteDataSource.searchSeries(query)

}