package id.itborneo.core.domain.model.detail

data class MovieDetailDomainModel(
    val id: Int,
    val title: String,
    val genres: List<GenreDomainModel?>?,
    val voteCount: Int,
    val overview: String,
    val posterPath: String?,
    val voteAverage: Double
)




