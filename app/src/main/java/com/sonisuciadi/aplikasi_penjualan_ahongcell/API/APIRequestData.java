package com.sonisuciadi.aplikasi_penjualan_ahongcell.API;


import com.sonisuciadi.aplikasi_penjualan_ahongcell.Model.ResponseModel;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIRequestData {
    @GET("retrieve_barang.php")
    Call<ResponseModel> ardRetriveDataBarang();

    @GET("retrieve_pengguna.php")
    Call<ResponseModel> ardRetriveDataPengguna();

//    @GET("retrieve_barang.php")
//    Call<ResponseModel> ardRetriveDataBarang();

}
