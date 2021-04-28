package id.itborneo.core.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import id.itborneo.core.data.local.database.enitity.FavoriteMovieEntity
import id.itborneo.core.data.local.database.enitity.FavoriteSeriesEntity

@Database(
    entities = [FavoriteMovieEntity::class, FavoriteSeriesEntity::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun favoriteDao(): MocaDao


}