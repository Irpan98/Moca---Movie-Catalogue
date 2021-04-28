package id.itborneo.core.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MovieModel(
    val id: Int,
    val title: String,
    val posterPath: String

) : Parcelable
