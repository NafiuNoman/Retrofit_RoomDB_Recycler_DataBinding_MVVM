package com.example.roomdatabinding;

import android.text.style.AlignmentSpan;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface NetworkService {



    @GET("v3/d688c75f-3ba6-4aad-b9f7-8b9ddf1a2a4b")
    Call <List<DataModel>> getData();




}
