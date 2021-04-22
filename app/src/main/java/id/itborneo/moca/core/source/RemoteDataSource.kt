package id.itborneo.moca.core.source

import android.util.Log
import id.itborneo.moca.core.networks.ApiConfig
import id.itborneo.moca.core.utils.Resource
import id.itborneo.moca.core.utils.testing.EspressoIdlingResource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class RemoteDataSource {

    private val api = ApiConfig.apiService


    fun getMovies() = flow {

        emit(Resource.loading(data = null))
        EspressoIdlingResource.increment()

        try {
            emit(Resource.success(data = api.getMovies()))
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
            emit(Resource.success(data = api.getSeries()))
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
            emit(Resource.success(data = api.getDetailMovie(id)))
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
            emit(Resource.success(data = api.getDetailSeries(id)))
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
            emit(Resource.success(data = api.getTrendingMovie()))
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
            emit(Resource.success(data = api.getTrendingSeries()))
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
            emit(Resource.success(data = api.getPlayingNowMovies()))
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
            emit(Resource.success(data = api.getAiringTodaySeries()))
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
            emit(Resource.success(data = api.getCreditsMovie(id)))
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
            emit(Resource.success(data = api.searchMovies(query)))
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
            emit(Resource.success(data = api.searchSeries(query)))
            EspressoIdlingResource.decrement()

        } catch (exception: Exception) {
            emit(Resource.error(data = null, message = exception.message ?: "Error Occurred!"))
            EspressoIdlingResource.decrement()
        }
    }.flowOn(Dispatchers.IO)
}


