package id.itborneo.core.utils

import id.itborneo.core.data.local.database.enitity.FavoriteMovieEntity
import id.itborneo.core.data.local.database.enitity.FavoriteSeriesEntity
import id.itborneo.core.data.remote.response.MovieModelResponse
import id.itborneo.core.domain.model.MovieModel
import id.itborneo.core.domain.model.detail.MovieDetailModel
import id.itborneo.core.domain.model.detail.SeriesDetailModel

object DataMapper {


    fun detailMovieToFavorite(item: MovieDetailModel) =
        FavoriteMovieEntity(
            title = item.title,
            id = item.id,
            posterPath = item.posterPath ?: "\"N/A\""
        )

    fun detailSeriesToFavorite(item: SeriesDetailModel) =
        FavoriteSeriesEntity(
            title = item.name ?: "N/A",
            id = item.id,
            posterPath = item.posterPath ?: "\"N/A\""
        )
}

