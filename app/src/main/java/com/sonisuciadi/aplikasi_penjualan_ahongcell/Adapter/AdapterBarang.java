package com.sonisuciadi.aplikasi_penjualan_ahongcell.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sonisuciadi.aplikasi_penjualan_ahongcell.Model.ModelBarang;
import com.sonisuciadi.aplikasi_penjualan_ahongcell.R;

import java.util.ArrayList;
import java.util.List;

public class AdapterBarang extends RecyclerView.Adapter<AdapterBarang.viewHolder> {
    Context context;
    List<ModelBarang> modelBarangs=new ArrayList<>();
    private OnButtonClickListener onButtonClickListener;

    public AdapterBarang(Context context, List<ModelBarang> modelBarangs) {
        this.context = context;
        this.modelBarangs = modelBarangs;

    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.cart_barang,parent,false);
        viewHolder viewHolder=new viewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        holder.bind(modelBarangs.get(position));
    }

    @Override
    public int getItemCount() {
        return modelBarangs.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        TextView kdBarang,namaBarang,stok,harga;
        Button btnPesan;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            kdBarang=itemView.findViewById(R.id.tv_kd_barang);
            namaBarang=itemView.findViewById(R.id.tv_nama_barang);
            stok=itemView.findViewById(R.id.tv_stok);
            harga=itemView.findViewById(R.id.tv_harga);
            btnPesan=itemView.findViewById(R.id.btn_pesan);
        }
        public void bind(ModelBarang item ){
            kdBarang.setText(item.getKd_barang());
            namaBarang.setText(item.getNama_barang());
            stok.setText(item.getStok());
            harga.setText(item.getHarga_jual());


        }

    }
    public interface OnButtonClickListener{
        void onItemClick(ModelBarang item,int position );
    }
}
