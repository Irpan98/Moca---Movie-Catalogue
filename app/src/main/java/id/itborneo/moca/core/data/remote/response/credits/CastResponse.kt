package id.itborneo.moca.core.data.remote.response.credits

import com.google.gson.annotations.SerializedName

data class CastResponse(

    @SerializedName("id")
    var id: Int?,

    @SerializedName("name")
    var name: String?,

    @SerializedName("profile_path")
    var profilePath: String?
)