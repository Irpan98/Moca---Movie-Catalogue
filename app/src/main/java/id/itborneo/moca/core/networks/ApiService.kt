package id.itborneo.moca.core.networks

import id.itborneo.moca.core.model.credits.CreditsModel
import id.itborneo.moca.core.model.detail.MovieDetailModel
import id.itborneo.moca.core.model.detail.SeriesDetailModel
import id.itborneo.moca.core.model.response.MovieListResponse
import id.itborneo.moca.core.model.response.SeriesListResponse
import retrofit2.http.GET
import retrofit2.http.Path


interface ApiService {

    @GET("4/discover/movie/")
    suspend fun getMovies(): MovieListResponse

    @GET("4/discover/tv/")
    suspend fun getSeries(): SeriesListResponse

    @GET("3/movie/{id}")
    suspend fun getDetailMovie(
        @Path("id") id: Int
    ): MovieDetailModel

    @GET("3/tv/{id}")
    suspend fun getDetailSeries(
        @Path("id") id: Int
    ): SeriesDetailModel

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
    ): CreditsModel

}

