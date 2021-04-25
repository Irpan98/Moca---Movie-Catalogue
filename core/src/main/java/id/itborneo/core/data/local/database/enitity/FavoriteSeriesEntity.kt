package id.itborneo.core.data.local.database.enitity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Series_favorite")
data class FavoriteSeriesEntity(

    @PrimaryKey
    val id: Int,

    @ColumnInfo(name = "title")
    val title: String,

    @ColumnInfo(name = " poster_path")
    val posterPath: String
)