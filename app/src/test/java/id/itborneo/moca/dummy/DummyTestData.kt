package id.itborneo.moca.dummy

import androidx.lifecycle.MutableLiveData
import id.itborneo.core.domain.model.MovieModel
import id.itborneo.core.domain.model.SeriesModel
import id.itborneo.core.domain.model.credits.CreditsModel
import id.itborneo.core.domain.model.detail.MovieDetailModel
import id.itborneo.core.domain.model.detail.SeriesDetailModel
import id.itborneo.core.utils.Resource

object DummyTestData {

    fun getMovies(): MutableLiveData<Resource<List<MovieModel>>> {
        val movies = MutableLiveData<Resource<List<MovieModel>>>()
        movies.value = Resource.success(
            listOf(
                MovieModel(
                    id = 1,
                    title = "testMovie",
                    posterPath = ""
                )
            )
        )
        return movies
    }

    fun getMoviesEmpty(): MutableLiveData<Resource<List<MovieModel>>> {
        val movies = MutableLiveData<Resource<List<MovieModel>>>()
        movies.value = Resource.success(
            listOf()
        )
        return movies
    }

    fun getMoviesError(): MutableLiveData<Resource<List<MovieModel>>> {
        val movies = MutableLiveData<Resource<List<MovieModel>>>()
        movies.value = Resource.error(null, "Error Load Data: No Internet")
        return movies
    }


    fun getDetailMovie(): MutableLiveData<Resource<MovieDetailModel>> {
        val movies = MutableLiveData<Resource<MovieDetailModel>>()
        movies.value = Resource.success(
            MovieDetailModel(
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


    fun getDetailMoviesError(): MutableLiveData<Resource<MovieDetailModel>> {
        val movie = MutableLiveData<Resource<MovieDetailModel>>()
        movie.value = Resource.error(null, "Error Load Data: No Internet")
        return movie
    }

    fun getSeries(): MutableLiveData<Resource<List<SeriesModel>>> {
        val series = MutableLiveData<Resource<List<SeriesModel>>>()
        series.value = Resource.success(
            listOf(
                SeriesModel(
                    name = "testSeries",
                    id = 1
                )
            )
        )

        return series
    }

    fun getSeriesEmpty(): MutableLiveData<Resource<List<SeriesModel>>> {
        val series = MutableLiveData<Resource<List<SeriesModel>>>()
        series.value = Resource.success(
            listOf()
        )
        return series
    }

    fun getSeriesError(): MutableLiveData<Resource<List<SeriesModel>>> {
        val series = MutableLiveData<Resource<List<SeriesModel>>>()
        series.value = Resource.error(null, "Error Load Data: No Internet")
        return series
    }

    fun getDetailSeries(): MutableLiveData<Resource<SeriesDetailModel>> {
        val series = MutableLiveData<Resource<SeriesDetailModel>>()
        series.value = Resource.success(
            SeriesDetailModel(
                id = 1,
                name = "testMovie",
                voteAverage = 8.0,
            )
        )
        return series
    }


    fun getDetailSeriesError(): MutableLiveData<Resource<SeriesDetailModel>> {
        val series = MutableLiveData<Resource<SeriesDetailModel>>()
        series.value = Resource.error(null, "Error Load Data: No Internet")
        return series
    }

    fun getCredits(): MutableLiveData<Resource<CreditsModel>> {
        val credits = MutableLiveData<Resource<CreditsModel>>()
        credits.value = Resource.success(
            CreditsModel(
                id = 1,
                cast = listOf()
            )
        )
        return credits
    }
}
