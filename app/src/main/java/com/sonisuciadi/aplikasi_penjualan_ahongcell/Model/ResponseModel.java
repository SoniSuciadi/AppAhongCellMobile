package com.sonisuciadi.aplikasi_penjualan_ahongcell.Model;

import java.util.ArrayList;
import java.util.List;

public class ResponseModel {
    private int kode;
    private String pesan;
    private ArrayList data;

    public ResponseModel() {
        this.kode = kode;
        this.pesan = pesan;
        this.data = data;
    }

    public int getKode() {
        return kode;
    }

    public void setKode(int kode) {
        this.kode = kode;
    }

    public String getPesan() {
        return pesan;
    }

    public void setPesan(String pesan) {
        this.pesan = pesan;
    }

    public ArrayList getData() {
        return data;
    }

    public void setData(ArrayList data) {
        this.data = data;
    }
}
