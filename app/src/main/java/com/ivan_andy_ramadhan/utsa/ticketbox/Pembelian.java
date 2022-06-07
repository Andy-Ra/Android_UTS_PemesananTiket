package com.ivan_andy_ramadhan.utsa.ticketbox;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.Spinner;

import com.google.android.material.textfield.TextInputLayout;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class Pembelian extends AppCompatActivity {
    CheckBox cbtk1, cbtk2, cbtk3;
    TextInputLayout edtk1, edtk2, edtk3;
    Button btnnextpb, btnbackpb;
    LinearLayout lytk1, lytk2, lytk3;
    Spinner spkota;
    DatePicker dptglpb;

    public int konser1, konser2, konser3, totalkonser;
    String strkotapb, tanggalkonser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pembelian);
        setTitle("Pilih Tiket");
        cbtk1 = findViewById(R.id.cb_ks1);
        cbtk2 = findViewById(R.id.cb_ks2);
        cbtk3 = findViewById(R.id.cb_ks3);

        edtk1 = findViewById(R.id.ed_jmltk1);
        edtk2 = findViewById(R.id.ed_jmltk2);
        edtk3 = findViewById(R.id.ed_jmltk3);

        lytk1 = findViewById(R.id.lytk1);
        lytk2 = findViewById(R.id.lytk2);
        lytk3 = findViewById(R.id.lytk3);

        spkota = findViewById(R.id.sp_kota);
        dptglpb = findViewById(R.id.dp_tglpb);

        btnbackpb = findViewById(R.id.btnbackttiket);
        btnnextpb = findViewById(R.id.btnnexttiket);

        totalkonser = 0;
        pilih_checkbox();

        btnbackpb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pindah = new Intent(Pembelian.this, MainActivity.class);
                startActivity(pindah);
            }
        });
        btnnextpb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetnotif();
                ambil();
                hitung();
            }
        });
    }

    private void pilih_checkbox() {
        cbtk1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (cbtk1.isChecked()) {
                    lytk1.setVisibility(View.VISIBLE);
                } else {
                    lytk1.setVisibility(View.GONE);
                    edtk1.getEditText().setText("");
                }
            }
        });
        cbtk2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (cbtk2.isChecked()) {
                    lytk2.setVisibility(View.VISIBLE);
                } else {
                    lytk2.setVisibility(View.GONE);
                    edtk2.getEditText().setText("");
                }
            }
        });
        cbtk3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (cbtk3.isChecked()) {
                    lytk3.setVisibility(View.VISIBLE);
                } else {
                    lytk3.setVisibility(View.GONE);
                    edtk3.getEditText().setText("");
                }
            }
        });
    }

    public void ambil() {
        strkotapb = spkota.getSelectedItem().toString();
    }

    public void hitung() {
        konser1 = 0;
        konser2 = 0;
        konser3 = 0;

        try{

            int day = dptglpb.getDayOfMonth();
            int month = dptglpb.getMonth();
            int year = dptglpb.getYear();
            tanggalkonser = String.valueOf(day) + " - " + String.valueOf(month) + " - " + String.valueOf(year);
        }
        catch (Exception e){

        }
        if (cbtk1.isChecked() && !edtk1.getEditText().getText().toString().matches("[0-9]+") ||
                cbtk2.isChecked() && !edtk2.getEditText().getText().toString().matches("[0-9]+") ||
                cbtk3.isChecked() && !edtk3.getEditText().getText().toString().matches("[0-9]+")) {
            if (cbtk1.isChecked() && !edtk1.getEditText().getText().toString().matches("[0-9]+")) {
                edtk1.setError("Mohon Masukkan Hanya Angka");
            }
            if (cbtk2.isChecked() && !edtk2.getEditText().getText().toString().matches("[0-9]+")) {
                edtk2.setError("Mohon Masukkan Hanya Angka");
            }
            if (cbtk3.isChecked() && !edtk3.getEditText().getText().toString().matches("[0-9]+")) {
                edtk3.setError("Mohon Masukkan Hanya Angka");
            }
        } else if (!cbtk1.isChecked() && !cbtk2.isChecked() && !cbtk3.isChecked()) {
            cbtk1.setError("Mohon Pilih Konser");
            cbtk2.setError("Mohon Pilih Konser");
            cbtk3.setError("Mohon Pilih Konser");
        } else if (cbtk1.isChecked() && edtk1.getEditText().getText().toString().matches("[0-9]+") ||
                cbtk2.isChecked() && edtk2.getEditText().getText().toString().matches("[0-9]+") ||
                cbtk3.isChecked() && edtk3.getEditText().getText().toString().matches("[0-9]+")) {
            if (cbtk1.isChecked() && edtk1.getEditText().getText().toString().matches("[0-9]+")) {
                konser1 = Integer.parseInt(edtk1.getEditText().getText().toString());
                totalkonser += konser1 * 250000;
            }
            if (cbtk2.isChecked() && edtk2.getEditText().getText().toString().matches("[0-9]+")) {
                konser2 = Integer.parseInt(edtk2.getEditText().getText().toString());
                totalkonser += konser2 * 300000;
            }
            if (cbtk3.isChecked() && edtk3.getEditText().getText().toString().matches("[0-9]+")) {
                konser3 = Integer.parseInt(edtk3.getEditText().getText().toString());
                totalkonser += konser3 * 500000;
            }

            Intent pindah = new Intent(Pembelian.this, Identitas.class);
            pindah.putExtra("lempar_pb_tanggal", tanggalkonser);
            pindah.putExtra("lempar_pb_tiket1", konser1);
            pindah.putExtra("lempar_pb_tiket2", konser2);
            pindah.putExtra("lempar_pb_tiket3", konser3);
            pindah.putExtra("lempar_pb_kota", strkotapb);

            startActivity(pindah);
        }
    }

    private void resetnotif() {
        cbtk1.setError(null);
        cbtk2.setError(null);
        cbtk3.setError(null);
        edtk1.setError(null);
        edtk2.setError(null);
        edtk3.setError(null);
    }
}