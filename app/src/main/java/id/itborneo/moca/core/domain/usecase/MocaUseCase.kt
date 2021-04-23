package id.itborneo.moca.core.domain.usecase

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import id.itborneo.moca.core.data.local.database.enitity.FavoriteMovieEntity
import id.itborneo.moca.core.data.local.database.enitity.FavoriteSeriesEntity
import id.itborneo.moca.core.data.remote.response.MovieListResponse
import id.itborneo.moca.core.data.remote.response.SeriesListResponse
import id.itborneo.moca.core.domain.model.MovieModel
import id.itborneo.moca.core.domain.model.credits.CreditsModel
import id.itborneo.moca.core.domain.model.detail.MovieDetailModel
import id.itborneo.moca.core.domain.model.detail.SeriesDetailModel
import id.itborneo.moca.core.utils.Resource
import kotlinx.coroutines.flow.Flow

interface MocaUseCase {

    fun getMovies(): Flow<Resource<List<MovieModel>>>
//    fun getSeries(): Flow<Resource<SeriesListResponse>>
//
//    fun getDetailMovie(id: Int): Flow<Resource<MovieDetailModel>>
//    fun getDetailSeries(id: Int): Flow<Resource<SeriesDetailModel>>
//
//    fun getTrendingMovies(): Flow<Resource<MovieListResponse>>
//    fun getTrendingSeries(): Flow<Resource<SeriesListResponse>>
//
//    fun getNowPlayingMovies(): Flow<Resource<MovieListResponse>>
//    fun getAiringTodaySeries(): Flow<Resource<SeriesListResponse>>
//
//    fun getCredits(id: Int): Flow<Resource<CreditsModel>>
//
//    fun addMovieFavorite(movieFavorite: FavoriteMovieEntity)
//    fun addSeriesFavorite(SeriesFavorite: FavoriteSeriesEntity)
//
//    fun removeMovieFavorite(movieFavorite: FavoriteMovieEntity)
//    fun removeSeriesFavorite(SeriesFavorite: FavoriteSeriesEntity)
//
//    fun getSingleMovieFavorite(id: Int): FavoriteMovieEntity?
//    fun getSingleSeriesFavorite(id: Int): FavoriteSeriesEntity?
//
//    fun getMovieFavorite(): LiveData<PagedList<FavoriteMovieEntity>>
//    fun getSeriesFavorite(): LiveData<PagedList<FavoriteSeriesEntity>>
//
//    fun searchMovies(query: String): Flow<Resource<MovieListResponse>>
//    fun searchSeries(query: String): Flow<Resource<SeriesListResponse>>
}