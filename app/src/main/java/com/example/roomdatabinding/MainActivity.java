package com.example.roomdatabinding;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.sqlite.db.SupportSQLiteOpenHelper;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {


    StudentDatabase studentDatabase;
    RecyclerAdapter recyclerAdapter;
    RecyclerView recyclerView;

    List<DataModel> dataModelList;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.IdRecycelr);


        studentDatabase = StudentDatabase.getRoomInstance(this);






        Retrofit retrofit = RetrofitInstance.getINSTANCE();

        NetworkService service = retrofit.create(NetworkService.class);

        Call<List<DataModel>> call = service.getData();

        call.enqueue(new Callback<List<DataModel>>() {
            @Override
            public void onResponse(Call<List<DataModel>> call, Response<List<DataModel>> response) {

                Log.d( "onResponse: ",""+response.code());

                if (response.isSuccessful())
                {
                    List<DataModel> dataModels  = response.body();


                    for (DataModel list: dataModels)

                    {
                        Log.d("Data","...."+list.toString()+"\n");

                       studentDatabase.getDao().insertStudent(list);




                    }

                }

            }

            @Override
            public void onFailure(Call<List<DataModel>> call, Throwable t) {

                Log.d( "onFailure: ",""+t.getMessage());

            }
        });



         dataModelList = studentDatabase.getDao().getStudent();

         recyclerAdapter = new RecyclerAdapter(this,dataModelList);

         recyclerView.setAdapter(recyclerAdapter);





    }
}