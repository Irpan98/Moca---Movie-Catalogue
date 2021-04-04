package id.itborneo.moca.core.model.response

import com.google.gson.annotations.SerializedName
import id.itborneo.moca.core.model.SeriesModel

data class SeriesListResponse(

    @field:SerializedName("page")
    val page: Int? = null,

    @field:SerializedName("total_pages")
    val totalPages: Int? = null,

    @field:SerializedName("results")
    val results: List<SeriesModel>?,

    @field:SerializedName("total_results")
    val totalResults: Int? = null
)

