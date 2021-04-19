package id.itborneo.moca.core.source

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import id.itborneo.moca.core.local.MocaDao
import id.itborneo.moca.core.local.enitity.FavoriteMovieEntity
import id.itborneo.moca.core.local.enitity.FavoriteSeriesEntity

class LocalDataSource(private val dao: MocaDao) {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addMovieFavorite(it: FavoriteMovieEntity) = dao.addMovieFavorite(it)
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addSeriesFavorite(it: FavoriteSeriesEntity) = dao.addSeriesFavorite(it)


    @Delete
    fun removeMovieFavorite(it: FavoriteMovieEntity) = dao.removeMovieFavorite(it)
    @Delete
    fun removeSeriesFavorite(it: FavoriteSeriesEntity) = dao.removeSeriesFavorite(it)


    fun getSingleMovieFavorite(id: Int) = dao.getSingleMovieFavorite(id)
    fun getSingleSeriesFavorite(id: Int) = dao.getSingleSeriesFavorite(id)

}