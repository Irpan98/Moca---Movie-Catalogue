package id.itborneo.core.data.local.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
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

    companion object {
        private var INSTANCE: AppDatabase? = null

        private const val TABLE_NAME = "db_favorite"

        fun getInstance(context: Context): AppDatabase {
            if (INSTANCE == null) {
                synchronized(this) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        AppDatabase::class.java,
                        TABLE_NAME
                    ).build()
                }
            }
            return INSTANCE as AppDatabase
        }
    }
}