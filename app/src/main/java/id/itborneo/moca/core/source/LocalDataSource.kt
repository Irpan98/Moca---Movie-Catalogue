package id.itborneo.moca.core.source

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import id.itborneo.moca.core.local.MocaDao
import id.itborneo.moca.core.local.enitity.FavoriteMovieEntity

class LocalDataSource(private val dao: MocaDao) {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addMovieFavorite(it: FavoriteMovieEntity) = dao.addMovieFavorite(it)

    @Delete
    fun removeMovieFavorite(it: FavoriteMovieEntity) = dao.removeMovieFavorite(it)

    fun getSingleMovieFavorite(id: Int) = dao.getSingleFavorite(id)

}