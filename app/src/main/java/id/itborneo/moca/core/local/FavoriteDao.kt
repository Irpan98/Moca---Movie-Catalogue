package id.itborneo.moca.core.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import id.itborneo.moca.core.local.entity.MovieEntity

@Dao
interface FavoriteDao {

//    @Query("SELECT * FROM favorite")
//    fun getMovieFavorites(): LiveData<List<FavoriteModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addMovieFavorite(favorite: MovieEntity)

//    @Query("SELECT * FROM favorite WHERE id=:id ")
//    fun getSingleFavorite(id: Int): FavoriteModel

//    @Delete
//    fun removeFavorite(favorite: FavoriteModel)

}