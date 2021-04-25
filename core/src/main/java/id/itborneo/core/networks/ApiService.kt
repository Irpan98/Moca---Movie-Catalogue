package id.itborneo.core.networks

import id.itborneo.core.data.remote.response.MovieListResponse
import id.itborneo.core.data.remote.response.SeriesListResponse
import id.itborneo.core.data.remote.response.credits.CreditsResponse
import id.itborneo.core.data.remote.response.detail.MovieDetailResponse
import id.itborneo.core.data.remote.response.detail.SeriesDetailResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface ApiService {

    @GET("4/discover/movie/")
    suspend fun getMovies(): MovieListResponse

    @GET("4/discover/tv/")
    suspend fun getSeries(): SeriesListResponse

    @GET("3/movie/{id}")
    suspend fun getDetailMovie(
        @Path("id") id: Int
    ): MovieDetailResponse

    @GET("3/tv/{id}")
    suspend fun getDetailSeries(
        @Path("id") id: Int
    ): SeriesDetailResponse

    @GET("3/trending/movie/day")
    suspend fun getTrendingMovie(): MovieListResponse

    @GET("3/trending/tv/day")
    suspend fun getTrendingSeries(): SeriesListResponse

    @GET("3/movie/now_playing")
    suspend fun getPlayingNowMovies(): MovieListResponse

    @GET("3/tv/airing_today")
    suspend fun getAiringTodaySeries(): SeriesListResponse

    @GET("3/movie/{id}/credits")
    suspend fun getCreditsMovie(
        @Path("id") id: Int
    ): CreditsResponse


    @GET("3/search/movie")
    suspend fun searchMovies(
        @Query("query") query: String
    ): MovieListResponse

    @GET("3/search/tv")
    suspend fun searchSeries(
        @Query("query") query: String
    ): SeriesListResponse
}

