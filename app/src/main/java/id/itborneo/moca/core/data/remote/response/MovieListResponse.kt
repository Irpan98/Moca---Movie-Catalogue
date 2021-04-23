package id.itborneo.moca.core.data.remote.response

import com.google.gson.annotations.SerializedName

data class MovieListResponse(

    @field:SerializedName("page")
    val page: Int? = null,

    @field:SerializedName("total_pages")
    val totalPages: Int? = null,

    @field:SerializedName("results")
    val results: List<MovieModelResponse>,

    @field:SerializedName("total_results")
    val totalResults: Int? = null
)

