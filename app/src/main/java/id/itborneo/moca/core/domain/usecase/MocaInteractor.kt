package id.itborneo.moca.core.domain.usecase

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import id.itborneo.moca.core.domain.repository.IMocaRepository
import id.itborneo.moca.core.data.local.database.enitity.FavoriteMovieEntity
import id.itborneo.moca.core.data.local.database.enitity.FavoriteSeriesEntity

class MocaInteractor(private val mocaRepository: IMocaRepository) : MocaUseCase {
    override fun getMovies() = mocaRepository.getMovies()

//    override fun getSeries() = mocaRepository.getSeries()
//
//    override fun getDetailMovie(id: Int) = mocaRepository.getDetailMovie(id)
//
//    override fun getDetailSeries(id: Int) = mocaRepository.getDetailSeries(id)
//
//    override fun getTrendingMovies() = mocaRepository.getTrendingMovies()
//
//
//    override fun getTrendingSeries() = mocaRepository.getTrendingSeries()
//
//    override fun getNowPlayingMovies() = mocaRepository.getNowPlayingMovies()
//
//    override fun getAiringTodaySeries() = mocaRepository.getAiringTodaySeries()
//
//    override fun getCredits(id: Int) = mocaRepository.getCredits(id)
//
//    override fun addMovieFavorite(movieFavorite: FavoriteMovieEntity) =
//        mocaRepository.addMovieFavorite(movieFavorite)
//
//    override fun addSeriesFavorite(SeriesFavorite: FavoriteSeriesEntity) =
//        mocaRepository.addSeriesFavorite(SeriesFavorite)
//
//    override fun removeMovieFavorite(movieFavorite: FavoriteMovieEntity) =
//        mocaRepository.removeMovieFavorite(movieFavorite)
//
//    override fun removeSeriesFavorite(SeriesFavorite: FavoriteSeriesEntity) =
//        mocaRepository.removeSeriesFavorite(SeriesFavorite)
//
//    override fun getSingleMovieFavorite(id: Int): FavoriteMovieEntity? =
//        mocaRepository.getSingleMovieFavorite(id)
//
//    override fun getSingleSeriesFavorite(id: Int): FavoriteSeriesEntity? =
//        mocaRepository.getSingleSeriesFavorite(id)
//
//    override fun getMovieFavorite(): LiveData<PagedList<FavoriteMovieEntity>> =
//        mocaRepository.getMovieFavorite()
//
//    override fun getSeriesFavorite(): LiveData<PagedList<FavoriteSeriesEntity>> =
//        mocaRepository.getSeriesFavorite()
//
//    override fun searchMovies(query: String) = mocaRepository.searchMovies(query)
//
//    override fun searchSeries(query: String) = mocaRepository.searchSeries(query)

}