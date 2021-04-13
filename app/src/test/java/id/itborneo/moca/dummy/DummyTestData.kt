package id.itborneo.moca.dummy

import androidx.lifecycle.MutableLiveData
import id.itborneo.moca.core.model.MovieModel
import id.itborneo.moca.core.model.SeriesModel
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


}