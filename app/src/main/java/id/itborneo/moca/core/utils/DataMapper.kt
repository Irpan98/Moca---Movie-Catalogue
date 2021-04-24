package id.itborneo.moca.core.utils

import id.itborneo.moca.core.data.local.database.enitity.FavoriteMovieEntity
import id.itborneo.moca.core.data.local.database.enitity.FavoriteSeriesEntity
import id.itborneo.moca.core.data.remote.response.MovieModelResponse
import id.itborneo.moca.core.domain.model.MovieModel
import id.itborneo.moca.core.domain.model.detail.MovieDetailModel
import id.itborneo.moca.core.domain.model.detail.SeriesDetailModel

object DataMapper {


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
            posterPath = item.posterPath ?: "\"N/A\""
        )
}
