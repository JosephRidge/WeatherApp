package com.jayr.weatherapp.Network;

import com.jayr.weatherapp.Models.WeatherData;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {
//    http://api.openweathermap.org/data/2.5/weather?q=nairobi&appid=key

    @GET("2.5/weather")
    Call<WeatherData>getWeatherDetails(@Query("location") String location,
                                        @Query("key") String key);

}