package id.itborneo.moca.core.networks

import id.itborneo.moca.core.model.detail.MovieDetailModel
import id.itborneo.moca.core.model.response.MoviesResponse
import retrofit2.http.GET
import retrofit2.http.Path


interface ApiService {

    @GET("4/discover/movie/")
    suspend fun getMovies(): MoviesResponse

    @GET("3/movie/{id}")
    suspend fun getDetailMovie(
        @Path("id") id: Int
    ): MovieDetailModel

    @GET("3/trending/movie/day")
    suspend fun getTrendingMovie(): MoviesResponse

    @GET("3/trending/tv/day")
    suspend fun getTrendingSeries(): MoviesResponse
}

