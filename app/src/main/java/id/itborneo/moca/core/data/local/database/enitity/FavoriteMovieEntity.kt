package id.itborneo.moca.core.data.local.database.enitity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movie_favorite")
data class FavoriteMovieEntity(

    @PrimaryKey
    val id: Int,

    @ColumnInfo(name = "title")
    val title: String,

    @ColumnInfo(name = " poster_path")
    val posterPath: String
)