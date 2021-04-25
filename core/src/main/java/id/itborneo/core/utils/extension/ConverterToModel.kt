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
import id.itborneo.core.domain.model.MovieModel
import id.itborneo.core.domain.model.SeriesModel
import id.itborneo.core.domain.model.credits.CastModel
import id.itborneo.core.domain.model.credits.CreditsModel
import id.itborneo.core.domain.model.detail.GenreModel
import id.itborneo.core.domain.model.detail.MovieDetailModel
import id.itborneo.core.domain.model.detail.SeriesDetailModel


fun List<MovieModelResponse>.toListMovieModel() = map {
    MovieModel(
        id = it.id,
        title = it.title,
        posterPath = it.posterPath
    )
}

fun List<SeriesModelResponse>.toListSeriesModel() = map {
    SeriesModel(
        id = it.id.toUnknownIntIfNull,
        name = it.name,
        posterPath = it.posterPath
    )
}


fun MovieDetailResponse.toDetailModel() =
    MovieDetailModel(
        id = this.id,
        title = this.title.toUnknownStringIfNull,
        posterPath = this.posterPath.toUnknownStringIfNull,
        genres = this.genres.toListGenreResponse(),
        voteCount = this.voteCount.toUnknownIntIfNull,
        overview = this.overview.toUnknownStringIfNull,
        voteAverage = this.voteAverage.toUnknownIntIfNull
    )

fun SeriesDetailResponse.toDetailModel() =
    SeriesDetailModel(
        id = this.id,
        name = this.name.toUnknownStringIfNull,
        posterPath = this.posterPath.toUnknownStringIfNull,
        genres = this.genres.toListGenreResponse(),
        voteCount = this.voteCount.toUnknownIntIfNull,
        overview = this.overview.toUnknownStringIfNull,
        voteAverage = this.voteAverage.toUnknownIntIfNull
    )

fun List<GenreResponse?>?.toListGenreResponse() = this?.map {
    GenreModel(
        name = it?.name.toUnknownStringIfNull,
        id = it?.id.toUnknownIntIfNull
    )
}

fun CreditsResponse.toCreditsModel() = CreditsModel(
    id = this.id.toUnknownIntIfNull,
    cast = this.cast.toListCast()
)

fun List<CastResponse>?.toListCast() = this?.map {
    CastModel(
        id = it.id.toUnknownIntIfNull,
        name = it.name.toUnknownStringIfNull,
        profilePath = it.profilePath.toUnknownStringIfNull
    )
}

fun FavoriteMovieEntity.toFavoriteMovieModel() =
    MovieModel(
        id = this.id,
        title = this.title,
        posterPath = this.posterPath
    )


fun FavoriteSeriesEntity.toFavoriteSeriesModel() =
    SeriesModel(
        id = this.id,
        name = this.title,
        posterPath = this.posterPath
    )





