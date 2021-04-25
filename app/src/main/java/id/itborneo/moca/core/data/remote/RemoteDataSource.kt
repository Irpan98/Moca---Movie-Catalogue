package id.itborneo.moca.core.data.remote

import id.itborneo.moca.core.networks.ApiService
import id.itborneo.moca.core.utils.Resource
import id.itborneo.moca.core.utils.extension.toCreditsModel
import id.itborneo.moca.core.utils.extension.toDetailModel
import id.itborneo.moca.core.utils.extension.toListMovieModel
import id.itborneo.moca.core.utils.extension.toListSeriesModel
import id.itborneo.moca.core.utils.testing.EspressoIdlingResource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class RemoteDataSource(private val api: ApiService) {


    fun getMovies() = flow {
        emit(Resource.loading(data = null))
        EspressoIdlingResource.increment()
        try {
            val results = api.getMovies().results
            emit(Resource.success(data = results.toListMovieModel()))
            EspressoIdlingResource.decrement()

        } catch (exception: Exception) {
            emit(Resource.error(data = null, message = exception.message ?: "Error Occurred!"))
            EspressoIdlingResource.decrement()
        }
    }.flowOn(Dispatchers.IO)

    fun getSeries() = flow {
        emit(Resource.loading(data = null))
        EspressoIdlingResource.increment()

        try {
            emit(Resource.success(data = api.getSeries().results.toListSeriesModel()))
            EspressoIdlingResource.decrement()

        } catch (exception: Exception) {
            emit(Resource.error(data = null, message = exception.message ?: "Error Occurred!"))
            EspressoIdlingResource.decrement()
        }
    }.flowOn(Dispatchers.IO)

    fun getDetailMovie(id: Int) = flow {
        emit(Resource.loading(data = null))
        EspressoIdlingResource.increment()

        try {
            emit(Resource.success(data = api.getDetailMovie(id).toDetailModel()))
            EspressoIdlingResource.decrement()

        } catch (exception: Exception) {
            emit(Resource.error(data = null, message = exception.message ?: "Error Occurred!"))
            EspressoIdlingResource.decrement()
        }
    }.flowOn(Dispatchers.IO)

    fun getDetailSeries(id: Int) = flow {
        emit(Resource.loading(data = null))
        EspressoIdlingResource.increment()

        try {
            emit(Resource.success(data = api.getDetailSeries(id).toDetailModel()))
            EspressoIdlingResource.decrement()

        } catch (exception: Exception) {
            emit(Resource.error(data = null, message = exception.message ?: "Error Occurred!"))
            EspressoIdlingResource.decrement()
        }
    }.flowOn(Dispatchers.IO)

    fun getTrendingMovies() = flow {
        emit(Resource.loading(data = null))
        EspressoIdlingResource.increment()
        try {
            emit(Resource.success(data = api.getTrendingMovie().results.toListMovieModel()))
            EspressoIdlingResource.decrement()

        } catch (exception: Exception) {
            emit(Resource.error(data = null, message = exception.message ?: "Error Occurred!"))
            EspressoIdlingResource.decrement()
        }
    }.flowOn(Dispatchers.IO)

    fun getTrendingSeries() = flow {
        emit(Resource.loading(data = null))
        EspressoIdlingResource.increment()

        try {
            emit(Resource.success(data = api.getTrendingSeries().results.toListSeriesModel()))
            EspressoIdlingResource.decrement()

        } catch (exception: Exception) {
            emit(Resource.error(data = null, message = exception.message ?: "Error Occurred!"))
            EspressoIdlingResource.decrement()
        }
    }.flowOn(Dispatchers.IO)


    fun getNowPlayingMovies() = flow {
        emit(Resource.loading(data = null))
        EspressoIdlingResource.increment()

        try {
            emit(Resource.success(data = api.getPlayingNowMovies().results.toListMovieModel()))
            EspressoIdlingResource.decrement()

        } catch (exception: Exception) {
            emit(Resource.error(data = null, message = exception.message ?: "Error Occurred!"))
            EspressoIdlingResource.decrement()

        }
    }.flowOn(Dispatchers.IO)

    fun getAiringTodaySeries() = flow {
        emit(Resource.loading(data = null))
        EspressoIdlingResource.increment()

        try {
            emit(Resource.success(data = api.getAiringTodaySeries().results.toListSeriesModel()))
            EspressoIdlingResource.decrement()

        } catch (exception: Exception) {
            emit(Resource.error(data = null, message = exception.message ?: "Error Occurred!"))
            EspressoIdlingResource.decrement()
        }
    }.flowOn(Dispatchers.IO)

    fun getCredits(id: Int) = flow {
        emit(Resource.loading(data = null))
        EspressoIdlingResource.increment()

        try {
            emit(Resource.success(data = api.getCreditsMovie(id).toCreditsModel()))
            EspressoIdlingResource.decrement()

        } catch (exception: Exception) {
            emit(Resource.error(data = null, message = exception.message ?: "Error Occurred!"))
            EspressoIdlingResource.decrement()
        }
    }.flowOn(Dispatchers.IO)


    fun searchMovies(query: String) = flow {
        emit(Resource.loading(data = null))
        EspressoIdlingResource.increment()

        try {
            emit(Resource.success(data = api.searchMovies(query).results.toListMovieModel()))
            EspressoIdlingResource.decrement()

        } catch (exception: Exception) {
            emit(Resource.error(data = null, message = exception.message ?: "Error Occurred!"))
            EspressoIdlingResource.decrement()
        }
    }.flowOn(Dispatchers.IO)

    fun searchSeries(query: String) = flow {

        emit(Resource.loading(data = null))
        EspressoIdlingResource.increment()

        try {
            emit(Resource.success(data = api.searchSeries(query).results.toListSeriesModel()))
            EspressoIdlingResource.decrement()

        } catch (exception: Exception) {
            emit(Resource.error(data = null, message = exception.message ?: "Error Occurred!"))
            EspressoIdlingResource.decrement()
        }
    }.flowOn(Dispatchers.IO)
}


