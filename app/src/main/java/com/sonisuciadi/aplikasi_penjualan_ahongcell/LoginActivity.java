package com.sonisuciadi.aplikasi_penjualan_ahongcell;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;
import com.sonisuciadi.aplikasi_penjualan_ahongcell.API.APIRequestData;
import com.sonisuciadi.aplikasi_penjualan_ahongcell.API.RetroServer;
import com.sonisuciadi.aplikasi_penjualan_ahongcell.Model.Barang;
import com.sonisuciadi.aplikasi_penjualan_ahongcell.Model.ModelBarang;
import com.sonisuciadi.aplikasi_penjualan_ahongcell.Model.ModelPengguna;
import com.sonisuciadi.aplikasi_penjualan_ahongcell.Model.Pengguna;
import com.sonisuciadi.aplikasi_penjualan_ahongcell.Model.ResponseModel;

import org.json.JSONArray;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    EditText edUsername,edPassword;
    Button btnLogin;
    List<ModelPengguna> dataPengguna=new ArrayList<>();
    Pengguna pengguna=new Pengguna(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        edUsername=findViewById(R.id.et_username);
        edPassword=findViewById(R.id.et_password);
//        dataPengguna=pengguna.getDataPengguna();

        APIRequestData apiRequestData= RetroServer.konekRetrofit().create(APIRequestData.class);
        Call<ResponseModel> responseModelCall=apiRequestData.ardRetriveDataPengguna();
        responseModelCall.enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                int kode=(int) response.body().getKode();
                String pesan=(String) response.body().getPesan();
                dataPengguna=response.body().getData();


                Toast.makeText(LoginActivity.this,"Data Berhasil Ditarik", Toast.LENGTH_SHORT).show();
//                        Toast.makeText(LoginActivity.this, dataPengguna.get(0).getId_pengguna(), Toast.LENGTH_SHORT).show();

//
            }

            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {
                Toast.makeText(LoginActivity.this, t.toString(), Toast.LENGTH_SHORT).show();
            }

        });
        btnLogin=findViewById(R.id.btn_login);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                dummyData();
                System.out.println(dataPengguna);

                boolean loginStatus=false;

                for (int i=0;i<dataPengguna.size();i++){
                    String username=(String)dataPengguna.get(i).getId_pengguna();
                    String password=(String)dataPengguna.get(i).getPassword();
//                    System.out.println(username);
//                    System.out.println(password);
                            if (username.equalsIgnoreCase(edUsername.getText().toString()) && password.equalsIgnoreCase(edPassword.getText().toString()) ){
                                System.out.println(username);
                                System.out.println(password);
                                loginStatus=true;
                                break;
                            }
                }
                if (loginStatus==true){
                            Intent intent=new Intent(LoginActivity.this,HomeActivity.class);
                    Toast.makeText(LoginActivity.this, "Berhasil", Toast.LENGTH_SHORT).show();
//                            startActivity(intent);
                        }else if (loginStatus==false){
                            Toast.makeText(LoginActivity.this, "Username atau Password Salah", Toast.LENGTH_SHORT).show();
                        }


            }
        });
    }
    public void dummyData(){
        ModelPengguna modelPengguna=new ModelPengguna();
        modelPengguna.setId_pengguna("1");
        modelPengguna.setNama_pengguna("SONI SUCIADI");
        modelPengguna.setAlamat_pengguna("11 ULU");
        modelPengguna.setNohp_pengguna("08117858100");
        modelPengguna.setJabatan("GUDANG");
        modelPengguna.setPassword("a");
        dataPengguna.add(modelPengguna);

        modelPengguna=new ModelPengguna();
        modelPengguna.setId_pengguna("2");
        modelPengguna.setNama_pengguna("SONI SUCIADI");
        modelPengguna.setAlamat_pengguna("11 ULU");
        modelPengguna.setNohp_pengguna("08117858100");
        modelPengguna.setJabatan("GUDANG");
        modelPengguna.setPassword("a");
        dataPengguna.add(modelPengguna);

        modelPengguna=new ModelPengguna();
        modelPengguna.setId_pengguna("3");
        modelPengguna.setNama_pengguna("SONI SUCIADI");
        modelPengguna.setAlamat_pengguna("11 ULU");
        modelPengguna.setNohp_pengguna("08117858100");
        modelPengguna.setJabatan("GUDANG");
        modelPengguna.setPassword("a");
        dataPengguna.add(modelPengguna);

        modelPengguna=new ModelPengguna();
        modelPengguna.setId_pengguna("4");
        modelPengguna.setNama_pengguna("SONI SUCIADI");
        modelPengguna.setAlamat_pengguna("11 ULU");
        modelPengguna.setNohp_pengguna("08117858100");
        modelPengguna.setJabatan("GUDANG");
        modelPengguna.setPassword("a");
        dataPengguna.add(modelPengguna);
    }
}