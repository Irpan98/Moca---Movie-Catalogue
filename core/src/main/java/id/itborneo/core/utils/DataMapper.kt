package id.itborneo.core.utils

import id.itborneo.core.data.local.database.enitity.FavoriteMovieEntity
import id.itborneo.core.data.local.database.enitity.FavoriteSeriesEntity
import id.itborneo.core.domain.model.detail.MovieDetailDomainModel
import id.itborneo.core.domain.model.detail.SeriesDetailDomainModel

object DataMapper {

    fun detailMovieToFavorite(item: MovieDetailDomainModel) =
        FavoriteMovieEntity(
            title = item.title,
            id = item.id,
            posterPath = item.posterPath ?: "\"N/A\""
        )

    fun detailSeriesToFavorite(item: SeriesDetailDomainModel) =
        FavoriteSeriesEntity(
            title = item.name ?: "N/A",
            id = item.id,
            posterPath = item.posterPath ?: "\"N/A\""
        )
}

