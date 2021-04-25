package id.itborneo.core.data.local

import id.itborneo.core.data.local.database.MocaDao
import id.itborneo.core.data.local.database.enitity.FavoriteMovieEntity
import id.itborneo.core.data.local.database.enitity.FavoriteSeriesEntity

class LocalDataSource(private val dao: MocaDao) {

    fun addMovieFavorite(it: FavoriteMovieEntity) = dao.addMovieFavorite(it)
    fun addSeriesFavorite(it: FavoriteSeriesEntity) = dao.addSeriesFavorite(it)

    fun removeMovieFavorite(it: FavoriteMovieEntity) = dao.removeMovieFavorite(it)
    fun removeSeriesFavorite(it: FavoriteSeriesEntity) = dao.removeSeriesFavorite(it)

    fun getSingleMovieFavorite(id: Int) = dao.getSingleMovieFavorite(id)
    fun getSingleSeriesFavorite(id: Int) = dao.getSingleSeriesFavorite(id)

    fun getMovieFavorites() = dao.getMovieFavorites()
    fun getSeriesFavorites() = dao.getSeriesFavorites()

}