package id.itborneo.moca.core.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import id.itborneo.moca.core.repository.MocaRepository
import id.itborneo.moca.detail.DetailMovieViewModel
import id.itborneo.moca.detail.DetailSeriesViewModel
import id.itborneo.moca.home.HomeViewModel
import id.itborneo.moca.movie.MovieViewModel
import id.itborneo.moca.series.SeriesViewModel

@Suppress("UNCHECKED_CAST")
class ViewModelFactory(
    private val repository: MocaRepository,
    private val any: Any? = null,
    private val any2: Any? = null,

    ) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(HomeViewModel::class.java) -> HomeViewModel(
                repository,
            ) as T
            modelClass.isAssignableFrom(MovieViewModel::class.java) -> MovieViewModel(
                repository,
            ) as T
            modelClass.isAssignableFrom(SeriesViewModel::class.java) -> SeriesViewModel(
                repository,
            ) as T
            modelClass.isAssignableFrom(DetailMovieViewModel::class.java) -> DetailMovieViewModel(
                repository,
                any as Int
            ) as T
            modelClass.isAssignableFrom(DetailSeriesViewModel::class.java) -> DetailSeriesViewModel(
                repository,
                any as Int
            ) as T
            else -> throw IllegalArgumentException()
        }

    }
}