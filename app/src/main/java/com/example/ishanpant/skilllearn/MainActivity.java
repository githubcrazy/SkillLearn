package com.example.ishanpant.skilllearn;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.ishanpant.skilllearn.model.ApiClient;
import com.example.ishanpant.skilllearn.model.ApiInterface;
import com.example.ishanpant.skilllearn.model.DataHelper;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private DataAdapter dataAdapter;
    private LinearLayoutManager linearLayoutManager;
    private ArrayList<DataHelper> dataHelperList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        dataHelperList = new ArrayList<>();
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        dataAdapter = new DataAdapter(this , dataHelperList);
        recyclerView.setAdapter(dataAdapter);
        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<ArrayList<DataHelper>> call = apiInterface.getCityData();
        call.enqueue(new Callback<ArrayList<DataHelper>>() {
            @Override
            public void onResponse(Call<ArrayList<DataHelper>> call, Response<ArrayList<DataHelper>> response) {
                dataHelperList = response.body();
                dataAdapter.setData(dataHelperList);
            }

            @Override
            public void onFailure(Call<ArrayList<DataHelper>> call, Throwable t) {

            }
        });


    }
}
