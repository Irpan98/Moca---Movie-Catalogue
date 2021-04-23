package id.itborneo.moca.core.domain.model

import com.google.gson.annotations.SerializedName

data class HomeItemModel(
    @field:SerializedName("id")
    val id: Int? = null,
    @field:SerializedName("poster_path")
    val posterPath: String? = null
)