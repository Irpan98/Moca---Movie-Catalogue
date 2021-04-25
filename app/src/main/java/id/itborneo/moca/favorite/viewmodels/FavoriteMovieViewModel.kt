package id.itborneo.moca.favorite.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import id.itborneo.core.domain.model.MovieModel
import id.itborneo.core.domain.usecase.MocaUseCase
import id.itborneo.core.utils.PagedListUtils
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FavoriteMovieViewModel(private val useCase: MocaUseCase) : ViewModel() {

    private lateinit var listMovie: LiveData<PagedList<MovieModel>>

    init {
        initMovies()
    }

    private fun initMovies() = viewModelScope.launch {
        listMovie =
            LivePagedListBuilder(useCase.getMovieFavorite(), PagedListUtils.config()).build()

    }

    fun getMovies() = listMovie

}