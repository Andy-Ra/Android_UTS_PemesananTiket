package com.ivan_andy_ramadhan.utsa.ticketbox;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.widget.TextView;

public class Informasi extends AppCompatActivity {
TextView tvversi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informasi);
        setTitle("Informasi");

        tvversi = findViewById(R.id.tvversi);

        tvversi.setText("V." +BuildConfig.VERSION_NAME);

    }
}