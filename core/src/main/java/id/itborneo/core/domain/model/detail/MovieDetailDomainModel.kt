package id.itborneo.core.domain.model.detail

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MovieDetailDomainModel(
    val id: Int,
    val title: String,
    val genres: List<GenreDomainModel?>?,
    val voteCount: Int,
    val overview: String,
    val posterPath: String?,
    val voteAverage: Double
) : Parcelable




