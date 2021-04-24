package id.itborneo.moca.core.domain.usecase

import id.itborneo.moca.core.domain.model.MovieModel
import id.itborneo.moca.core.domain.model.SeriesModel
import id.itborneo.moca.core.domain.model.credits.CreditsModel
import id.itborneo.moca.core.domain.model.detail.MovieDetailModel
import id.itborneo.moca.core.domain.model.detail.SeriesDetailModel
import id.itborneo.moca.core.utils.Resource
import kotlinx.coroutines.flow.Flow

interface MocaUseCase {

    fun getMovies(): Flow<Resource<List<MovieModel>>>
    fun getSeries(): Flow<Resource<List<SeriesModel>>>

    fun getDetailMovie(id: Int): Flow<Resource<MovieDetailModel>>
    fun getDetailSeries(id: Int): Flow<Resource<SeriesDetailModel>>

    fun getTrendingMovies(): Flow<Resource<List<MovieModel>>>
    fun getTrendingSeries(): Flow<Resource<List<SeriesModel>>>

    fun getNowPlayingMovies(): Flow<Resource<List<MovieModel>>>
    fun getAiringTodaySeries(): Flow<Resource<List<SeriesModel>>>

    fun getCredits(id: Int): Flow<Resource<CreditsModel>>

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
    fun searchMovies(query: String): Flow<Resource<List<MovieModel>>>
    fun searchSeries(query: String): Flow<Resource<List<SeriesModel>>>
}