package id.itborneo.moca.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import id.itborneo.moca.core.model.MovieModel
import id.itborneo.moca.core.model.detail.MovieDetailModel
import id.itborneo.moca.core.networks.ApiConfig
import id.itborneo.moca.core.utils.Resource
import kotlinx.coroutines.Dispatchers

class DetailViewModel(private val movie: MovieModel) : ViewModel() {

    private val repository = ApiConfig.apiService

    private lateinit var userDetail: LiveData<Resource<MovieDetailModel>>

    init {
        reqDetailMovie()
    }

    private fun reqDetailMovie() {
        userDetail = liveData(Dispatchers.IO) {
            emit(Resource.loading(data = null))
            try {
                emit(Resource.success(data = repository.getDetailMovie(movie.id ?: 0)))
            } catch (exception: Exception) {
                emit(Resource.error(data = null, message = exception.message ?: "Error Occurred!"))
            }
        }
    }

    fun getDetailMovie() = userDetail

}
