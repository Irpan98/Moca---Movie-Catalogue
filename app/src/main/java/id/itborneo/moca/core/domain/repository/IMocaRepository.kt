package id.itborneo.moca.core.domain.repository

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.paging.PagedList
import id.itborneo.moca.core.data.local.database.enitity.FavoriteMovieEntity
import id.itborneo.moca.core.data.local.database.enitity.FavoriteSeriesEntity
import id.itborneo.moca.core.domain.model.MovieModel
import id.itborneo.moca.core.domain.model.SeriesModel
import id.itborneo.moca.core.domain.model.credits.CreditsModel
import id.itborneo.moca.core.domain.model.detail.MovieDetailModel
import id.itborneo.moca.core.domain.model.detail.SeriesDetailModel
import id.itborneo.moca.core.utils.Resource
import kotlinx.coroutines.flow.Flow

interface IMocaRepository {

    fun getMovies(): Flow<Resource<List<MovieModel>>>
    fun getSeries(): Flow<Resource<List<SeriesModel>>>

    fun getDetailMovie(id: Int): Flow<Resource<MovieDetailModel>>
    fun getDetailSeries(id: Int): Flow<Resource<SeriesDetailModel>>

    fun getTrendingMovies(): Flow<Resource<List<MovieModel>>>
    fun getTrendingSeries(): Flow<Resource<List<SeriesModel>>>

    fun getNowPlayingMovies(): Flow<Resource<List<MovieModel>>>
    fun getAiringTodaySeries(): Flow<Resource<List<SeriesModel>>>

    fun getCredits(id: Int): Flow<Resource<CreditsModel>>

    fun addMovieFavorite(movieFavorite: MovieDetailModel)
    fun addSeriesFavorite(SeriesFavorite: SeriesDetailModel)

    fun removeMovieFavorite(movieFavorite: MovieDetailModel)
    fun removeSeriesFavorite(SeriesFavorite: SeriesDetailModel)

    fun getSingleMovieFavorite(id: Int): Flow<MovieModel?>
    fun getSingleSeriesFavorite(id: Int): Flow<SeriesModel?>

    fun getMovieFavorite(): DataSource.Factory<Int, MovieModel>
    fun getSeriesFavorite(): DataSource.Factory<Int, SeriesModel>

    fun searchMovies(query: String): Flow<Resource<List<MovieModel>>>
    fun searchSeries(query: String): Flow<Resource<List<SeriesModel>>>
}