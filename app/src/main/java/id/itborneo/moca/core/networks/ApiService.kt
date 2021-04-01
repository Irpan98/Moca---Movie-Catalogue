package id.itborneo.moca.core.networks

import id.itborneo.moca.core.model.response.MoviesResponse
import retrofit2.http.GET


interface ApiService {

    @GET("4/discover/movie/")
    suspend fun getMovies(): MoviesResponse

//    https://api.themoviedb.org/

    @GET("3/trending/movie/day")
    suspend fun getTrendingMovie(): MoviesResponse

    @GET("3/trending/tv/day")
    suspend fun getTrendingSeries(): MoviesResponse
}

