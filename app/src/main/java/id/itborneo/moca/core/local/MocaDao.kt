package id.itborneo.moca.core.local

import androidx.paging.DataSource
import androidx.room.*
import id.itborneo.moca.core.local.enitity.FavoriteMovieEntity
import id.itborneo.moca.core.local.enitity.FavoriteSeriesEntity

@Dao
interface MocaDao {


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addMovieFavorite(favoriteMovie: FavoriteMovieEntity) : Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addSeriesFavorite(favoriteSeries: FavoriteSeriesEntity): Long

    @Query("SELECT * FROM movie_favorite WHERE id=:id ")
    fun getSingleMovieFavorite(id: Int): FavoriteMovieEntity?

    @Query("SELECT * FROM Series_favorite WHERE id=:id ")
    fun getSingleSeriesFavorite(id: Int): FavoriteSeriesEntity?

    @Delete
    fun removeMovieFavorite(favoriteMovie: FavoriteMovieEntity): Int

    @Delete
    fun removeSeriesFavorite(favoriteSeries: FavoriteSeriesEntity) : Int

    @Query("SELECT * FROM movie_favorite")
    fun getMovieFavorites(): DataSource.Factory<Int, FavoriteMovieEntity>

    @Query("SELECT * FROM series_favorite")
    fun getSeriesFavorites(): DataSource.Factory<Int, FavoriteSeriesEntity>


}