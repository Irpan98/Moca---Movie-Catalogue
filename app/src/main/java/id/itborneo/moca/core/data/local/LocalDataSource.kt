package id.itborneo.moca.core.data.local

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import id.itborneo.moca.core.data.local.database.MocaDao
import id.itborneo.moca.core.data.local.database.enitity.FavoriteMovieEntity
import id.itborneo.moca.core.data.local.database.enitity.FavoriteSeriesEntity

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

    fun getMovieFavorites() = dao.getMovieFavorites()
    fun getSeriesFavorites() = dao.getSeriesFavorites()

}