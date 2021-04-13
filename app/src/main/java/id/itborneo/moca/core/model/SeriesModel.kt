package id.itborneo.moca.core.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class SeriesModel(
    @SerializedName("backdrop_path") 
    var backdropPath: String? = null,
    @SerializedName("first_air_date")
    var firstAirDate: String? = null,
    @SerializedName("genre_ids")
    var genreIds: List<Int>? = null,
    @SerializedName("id")
    var id: Int? = null,
    @SerializedName("name")
    var name: String?= null,
    @SerializedName("origin_country")
    var originCountry: List<String>?= null,
    @SerializedName("original_language")
    var originalLanguage: String?= null,
    @SerializedName("original_name")
    var originalName: String?= null,
    @SerializedName("overview")
    var overview: String?= null,
    @SerializedName("popularity")
    var popularity: Double?= null,
    @SerializedName("poster_path")
    var posterPath: String?= null,
    @SerializedName("vote_average")
    var voteAverage: Double?= null,
    @SerializedName("vote_count")
    var voteCount: Int?= null
) : Parcelable