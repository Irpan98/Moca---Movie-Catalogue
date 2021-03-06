package id.itborneo.core.data.remote.response

import com.google.gson.annotations.SerializedName

data class MovieModelResponse(

    @field:SerializedName("id")
    val id: Int,

    @field:SerializedName("title")
    val title: String,

    @field:SerializedName("poster_path")
    val posterPath: String

)
