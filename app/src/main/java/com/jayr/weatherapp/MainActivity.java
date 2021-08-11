package com.jayr.weatherapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.jayr.weatherapp.Models.WeatherData;
import com.jayr.weatherapp.Network.ApiInterface;
import com.jayr.weatherapp.Network.ApiService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    ApiInterface apiInterface;
    String location;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         apiInterface = ApiService.getRetrofitClient().create(ApiInterface.class);
        getWeatherData();

    }

    public String getSearchedLocation(){
        return location;
    }

    public void getWeatherData(){
        Call<WeatherData> call = apiInterface.getWeatherDetails(
                getSearchedLocation(),
                getResources().getString(R.string.key));
        call.enqueue(new Callback<WeatherData>() {
            @Override
            public void onResponse(@NonNull Call<WeatherData> call, @NonNull Response<WeatherData> response) {
                System.out.println("********* START DATA ***********");
                assert response.body() != null;
                System.out.println("LAT : ==== > "+response.body().getCoord().getLat());
                System.out.println("LON : ==== > "+response.body().getCoord().getLon());
                System.out.println("LOCATION : ==== > "+response.body().getName());
                System.out.println("WEATHER : ==== > "+response.body().getWeather().toString());
                System.out.println("********* END DATA ***********");
            }

            @Override
            public void onFailure(@NonNull Call<WeatherData> call, @NonNull Throwable t) {
                System.out.println("ERROR +=== > "+ t.getMessage());

            }
        });
    }
}