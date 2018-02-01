package com.bignerdranch.androidboy.douban;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by androidboy on 18-2-1.
 */

public interface MovieInterface {
    @GET("v2/movie/search")
    Call<Movie> getcall(@Query("q")String text);
}
