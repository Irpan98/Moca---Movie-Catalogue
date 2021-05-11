package id.itborneo.core.domain.repository

import androidx.paging.DataSource
import id.itborneo.core.domain.model.MovieDomainModel
import id.itborneo.core.domain.model.SeriesDomainModel
import id.itborneo.core.domain.model.credits.CreditsDomainModel
import id.itborneo.core.domain.model.detail.MovieDetailDomainModel
import id.itborneo.core.domain.model.detail.SeriesDetailDomainModel
import id.itborneo.core.utils.Resource
import kotlinx.coroutines.flow.Flow

interface IMocaRepository {

    fun getMovies(): Flow<Resource<List<MovieDomainModel>>>
    fun getSeries(): Flow<Resource<List<SeriesDomainModel>>>

    fun getDetailMovie(id: Int): Flow<Resource<MovieDetailDomainModel>>
    fun getDetailSeries(id: Int): Flow<Resource<SeriesDetailDomainModel>>

    fun getTrendingMovies(): Flow<Resource<List<MovieDomainModel>>>
    fun getTrendingSeries(): Flow<Resource<List<SeriesDomainModel>>>

    fun getNowPlayingMovies(): Flow<Resource<List<MovieDomainModel>>>
    fun getAiringTodaySeries(): Flow<Resource<List<SeriesDomainModel>>>

    fun getCredits(id: Int): Flow<Resource<CreditsDomainModel>>

    fun addMovieFavorite(movieFavorite: MovieDetailDomainModel)
    fun addSeriesFavorite(SeriesFavorite: SeriesDetailDomainModel)

    fun removeMovieFavorite(movieFavorite: MovieDetailDomainModel)
    fun removeSeriesFavorite(SeriesFavorite: SeriesDetailDomainModel)

    fun getSingleMovieFavorite(id: Int): Flow<MovieDomainModel?>
    fun getSingleSeriesFavorite(id: Int): Flow<SeriesDomainModel?>

    fun getMovieFavorite(): DataSource.Factory<Int, MovieDomainModel>
    fun getSeriesFavorite(): DataSource.Factory<Int, SeriesDomainModel>

    fun searchMovies(query: String): Flow<Resource<List<MovieDomainModel>>>
    fun searchSeries(query: String): Flow<Resource<List<SeriesDomainModel>>>
}