package com.chinmay.starwarswithdagger2.retrofit;

import com.chinmay.starwarswithdagger2.pojo.Films;
import com.chinmay.starwarswithdagger2.pojo.StarWars;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface ApiInterface {



    @GET("people/?")
    Call<StarWars> getPeople(@Query("format")String format);

    Call<Films> getFilmData(@Url String url, @Query("format") String format);
}
