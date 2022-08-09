package com.sonisuciadi.aplikasi_penjualan_ahongcell.Model;

public class ModelPengguna {
    private String id_pengguna,nama_pengguna,alamat_pengguna,nohp_pengguna,jabatan,password;

    public ModelPengguna() {
        this.id_pengguna = id_pengguna;
        this.nama_pengguna = nama_pengguna;
        this.alamat_pengguna = alamat_pengguna;
        this.nohp_pengguna = nohp_pengguna;
        this.jabatan = jabatan;
        this.password = password;
    }

    public String getId_pengguna() {
        return id_pengguna;
    }

    public void setId_pengguna(String id_pengguna) {
        this.id_pengguna = id_pengguna;
    }

    public String getNama_pengguna() {
        return nama_pengguna;
    }

    public void setNama_pengguna(String nama_pengguna) {
        this.nama_pengguna = nama_pengguna;
    }

    public String getAlamat_pengguna() {
        return alamat_pengguna;
    }

    public void setAlamat_pengguna(String alamat_pengguna) {
        this.alamat_pengguna = alamat_pengguna;
    }

    public String getNohp_pengguna() {
        return nohp_pengguna;
    }

    public void setNohp_pengguna(String nohp_pengguna) {
        this.nohp_pengguna = nohp_pengguna;
    }

    public String getJabatan() {
        return jabatan;
    }

    public void setJabatan(String jabatan) {
        this.jabatan = jabatan;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
