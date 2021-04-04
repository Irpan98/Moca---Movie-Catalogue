package id.itborneo.moca.core.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import id.itborneo.moca.core.model.MovieModel
import id.itborneo.moca.core.model.SeriesModel
import id.itborneo.moca.detail.DetailSeriesViewModel
import id.itborneo.moca.detail.DetailViewModel

@Suppress("UNCHECKED_CAST")
class ViewModelFactory(
//    private val repository: MainRepository,
    private val any: Any? = null,
    private val any2: Any? = null,

    ) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DetailViewModel::class.java))
            return DetailViewModel(
//                repository,
                any as Int
            ) as T
        else if (modelClass.isAssignableFrom(DetailSeriesViewModel::class.java))
            return DetailSeriesViewModel(
//                repository,
                any as Int
            ) as T
        throw IllegalArgumentException()

    }
}