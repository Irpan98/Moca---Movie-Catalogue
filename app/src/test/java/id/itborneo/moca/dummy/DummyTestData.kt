package id.itborneo.moca.dummy

import androidx.lifecycle.MutableLiveData
import id.itborneo.moca.core.model.MovieModel
import id.itborneo.moca.core.model.SeriesModel
import id.itborneo.moca.core.model.detail.MovieDetailModel
import id.itborneo.moca.core.model.detail.SeriesDetailModel
import id.itborneo.moca.core.model.response.MovieListResponse
import id.itborneo.moca.core.model.response.SeriesListResponse
import id.itborneo.moca.core.utils.Resource

object DummyTestData {

    fun getMovies(): MutableLiveData<Resource<MovieListResponse>> {
        val movies = MutableLiveData<Resource<MovieListResponse>>()
        movies.value = Resource.success(
            MovieListResponse(
                results = listOf(
                    MovieModel(
                        title = "testMovie"
                    )
                )
            )
        )

        return movies
    }

    fun getMoviesEmpty(): MutableLiveData<Resource<MovieListResponse>> {
        val movies = MutableLiveData<Resource<MovieListResponse>>()
        movies.value = Resource.success(
            MovieListResponse(results = listOf())
        )
        return movies
    }

    fun getMoviesError(): MutableLiveData<Resource<MovieListResponse>> {
        val movies = MutableLiveData<Resource<MovieListResponse>>()
        movies.value = Resource.error(null, "Error Load Data: No Internet")
        return movies
    }


    fun getDetailMovie(): MutableLiveData<Resource<MovieDetailModel>> {
        val movies = MutableLiveData<Resource<MovieDetailModel>>()
        movies.value = Resource.success(
            MovieDetailModel(
                title = "testMovie",
                voteAverage = 8.0,
            )
        )


        return movies
    }


    fun getDetailMoviesError(): MutableLiveData<Resource<MovieDetailModel>> {
        val movie = MutableLiveData<Resource<MovieDetailModel>>()
        movie.value = Resource.error(null, "Error Load Data: No Internet")
        return movie
    }

    fun getSeries(): MutableLiveData<Resource<SeriesListResponse>> {
        val series = MutableLiveData<Resource<SeriesListResponse>>()
        series.value = Resource.success(
            SeriesListResponse(
                results = listOf(
                    SeriesModel(
                        name = "testSeries"
                    )
                )
            )
        )

        return series
    }

    fun getSeriesEmpty(): MutableLiveData<Resource<SeriesListResponse>> {
        val series = MutableLiveData<Resource<SeriesListResponse>>()
        series.value = Resource.success(
            SeriesListResponse(results = listOf())
        )
        return series
    }

    fun getSeriesError(): MutableLiveData<Resource<SeriesListResponse>> {
        val series = MutableLiveData<Resource<SeriesListResponse>>()
        series.value = Resource.error(null, "Error Load Data: No Internet")
        return series
    }

    fun getDetailSeries(): MutableLiveData<Resource<SeriesDetailModel>> {
        val series = MutableLiveData<Resource<SeriesDetailModel>>()
        series.value = Resource.success(
            SeriesDetailModel(
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


}