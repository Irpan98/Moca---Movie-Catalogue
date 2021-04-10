package id.itborneo.moca.core.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import id.itborneo.moca.core.repository.MocaRepository
import id.itborneo.moca.detail.DetailSeriesViewModel
import id.itborneo.moca.detail.DetailViewModel
import id.itborneo.moca.movie.MovieViewModel

@Suppress("UNCHECKED_CAST")
class ViewModelFactory(
    private val repository: MocaRepository,
    private val any: Any? = null,
    private val any2: Any? = null,

    ) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        when {
            modelClass.isAssignableFrom(MovieViewModel::class.java) -> return MovieViewModel(
                repository,
//                any as Int
            ) as T
            modelClass.isAssignableFrom(DetailViewModel::class.java) -> return DetailViewModel(
                repository,
                any as Int
            ) as T
            modelClass.isAssignableFrom(DetailSeriesViewModel::class.java) -> return DetailSeriesViewModel(
                repository,
                any as Int
            ) as T
            else -> throw IllegalArgumentException()
        }

    }
}