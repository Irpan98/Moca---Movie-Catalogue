package id.itborneo.moca.core.data

import androidx.paging.LivePagedListBuilder
import id.itborneo.moca.core.data.local.LocalDataSource
import id.itborneo.moca.core.data.remote.RemoteDataSource
import id.itborneo.moca.core.domain.model.detail.MovieDetailModel
import id.itborneo.moca.core.domain.model.detail.SeriesDetailModel
import id.itborneo.moca.core.domain.repository.IMocaRepository
import id.itborneo.moca.core.utils.DataMapper
import id.itborneo.moca.core.utils.PagedListUtils
import id.itborneo.moca.core.utils.extension.toListFavoriteMovieModel
import id.itborneo.moca.core.utils.extension.toListFavoriteSeriesModel

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

    override fun addMovieFavorite(movieFavorite: MovieDetailModel) =
        localDataSource.addMovieFavorite(DataMapper.detailMovieToFavorite(movieFavorite))

    override fun addSeriesFavorite(SeriesFavorite: SeriesDetailModel) =
        localDataSource.addSeriesFavorite(DataMapper.detailSeriesToFavorite(SeriesFavorite))


    override fun removeMovieFavorite(movieFavorite: MovieDetailModel) =
        localDataSource.removeMovieFavorite(DataMapper.detailMovieToFavorite(movieFavorite))

    override fun removeSeriesFavorite(SeriesFavorite: SeriesDetailModel) =
        localDataSource.removeSeriesFavorite(DataMapper.detailSeriesToFavorite(SeriesFavorite))

    override fun getSingleMovieFavorite(id: Int) =
        localDataSource.getSingleMovieFavorite(id)?.toListFavoriteMovieModel()

    override fun getSingleSeriesFavorite(id: Int) =
        localDataSource.getSingleSeriesFavorite(id)?.toListFavoriteSeriesModel()

    override fun getMovieFavorite() =
        LivePagedListBuilder(localDataSource.getMovieFavorites().map {
            it.toListFavoriteMovieModel()
        }, PagedListUtils.config()).build()

    override fun getSeriesFavorite() =
        LivePagedListBuilder(localDataSource.getSeriesFavorites().map {
            it.toListFavoriteSeriesModel()
        }, PagedListUtils.config()).build()

    override fun searchMovies(query: String) = remoteDataSource.searchMovies(query)
    override fun searchSeries(query: String) = remoteDataSource.searchSeries(query)

}