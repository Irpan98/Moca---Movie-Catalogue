package id.itborneo.moca.model.detail

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MovieDetailModel(
    val id: Int,
    val title: String,
    val genres: List<GenreModel?>?,
    val voteCount: Int,
    val overview: String,
    val posterPath: String?,
    val voteAverage: Double
) : Parcelable




