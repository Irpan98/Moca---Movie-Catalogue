package id.itborneo.moca.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import id.itborneo.moca.core.model.response.MoviesResponse
import id.itborneo.moca.core.networks.ApiConfig
import id.itborneo.moca.core.utils.Resource
import kotlinx.coroutines.Dispatchers

class HomeViewModel : ViewModel() {

    private val trendingMovies: LiveData<Resource<MoviesResponse>> = reqTrendingMovies()
    private val trendingSeries: LiveData<Resource<MoviesResponse>> = reqTrendingSeries()

    private fun reqTrendingMovies() = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = ApiConfig.apiService.getTrendingMovie()))
        } catch (exception: Exception) {
            emit(Resource.error(data = null, message = exception.message ?: "Error Occurred!"))
        }
    }

    private fun reqTrendingSeries() = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = ApiConfig.apiService.getTrendingSeries()))
        } catch (exception: Exception) {
            emit(Resource.error(data = null, message = exception.message ?: "Error Occurred!"))
        }
    }


    fun getTrendingSeries() = trendingSeries
    fun getTrendingMovies() = trendingMovies


}