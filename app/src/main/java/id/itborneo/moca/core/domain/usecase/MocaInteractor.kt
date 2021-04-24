package id.itborneo.moca.core.domain.usecase

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import id.itborneo.moca.core.domain.repository.IMocaRepository
import id.itborneo.moca.core.data.local.database.enitity.FavoriteMovieEntity
import id.itborneo.moca.core.data.local.database.enitity.FavoriteSeriesEntity
import id.itborneo.moca.core.domain.model.MovieModel
import id.itborneo.moca.core.domain.model.SeriesModel
import id.itborneo.moca.core.domain.model.detail.MovieDetailModel
import id.itborneo.moca.core.domain.model.detail.SeriesDetailModel

class MocaInteractor(private val mocaRepository: IMocaRepository) : MocaUseCase {
    override fun getMovies() = mocaRepository.getMovies()
    override fun getSeries() = mocaRepository.getSeries()

    override fun getDetailMovie(id: Int) = mocaRepository.getDetailMovie(id)
    override fun getDetailSeries(id: Int) = mocaRepository.getDetailSeries(id)

    override fun getTrendingMovies() = mocaRepository.getTrendingMovies()
    override fun getTrendingSeries() = mocaRepository.getTrendingSeries()

    override fun getNowPlayingMovies() = mocaRepository.getNowPlayingMovies()
    override fun getAiringTodaySeries() = mocaRepository.getAiringTodaySeries()

    override fun getCredits(id: Int) = mocaRepository.getCredits(id)

    override fun addMovieFavorite(movieFavorite: MovieDetailModel) =
        mocaRepository.addMovieFavorite(movieFavorite)

    override fun addSeriesFavorite(SeriesFavorite: SeriesDetailModel) =
        mocaRepository.addSeriesFavorite(SeriesFavorite)

    override fun removeMovieFavorite(movieFavorite: MovieDetailModel) =
        mocaRepository.removeMovieFavorite(movieFavorite)

    override fun removeSeriesFavorite(SeriesFavorite: SeriesDetailModel) =
        mocaRepository.removeSeriesFavorite(SeriesFavorite)

    override fun getSingleMovieFavorite(id: Int): MovieModel? =
        mocaRepository.getSingleMovieFavorite(id)

    override fun getSingleSeriesFavorite(id: Int): SeriesModel? =
        mocaRepository.getSingleSeriesFavorite(id)

    override fun getMovieFavorite(): LiveData<PagedList<MovieModel>> =
        mocaRepository.getMovieFavorite()

    override fun getSeriesFavorite(): LiveData<PagedList<SeriesModel>> =
        mocaRepository.getSeriesFavorite()

    override fun searchMovies(query: String) = mocaRepository.searchMovies(query)

    override fun searchSeries(query: String) = mocaRepository.searchSeries(query)

}