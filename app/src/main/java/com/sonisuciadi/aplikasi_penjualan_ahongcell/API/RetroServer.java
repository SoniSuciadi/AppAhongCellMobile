package com.sonisuciadi.aplikasi_penjualan_ahongcell.API;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetroServer {
    private static final String baseUrl="http://10.0.2.2/kp_soni_jepri/";
    private static Retrofit retro;
    public static Retrofit konekRetrofit(){
        if (retro==null){
            retro=new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

        }
        return retro;
    }
}
