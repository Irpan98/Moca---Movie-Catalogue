package id.itborneo.moca.favorite.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagedList
import id.itborneo.moca.core.data.local.database.enitity.FavoriteMovieEntity
import id.itborneo.moca.core.domain.usecase.MocaUseCase
import kotlinx.coroutines.launch

class FavoriteMovieViewModel(private val useCase: MocaUseCase) : ViewModel() {

    private lateinit var listMovie: LiveData<PagedList<FavoriteMovieEntity>>

    init {
        initMovies()
    }

    private fun initMovies() = viewModelScope.launch {
//        listMovie = useCase.getMovieFavorite()
    }

    fun getMovies() = listMovie

}