package id.itborneo.moca.core.model.credits

import com.google.gson.annotations.SerializedName

data class CreditsModel(
    @SerializedName("cast")
    var cast: List<CastModel>?,

    @SerializedName("id")
    var id: Int?
)