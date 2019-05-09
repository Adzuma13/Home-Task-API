package com.example.chocoapi;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.chocoapi.adapter.DealAdapter;
import com.example.chocoapi.adapter.DealViewHolder;
import com.example.chocoapi.rest.ChocoApi;
import com.example.chocoapi.rest.NetworkService;
import com.example.chocoapi.rest.entities.Deal;
import com.example.chocoapi.rest.entities.MainDeal;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    DealAdapter dealAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        dealAdapter = new DealAdapter();
        recyclerView.setAdapter(dealAdapter);

        load();
    }


    public void load(){
        NetworkService networkService = NetworkService.getInstance();
        ChocoApi chocoApi = networkService.getChocoApi();
        Log.i("myTag", "loadData");

        Call<MainDeal> call = chocoApi.getDealList(1,1,1);

        call.enqueue(new Callback<MainDeal>() {
            @Override
            public void onResponse(Call<MainDeal> call, Response<MainDeal> response) {
                MainDeal mainDeal = response.body();
                List<Deal> list = mainDeal.getResultList();
                Log.i("myTag", "OnResponse");
                dealAdapter.setDealList(list);
            }

            @Override
            public void onFailure(Call<MainDeal> call, Throwable t) {
                Log.i("myTag", "onFailure");
                View v = null;
                Toast.makeText(v.getContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}

