package id.itborneo.moca.core.source

import androidx.lifecycle.liveData
import id.itborneo.moca.core.networks.ApiConfig
import id.itborneo.moca.core.utils.Resource
import kotlinx.coroutines.Dispatchers

class RemoteDataSource {

    private val api = ApiConfig.apiService

    fun getDetailMovie(id: Int) =
        liveData(Dispatchers.IO) {
            emit(Resource.loading(data = null))
            try {
                emit(Resource.success(data = api.getDetailMovie(id)))
            } catch (exception: Exception) {
                emit(Resource.error(data = null, message = exception.message ?: "Error Occurred!"))
            }
        }

     fun getMovies() = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = api.getMovies()))
        } catch (exception: Exception) {
            emit(Resource.error(data = null, message = exception.message ?: "Error Occurred!"))
        }
    }

     fun getTrendingMovies() = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = api.getTrendingMovie()))
        } catch (exception: Exception) {
            emit(Resource.error(data = null, message = exception.message ?: "Error Occurred!"))
        }
    }

     fun getTrendingSeries() = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = api.getTrendingSeries()))
        } catch (exception: Exception) {
            emit(Resource.error(data = null, message = exception.message ?: "Error Occurred!"))
        }
    }


     fun getNowPlayingMovies() = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = api.getPlayingNowMovies()))
        } catch (exception: Exception) {
            emit(Resource.error(data = null, message = exception.message ?: "Error Occurred!"))
        }
    }

     fun getAiringTodaySeries() = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = api.getAiringTodaySeries()))
        } catch (exception: Exception) {
            emit(Resource.error(data = null, message = exception.message ?: "Error Occurred!"))
        }
    }
}


