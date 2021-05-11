package id.itborneo.moca.dummy

import androidx.lifecycle.MutableLiveData
import id.itborneo.core.domain.model.MovieDomainModel
import id.itborneo.core.domain.model.SeriesDomainModel
import id.itborneo.core.domain.model.credits.CreditsDomainModel
import id.itborneo.core.domain.model.detail.MovieDetailDomainModel
import id.itborneo.core.domain.model.detail.SeriesDetailDomainModel
import id.itborneo.core.utils.Resource

object DummyTestData {

    fun getMovies(): MutableLiveData<Resource<List<MovieDomainModel>>> {
        val movies = MutableLiveData<Resource<List<MovieDomainModel>>>()
        movies.value = Resource.success(
            listOf(
                MovieDomainModel(
                    id = 1,
                    title = "testMovie",
                    posterPath = ""
                )
            )
        )
        return movies
    }

    fun getMoviesEmpty(): MutableLiveData<Resource<List<MovieDomainModel>>> {
        val movies = MutableLiveData<Resource<List<MovieDomainModel>>>()
        movies.value = Resource.success(
            listOf()
        )
        return movies
    }

    fun getMoviesError(): MutableLiveData<Resource<List<MovieDomainModel>>> {
        val movies = MutableLiveData<Resource<List<MovieDomainModel>>>()
        movies.value = Resource.error(null, "Error Load Data: No Internet")
        return movies
    }


    fun getDetailMovie(): MutableLiveData<Resource<MovieDetailDomainModel>> {
        val movies = MutableLiveData<Resource<MovieDetailDomainModel>>()
        movies.value = Resource.success(
            MovieDetailDomainModel(
                id = 1,
                title = "testMovie",
                voteAverage = 8.0,
                genres = null,
                voteCount = 199,
                overview = "good",
                posterPath = ""
            )
        )

        return movies
    }


    fun getDetailMoviesError(): MutableLiveData<Resource<MovieDetailDomainModel>> {
        val movie = MutableLiveData<Resource<MovieDetailDomainModel>>()
        movie.value = Resource.error(null, "Error Load Data: No Internet")
        return movie
    }

    fun getSeries(): MutableLiveData<Resource<List<SeriesDomainModel>>> {
        val series = MutableLiveData<Resource<List<SeriesDomainModel>>>()
        series.value = Resource.success(
            listOf(
                SeriesDomainModel(
                    name = "testSeries",
                    id = 1
                )
            )
        )

        return series
    }

    fun getSeriesEmpty(): MutableLiveData<Resource<List<SeriesDomainModel>>> {
        val series = MutableLiveData<Resource<List<SeriesDomainModel>>>()
        series.value = Resource.success(
            listOf()
        )
        return series
    }

    fun getSeriesError(): MutableLiveData<Resource<List<SeriesDomainModel>>> {
        val series = MutableLiveData<Resource<List<SeriesDomainModel>>>()
        series.value = Resource.error(null, "Error Load Data: No Internet")
        return series
    }

    fun getDetailSeries(): MutableLiveData<Resource<SeriesDetailDomainModel>> {
        val series = MutableLiveData<Resource<SeriesDetailDomainModel>>()
        series.value = Resource.success(
            SeriesDetailDomainModel(
                id = 1,
                name = "testMovie",
                voteAverage = 8.0,
            )
        )
        return series
    }


    fun getDetailSeriesError(): MutableLiveData<Resource<SeriesDetailDomainModel>> {
        val series = MutableLiveData<Resource<SeriesDetailDomainModel>>()
        series.value = Resource.error(null, "Error Load Data: No Internet")
        return series
    }

    fun getCredits(): MutableLiveData<Resource<CreditsDomainModel>> {
        val credits = MutableLiveData<Resource<CreditsDomainModel>>()
        credits.value = Resource.success(
            CreditsDomainModel(
                id = 1,
                cast = listOf()
            )
        )
        return credits
    }
}
