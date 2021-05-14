package id.itborneo.core.utils.extension

import id.itborneo.core.data.local.database.enitity.FavoriteMovieEntity
import id.itborneo.core.data.local.database.enitity.FavoriteSeriesEntity
import id.itborneo.core.data.remote.response.MovieModelResponse
import id.itborneo.core.data.remote.response.SeriesModelResponse
import id.itborneo.core.data.remote.response.credits.CastResponse
import id.itborneo.core.data.remote.response.credits.CreditsResponse
import id.itborneo.core.data.remote.response.detail.GenreResponse
import id.itborneo.core.data.remote.response.detail.MovieDetailResponse
import id.itborneo.core.data.remote.response.detail.SeriesDetailResponse
import id.itborneo.core.domain.model.MovieDomainModel
import id.itborneo.core.domain.model.SeriesDomainModel
import id.itborneo.core.domain.model.credits.CastDomainModel
import id.itborneo.core.domain.model.credits.CreditsDomainModel
import id.itborneo.core.domain.model.detail.GenreDomainModel
import id.itborneo.core.domain.model.detail.MovieDetailDomainModel
import id.itborneo.core.domain.model.detail.SeriesDetailDomainModel


fun List<MovieModelResponse?>.toListMovieModel() = map {
    MovieDomainModel(
        id = it?.id.toUnknownIntIfNull,
        title = it?.title.toUnknownStringIfNull,
        posterPath = it?.posterPath.toUnknownStringIfNull
    )
}

fun List<SeriesModelResponse>.toListSeriesModel() = map {
    SeriesDomainModel(
        id = it.id.toUnknownIntIfNull,
        name = it.name.toUnknownStringIfNull,
        posterPath = it.posterPath.toUnknownStringIfNull
    )
}


fun MovieDetailResponse.toDetailModel() =
    MovieDetailDomainModel(
        id = this.id,
        title = this.title.toUnknownStringIfNull,
        posterPath = this.posterPath.toUnknownStringIfNull,
        genres = this.genres.toListGenreResponse(),
        voteCount = this.voteCount.toUnknownIntIfNull,
        overview = this.overview.toUnknownStringIfNull,
        voteAverage = this.voteAverage.toUnknownIntIfNull
    )

fun SeriesDetailResponse.toDetailModel() =
    SeriesDetailDomainModel(
        id = this.id,
        name = this.name.toUnknownStringIfNull,
        posterPath = this.posterPath.toUnknownStringIfNull,
        genres = this.genres.toListGenreResponse(),
        voteCount = this.voteCount.toUnknownIntIfNull,
        overview = this.overview.toUnknownStringIfNull,
        voteAverage = this.voteAverage.toUnknownIntIfNull
    )

fun List<GenreResponse?>?.toListGenreResponse() = this?.map {
    GenreDomainModel(
        name = it?.name.toUnknownStringIfNull,
        id = it?.id.toUnknownIntIfNull
    )
}

fun CreditsResponse.toCreditsModel() = CreditsDomainModel(
    id = this.id.toUnknownIntIfNull,
    cast = this.cast.toListCast()
)

fun List<CastResponse>?.toListCast() = this?.map {
    CastDomainModel(
        id = it.id.toUnknownIntIfNull,
        name = it.name.toUnknownStringIfNull,
        profilePath = it.profilePath.toUnknownStringIfNull
    )
}

fun FavoriteMovieEntity.toFavoriteMovieModel() =
    MovieDomainModel(
        id = this.id,
        title = this.title,
        posterPath = this.posterPath
    )


fun FavoriteSeriesEntity.toFavoriteSeriesModel() =
    SeriesDomainModel(
        id = this.id,
        name = this.title,
        posterPath = this.posterPath
    )





