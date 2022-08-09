package com.sonisuciadi.aplikasi_penjualan_ahongcell;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.sonisuciadi.aplikasi_penjualan_ahongcell.API.APIRequestData;
import com.sonisuciadi.aplikasi_penjualan_ahongcell.API.RetroServer;
import com.sonisuciadi.aplikasi_penjualan_ahongcell.Adapter.AdapterBarang;
import com.sonisuciadi.aplikasi_penjualan_ahongcell.Model.Barang;
import com.sonisuciadi.aplikasi_penjualan_ahongcell.Model.ModelBarang;
import com.sonisuciadi.aplikasi_penjualan_ahongcell.Model.ResponseModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeActivity extends AppCompatActivity {
    RecyclerView rvBarang;
    RecyclerView.Adapter adapterBarang;
    List dataBarang=new ArrayList<>();
    Barang barang=new Barang(HomeActivity.this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        rvBarang=findViewById(R.id.rv_barang);
        dataBarang=barang.getDataBarang();
        RecyclerView.LayoutManager lmData = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
//        System.out.println(modelBarangs);
        rvBarang.setLayoutManager(lmData);
        setRecyclerViewBarang();
    }
    public void setRecyclerViewBarang(){
        APIRequestData apiRequestData= RetroServer.konekRetrofit().create(APIRequestData.class);
        Call<ResponseModel> responseModelCall=apiRequestData.ardRetriveDataBarang();
        responseModelCall.enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                int kode=(int) response.body().getKode();
                String pesan=(String) response.body().getPesan();
                dataBarang=(ArrayList) response.body().getData();
                Toast.makeText(HomeActivity.this,"Data Berhasil Ditarik", Toast.LENGTH_SHORT).show();

                adapterBarang=new AdapterBarang(HomeActivity.this,dataBarang);
                rvBarang.setAdapter(adapterBarang);
                adapterBarang.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {

            }
        });
    }


}