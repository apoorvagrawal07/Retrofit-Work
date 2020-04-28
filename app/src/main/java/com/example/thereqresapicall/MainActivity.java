 package com.example.thereqresapicall;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AbsListView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

 public class MainActivity extends AppCompatActivity {
     Retrofit retrofit;
     RecyclerView recyclerView;
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
        protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recView);
        final LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        retrofit = new Retrofit.Builder()
                .baseUrl("https://reqres.in/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

            getUsers();
        }

        private void getUsers() {
         UserInterface userInterface = retrofit.create(UserInterface.class);
         Call<DataClass> classCall = userInterface.getData(1);

         classCall.enqueue(new Callback<DataClass>() {

             @Override
             public void onResponse(Call<DataClass> call, Response<DataClass> response) {
                 ArrayList<Structure> ourData = response.body().getData();
                 recyclerView.setAdapter(new DataAdapter(MainActivity.this,ourData));


             }

             @Override
             public void onFailure(Call<DataClass> call, Throwable t) {
                 Log.d("Error","Failure");
             }
         });


    }
 }
