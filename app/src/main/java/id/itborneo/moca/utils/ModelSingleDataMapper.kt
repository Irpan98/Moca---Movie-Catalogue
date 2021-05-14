package id.itborneo.moca.utils

import id.itborneo.core.domain.model.MovieDomainModel
import id.itborneo.core.domain.model.SeriesDomainModel
import id.itborneo.core.domain.model.detail.GenreDomainModel
import id.itborneo.core.domain.model.detail.MovieDetailDomainModel
import id.itborneo.core.domain.model.detail.SeriesDetailDomainModel
import id.itborneo.core.utils.Resource
import id.itborneo.moca.model.MovieModel
import id.itborneo.moca.model.SeriesModel
import id.itborneo.moca.model.detail.GenreModel
import id.itborneo.moca.model.detail.MovieDetailModel
import id.itborneo.moca.model.detail.SeriesDetailModel

object ModelSingleDataMapper {

    fun movieDetailFromDomain(item: Resource<MovieDetailDomainModel>) =
        Resource(
            item.status,
            item.data?.let { movieDetailFromDomain(it) },
            item.message
        )

    fun movieDetailFromDomain(item: MovieDetailDomainModel) =
        MovieDetailModel(
            item.id,
            item.title,
            genreFromDomain(item.genres),
            item.voteCount,
            item.overview,
            item.posterPath,
            item.voteAverage
        )

    fun genreFromDomain(item: List<GenreDomainModel?>?) =
        item?.map {
            GenreModel(
                it?.id ?: 0,
                it?.name ?: ""
            )
        }


    fun movieDetailToDomain(item: MovieDetailModel) =
        MovieDetailDomainModel(
            item.id,
            item.title,
            genreToDomain(item.genres),
            item.voteCount,
            item.overview,
            item.posterPath,
            item.voteAverage
        )

    fun genreToDomain(item: List<GenreModel?>?) =
        item?.map {
            GenreDomainModel(
                it?.id ?: 0,
                it?.name ?: ""
            )
        }


    fun movieFromDomain(it: MovieDomainModel?) =
        if (it == null) {
            null
        } else {
            MovieModel(
                it.id,
                it.title,
                it.posterPath
            )
        }

    fun seriesFromDomain(it: SeriesDomainModel?) =
        if (it == null) {
            null
        } else {
            SeriesModel(
                it.id,
                it.name,
                it.posterPath
            )
        }

    fun seriesDetailFromDomain(item: SeriesDetailDomainModel) =
        SeriesDetailModel(
            item.id,
            genreFromDomain(item.genres),
            item.voteCount,
            item.overview,
            item.posterPath,
            item.voteAverage,
            item.name,
        )

    fun seriesDetailFromDomain(item: Resource<SeriesDetailDomainModel>) =
        Resource(
            item.status,
            item.data?.let { seriesDetailFromDomain(it) },
            item.message
        )

    fun seriesDetailToDomain(item: SeriesDetailModel) =
        SeriesDetailDomainModel(
            item.id,
            genreToDomain(item.genres),
            item.voteCount,
            item.overview,
            item.posterPath,
            item.voteAverage,
            item.name,
        )
}