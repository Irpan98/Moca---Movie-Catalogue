package id.itborneo.moca.utils

import id.itborneo.core.domain.model.MovieDomainModel
import id.itborneo.core.domain.model.SeriesDomainModel
import id.itborneo.core.domain.model.credits.CreditsDomainModel
import id.itborneo.core.utils.Resource
import id.itborneo.moca.model.MovieModel
import id.itborneo.moca.model.SeriesModel
import id.itborneo.moca.model.credits.CastModel
import id.itborneo.moca.model.credits.CreditsModel

object ModelDataMapper {

    fun movieListFromDomain(item: Resource<List<MovieDomainModel>>) =
        Resource(
            item.status,
            item.data?.map
            {
                MovieModel(
                    it.id,
                    it.title,
                    it.posterPath
                )
            },
            item.message
        )

    fun seriesListFromDomain(item: Resource<List<SeriesDomainModel>>) =
        Resource(
            item.status,
            item.data?.map
            {
                SeriesModel(
                    it.id,
                    it.name,
                    it.posterPath
                )
            },
            item.message
        )

    fun creditListFromDomain(item: Resource<CreditsDomainModel>) =
        Resource(
            item.status,
            CreditsModel(
                item.data?.id ?: 0,
                item.data?.cast?.map {
                    CastModel(
                        it.id,
                        it.name,
                        it.profilePath
                    )
                },
            ),
            item.message
        )


}
