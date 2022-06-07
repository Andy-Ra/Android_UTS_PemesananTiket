package com.ivan_andy_ramadhan.utsa.ticketbox;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
ImageButton btn_pmb, btn_ofc, btn_info, btn_dftr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Menu Utama");
        btn_pmb = findViewById(R.id.btn_pesan);
        btn_dftr = findViewById(R.id.btn_konser);
        btn_ofc = findViewById(R.id.btn_off);
        btn_info = findViewById(R.id.btn_info);
        btn_pmb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pindah = new Intent(MainActivity.this, Pembelian.class);
                startActivity(pindah);
            }
        });
        btn_dftr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pindah = new Intent(MainActivity.this, Daftar.class);
                startActivity(pindah);
            }
        });
        btn_ofc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pindah = new Intent(MainActivity.this, Official.class);
                startActivity(pindah);
            }
        });
        btn_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pindah = new Intent(MainActivity.this, Informasi.class);
                startActivity(pindah);
            }
        });

    }
}