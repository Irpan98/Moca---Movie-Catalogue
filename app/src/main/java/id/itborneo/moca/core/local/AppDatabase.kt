package id.itborneo.moca.core.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import id.itborneo.moca.core.local.enitity.FavoriteMovieEntity

@Database(
    entities = [FavoriteMovieEntity::class],
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