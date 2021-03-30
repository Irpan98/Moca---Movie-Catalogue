package id.itborneo.moca.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import id.itborneo.moca.core.model.response.MoviesResponse
import id.itborneo.moca.core.networks.ApiConfig
import id.itborneo.moca.core.utils.Resource
import kotlinx.coroutines.Dispatchers

class MovieViewModel() : ViewModel() {

    private val movies: LiveData<Resource<MoviesResponse>> = movies()

    private fun movies() = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = ApiConfig.apiService.getMovies()))
        } catch (exception: Exception) {
            emit(Resource.error(data = null, message = exception.message ?: "Error Occurred!"))
        }
    }

    fun getMovies() = movies


}