package com.example.daronapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.daronapp.adapter.CustomAdapter;
import com.example.daronapp.model.Data;
import com.example.daronapp.model.Product;

import com.example.daronapp.network.GetDateService;
import com.example.daronapp.network.RetrofitClientInstance;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    CustomAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        /*Create handle for the RetrofitInstance interface*/
        GetDateService service = RetrofitClientInstance.getRetrofitInstance().create(GetDateService.class);
        Call<Product> call = service.getAllPhotos();


        call.enqueue(new Callback<Product>() {
            @Override
            public void onResponse(Call<Product> call, Response<Product> response) {
                generateDataList(response.body());
               // Toast.makeText(MainActivity.this, "sucsees", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Product> call, Throwable t) {
                Toast.makeText(MainActivity.this, "fail", Toast.LENGTH_SHORT).show();
                Log.e("test",t+"e");
            }
        });

    }

    /*Method to generate List of data using RecyclerView with custom adapter*/


    private void generateDataList(Product product) {


///

       List<Data> data= product.getDataList();

        //Toast.makeText(this, data.getName()+"w8", Toast.LENGTH_SHORT).show();

        recyclerView = findViewById(R.id.product_rv);
        adapter = new CustomAdapter(this,data);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }}