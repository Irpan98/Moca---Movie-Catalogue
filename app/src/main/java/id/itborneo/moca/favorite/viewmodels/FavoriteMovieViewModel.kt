package id.itborneo.moca.favorite.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagedList
import id.itborneo.moca.core.local.enitity.FavoriteMovieEntity
import id.itborneo.moca.core.repository.MocaRepository
import kotlinx.coroutines.launch

class FavoriteMovieViewModel(private val repo: MocaRepository) : ViewModel() {

    private lateinit var listMovie: LiveData<PagedList<FavoriteMovieEntity>>

    init {
        initMovies()
    }

    private fun initMovies() = viewModelScope.launch {
        listMovie = repo.getMovieFavorite()
    }

    fun getMovies() = listMovie

}