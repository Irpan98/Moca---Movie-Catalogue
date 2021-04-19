package id.itborneo.moca.core.local.enitity

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
    val posterPath: String? = null
)