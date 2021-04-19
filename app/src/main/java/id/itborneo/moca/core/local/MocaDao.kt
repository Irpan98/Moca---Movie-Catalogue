package id.itborneo.moca.core.local

import androidx.room.*
import id.itborneo.moca.core.local.enitity.FavoriteMovieEntity

@Dao
interface MocaDao {

//    @Query("SELECT * FROM favorite")
//    fun getFavorites(): LiveData<List<FavoriteMovieEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addMovieFavorite(favoriteMovie: FavoriteMovieEntity)

    @Query("SELECT * FROM movie_favorite WHERE id=:id ")
    fun getSingleFavorite(id: Int): FavoriteMovieEntity?

    @Delete
    fun removeMovieFavorite(favoriteMovie: FavoriteMovieEntity)
//
//    @Query("SELECT * FROM favorite")
//    fun contentProviderGetFavorites(): Cursor
//
//    @Query("SELECT * FROM favorite")
//    fun getFavoritesWidget(): List<FavoriteMovieEntity>
}