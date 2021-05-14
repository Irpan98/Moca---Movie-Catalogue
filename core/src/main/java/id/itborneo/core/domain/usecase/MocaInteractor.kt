package id.itborneo.core.domain.usecase

import androidx.lifecycle.asLiveData
import id.itborneo.core.domain.model.detail.MovieDetailDomainModel
import id.itborneo.core.domain.model.detail.SeriesDetailDomainModel
import id.itborneo.core.domain.repository.IMocaRepository

class MocaInteractor(private val mocaRepository: IMocaRepository) : MocaUseCase {
    override fun getMovies() = mocaRepository.getMovies().asLiveData()
    override fun getSeries() = mocaRepository.getSeries().asLiveData()

    override fun getDetailMovie(id: Int) = mocaRepository.getDetailMovie(id).asLiveData()
    override fun getDetailSeries(id: Int) = mocaRepository.getDetailSeries(id).asLiveData()

    override fun getTrendingMovies() = mocaRepository.getTrendingMovies().asLiveData()
    override fun getTrendingSeries() = mocaRepository.getTrendingSeries().asLiveData()

    override fun getNowPlayingMovies() = mocaRepository.getNowPlayingMovies().asLiveData()
    override fun getAiringTodaySeries() = mocaRepository.getAiringTodaySeries().asLiveData()

    override fun getCredits(id: Int) = mocaRepository.getCredits(id).asLiveData()

    override fun addMovieFavorite(movieFavorite: MovieDetailDomainModel) =
        mocaRepository.addMovieFavorite(movieFavorite)

    override fun addSeriesFavorite(SeriesFavorite: SeriesDetailDomainModel) =
        mocaRepository.addSeriesFavorite(SeriesFavorite)

    override fun removeMovieFavorite(movieFavorite: MovieDetailDomainModel) =
        mocaRepository.removeMovieFavorite(movieFavorite)

    override fun removeSeriesFavorite(SeriesFavorite: SeriesDetailDomainModel) =
        mocaRepository.removeSeriesFavorite(SeriesFavorite)

    override fun getSingleMovieFavorite(id: Int) =
        mocaRepository.getSingleMovieFavorite(id)

    override fun getSingleSeriesFavorite(id: Int) =
        mocaRepository.getSingleSeriesFavorite(id)

    override fun getMovieFavorite() =
        mocaRepository.getMovieFavorite()

    override fun getSeriesFavorite() =
        mocaRepository.getSeriesFavorite()

    override fun searchMovies(query: String) = mocaRepository.searchMovies(query)

    override fun searchSeries(query: String) = mocaRepository.searchSeries(query)

}