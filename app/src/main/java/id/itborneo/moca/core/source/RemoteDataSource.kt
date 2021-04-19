package id.itborneo.moca.core.source

import androidx.lifecycle.liveData
import id.itborneo.moca.core.networks.ApiConfig
import id.itborneo.moca.core.utils.Resource
import id.itborneo.moca.core.utils.testing.EspressoIdlingResource
import kotlinx.coroutines.Dispatchers

class RemoteDataSource {

    private val api = ApiConfig.apiService


    fun getMovies() = liveData(Dispatchers.IO) {

        emit(Resource.loading(data = null))
        EspressoIdlingResource.increment()

        try {
            emit(Resource.success(data = api.getMovies()))
            EspressoIdlingResource.decrement()

        } catch (exception: Exception) {
            emit(Resource.error(data = null, message = exception.message ?: "Error Occurred!"))
            EspressoIdlingResource.decrement()
        }
    }

    fun getSeries() = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        EspressoIdlingResource.increment()

        try {
            emit(Resource.success(data = api.getSeries()))
            EspressoIdlingResource.decrement()

        } catch (exception: Exception) {
            emit(Resource.error(data = null, message = exception.message ?: "Error Occurred!"))
            EspressoIdlingResource.decrement()
        }
    }

    fun getDetailMovie(id: Int) =
        liveData(Dispatchers.IO) {
            emit(Resource.loading(data = null))
            EspressoIdlingResource.increment()

            try {
                emit(Resource.success(data = api.getDetailMovie(id)))
                EspressoIdlingResource.decrement()

            } catch (exception: Exception) {
                emit(Resource.error(data = null, message = exception.message ?: "Error Occurred!"))
                EspressoIdlingResource.decrement()
            }
        }

    fun getDetailSeries(id: Int) = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        EspressoIdlingResource.increment()

        try {
            emit(Resource.success(data = api.getDetailSeries(id)))
            EspressoIdlingResource.decrement()

        } catch (exception: Exception) {
            emit(Resource.error(data = null, message = exception.message ?: "Error Occurred!"))
            EspressoIdlingResource.decrement()
        }
    }

    fun getTrendingMovies() = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        EspressoIdlingResource.increment()
        try {
            emit(Resource.success(data = api.getTrendingMovie()))
            EspressoIdlingResource.decrement()

        } catch (exception: Exception) {
            emit(Resource.error(data = null, message = exception.message ?: "Error Occurred!"))
            EspressoIdlingResource.decrement()
        }
    }

    fun getTrendingSeries() = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        EspressoIdlingResource.increment()

        try {
            emit(Resource.success(data = api.getTrendingSeries()))
            EspressoIdlingResource.decrement()

        } catch (exception: Exception) {
            emit(Resource.error(data = null, message = exception.message ?: "Error Occurred!"))
            EspressoIdlingResource.decrement()
        }
    }


    fun getNowPlayingMovies() = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        EspressoIdlingResource.increment()

        try {
            emit(Resource.success(data = api.getPlayingNowMovies()))
            EspressoIdlingResource.decrement()

        } catch (exception: Exception) {
            emit(Resource.error(data = null, message = exception.message ?: "Error Occurred!"))
            EspressoIdlingResource.decrement()

        }
    }

    fun getAiringTodaySeries() = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        EspressoIdlingResource.increment()

        try {
            emit(Resource.success(data = api.getAiringTodaySeries()))
            EspressoIdlingResource.decrement()

        } catch (exception: Exception) {
            emit(Resource.error(data = null, message = exception.message ?: "Error Occurred!"))
            EspressoIdlingResource.decrement()
        }
    }

    fun getCreditsMovie(id: Int) = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        EspressoIdlingResource.increment()

        try {
            emit(Resource.success(data = api.getCreditsMovie(id)))
            EspressoIdlingResource.decrement()

        } catch (exception: Exception) {
            emit(Resource.error(data = null, message = exception.message ?: "Error Occurred!"))
            EspressoIdlingResource.decrement()
        }
    }
}


