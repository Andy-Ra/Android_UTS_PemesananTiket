package com.ivan_andy_ramadhan.utsa.ticketbox;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class JadwalKonser extends AppCompatActivity {
    int imgborder[]= {R.drawable.banner1, R.drawable.banner2, R.drawable.banner3};
    String strtgl[] = {"27 September 2017", "25 April 2018", "06 Maret 2019"};
    String strkota[] = {"Malang, Surabaya, DKI Jakarta",
                        "Depok, Palembang, Yogyakarta",
                        "Bandung, Malang, Denpasar"};
    String strhrg[] = {"Rp. 1.000.000,00", "Rp. 250.000,00", "Rp. 300.000,00"};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        int posisijadwal = getIntent().getExtras().getInt("lempar_posisi");
        String juduljadwal = getIntent().getExtras().getString("lempar_textlist");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jadwal_konser);
        setTitle(juduljadwal);

        ImageView img_bnrjdwl = findViewById(R.id.imv_jdwl_bner);
        TextView tv_jdljdwl = findViewById(R.id.tv_jdwl_judul);
        TextView tv_tgljdwl = findViewById(R.id.tv_jdwl_tanggal);
        TextView tv_kotajdwl = findViewById(R.id.tv_jdwl_kota);
        TextView tv_hrgjdwl = findViewById(R.id.tv_jdwl_hrg);

        img_bnrjdwl.setImageResource(imgborder[posisijadwal]);
        tv_jdljdwl.setText(juduljadwal);
        tv_tgljdwl.setText(strtgl[posisijadwal]);
        tv_kotajdwl.setText(strkota[posisijadwal]);
        tv_hrgjdwl.setText(strhrg[posisijadwal]);
    }
}