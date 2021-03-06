package id.itborneo.core.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class SeriesModel(

    var id: Int,
    var name: String? = null,
    var posterPath: String? = null

) : Parcelable