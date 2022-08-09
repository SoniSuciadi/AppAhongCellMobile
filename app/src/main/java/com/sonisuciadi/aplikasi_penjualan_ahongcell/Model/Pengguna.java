package com.sonisuciadi.aplikasi_penjualan_ahongcell.Model;



import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.sonisuciadi.aplikasi_penjualan_ahongcell.API.APIRequestData;
import com.sonisuciadi.aplikasi_penjualan_ahongcell.API.RetroServer;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Pengguna {
    Context context;
    public Pengguna(Context context) {
        this.context = context;
    }

    private List<ModelPengguna> dataPengguna=new ArrayList<>();

    public List<ModelPengguna> getDataPengguna(){

        APIRequestData apiRequestData= RetroServer.konekRetrofit().create(APIRequestData.class);
        Call<ResponseModel> responseModelCall=apiRequestData.ardRetriveDataPengguna();
        responseModelCall.enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                int kode=(int) response.body().getKode();
                String pesan=(String) response.body().getPesan();
                dataPengguna=(ArrayList) response.body().getData();
                Toast.makeText(context,"Data Berhasil Ditarik", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {
                Toast.makeText(context, t.toString(), Toast.LENGTH_SHORT).show();
            }
        });
        return dataPengguna;
    }

}
