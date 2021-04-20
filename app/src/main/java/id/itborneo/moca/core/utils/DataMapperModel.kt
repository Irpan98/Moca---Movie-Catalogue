package id.itborneo.moca.core.utils

import id.itborneo.moca.core.local.enitity.FavoriteMovieEntity
import id.itborneo.moca.core.local.enitity.FavoriteSeriesEntity
import id.itborneo.moca.core.model.detail.MovieDetailModel
import id.itborneo.moca.core.model.detail.SeriesDetailModel

object DataMapperModel {

    fun detailMovieToFavorite(item: MovieDetailModel) =
        FavoriteMovieEntity(
            title = item.title ?: "N/A",
            id = item.id,
            posterPath = item.posterPath ?: "\"N/A\""
        )

    fun detailSeriesToFavorite(item: SeriesDetailModel) =
        FavoriteSeriesEntity(
            title = item.name ?: "N/A",
            id = item.id,
            posterPath = item.posterPath?:"\"N/A\""
        )
}