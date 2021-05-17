package id.itborneo.core.data.remote

import id.itborneo.core.networks.ApiService
import id.itborneo.core.utils.Resource
import id.itborneo.core.utils.extension.toCreditsModel
import id.itborneo.core.utils.extension.toDetailModel
import id.itborneo.core.utils.extension.toListMovieModel
import id.itborneo.core.utils.extension.toListSeriesModel
import id.itborneo.core.utils.testing.EspressoIdlingResource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class RemoteDataSource(private val api: ApiService) {

    private fun <T> saveCall(call: suspend () -> T) = flow {
        emit(Resource.loading(data = null))
        EspressoIdlingResource.increment()
        try {
            emit(Resource.success(data = call()))
            EspressoIdlingResource.decrement()

        } catch (exception: Exception) {
            emit(Resource.error(data = null, message = exception.message ?: "Error Occurred!"))
            EspressoIdlingResource.decrement()
        }
    }.flowOn(Dispatchers.IO)

    fun getMovies() = saveCall { api.getMovies().results.toListMovieModel() }

    fun getSeries() = saveCall { api.getSeries().results.toListSeriesModel() }

    fun getDetailMovie(id: Int) = saveCall { api.getDetailMovie(id).toDetailModel() }

    fun getDetailSeries(id: Int) = saveCall { api.getDetailSeries(id).toDetailModel() }

    fun getTrendingMovies() = saveCall { api.getTrendingMovie().results.toListMovieModel() }

    fun getTrendingSeries() = saveCall { api.getTrendingSeries().results.toListSeriesModel() }

    fun getNowPlayingMovies() = saveCall { api.getPlayingNowMovies().results.toListMovieModel() }

    fun getAiringTodaySeries() = saveCall { api.getAiringTodaySeries().results.toListSeriesModel() }

    fun getCredits(id: Int) = saveCall { api.getCreditsMovie(id).toCreditsModel() }

    fun searchMovies(query: String) =
        saveCall { api.searchMovies(query).results.toListMovieModel() }

    fun searchSeries(query: String) =
        saveCall { api.searchSeries(query).results.toListSeriesModel() }


}


