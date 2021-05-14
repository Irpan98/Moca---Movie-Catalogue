package id.itborneo.core.domain.usecase

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import id.itborneo.core.domain.model.MovieDomainModel
import id.itborneo.core.domain.model.SeriesDomainModel
import id.itborneo.core.domain.model.credits.CreditsDomainModel
import id.itborneo.core.domain.model.detail.MovieDetailDomainModel
import id.itborneo.core.domain.model.detail.SeriesDetailDomainModel
import id.itborneo.core.utils.Resource
import kotlinx.coroutines.flow.Flow

interface MocaUseCase {

    fun getMovies(): LiveData<Resource<List<MovieDomainModel>>>
    fun getSeries(): LiveData<Resource<List<SeriesDomainModel>>>

    fun getDetailMovie(id: Int): LiveData<Resource<MovieDetailDomainModel>>
    fun getDetailSeries(id: Int): LiveData<Resource<SeriesDetailDomainModel>>

    fun getTrendingMovies(): LiveData<Resource<List<MovieDomainModel>>>
    fun getTrendingSeries(): LiveData<Resource<List<SeriesDomainModel>>>

    fun getNowPlayingMovies(): LiveData<Resource<List<MovieDomainModel>>>
    fun getAiringTodaySeries(): LiveData<Resource<List<SeriesDomainModel>>>

    fun getCredits(id: Int): LiveData<Resource<CreditsDomainModel>>

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