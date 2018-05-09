package com.appscyclone.androidtvdemo.data.api;

import com.appscyclone.androidtvdemo.data.models.MovieResponseModel;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/*
 * Created by NhatHoang on 09/05/2018.
 */
public interface TheMovieDbAPI {
    @GET("movie/now_playing")
    Observable<MovieResponseModel> getNowPlayingMovies(
            @Query("api_key") String apiKey,
            @Query("page") int page
    );

    @GET("movie/top_rated")
    Observable<MovieResponseModel> getTopRatedMovies(
            @Query("api_key") String apiKey,
            @Query("page") int page
    );
}
