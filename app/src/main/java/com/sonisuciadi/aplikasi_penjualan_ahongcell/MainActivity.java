package com.sonisuciadi.aplikasi_penjualan_ahongcell;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import com.sonisuciadi.aplikasi_penjualan_ahongcell.Model.Pengguna;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        Pengguna pengguna=new Pengguna(MainActivity.this);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                //setelah loading maka akan langsung berpindah ke home activity
                Intent login=new Intent(MainActivity.this, LoginActivity.class);
                startActivity(login);
                overridePendingTransition(R.anim.push_up_in, R.anim.push_up_out);
                finish();

            }
        },1500);
    }
}