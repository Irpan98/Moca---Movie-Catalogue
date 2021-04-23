package id.itborneo.moca.core.domain.model.credits

import com.google.gson.annotations.SerializedName

data class CastModel(

    @SerializedName("id")
    var id: Int?,

    @SerializedName("name")
    var name: String?,

    @SerializedName("profile_path")
    var profilePath: String?
)