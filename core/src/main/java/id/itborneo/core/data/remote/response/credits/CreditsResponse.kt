package id.itborneo.core.data.remote.response.credits

import com.google.gson.annotations.SerializedName

data class CreditsResponse(
    @SerializedName("cast")
    var cast: List<CastResponse>?,

    @SerializedName("id")
    var id: Int?
)