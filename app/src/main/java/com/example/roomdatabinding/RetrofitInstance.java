package com.example.roomdatabinding;

import androidx.annotation.Nullable;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {


    public static Retrofit INSTANCE;

    private RetrofitInstance(){}

    public static Retrofit getINSTANCE()
    {
        if (INSTANCE==null)
        {
            INSTANCE= new Retrofit.Builder().baseUrl("https://run.mocky.io/")
                    .addConverterFactory(GsonConverterFactory.create()).build();
        }
        return INSTANCE;
    }


}
