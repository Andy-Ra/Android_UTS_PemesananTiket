package com.ivan_andy_ramadhan.utsa.ticketbox;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class Identitas extends AppCompatActivity {
    Button btnbackid, btnnextid;
    TextInputLayout edididen, ednmiden, edemiden, ednoiden, edaliden;
    RadioGroup rgiden;
    RadioButton rbktp, rbsim, rbkpl, rbpspr;

    String strididen, strjenis, strnmiden, stremiden, strnoiden, straliden;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_identitas);
        setTitle("Info Identitas");
        edididen = findViewById(R.id.ed_ididen);
        ednmiden = findViewById(R.id.ed_nmiden);
        edemiden = findViewById(R.id.ed_emiden);
        ednoiden = findViewById(R.id.ed_noiden);
        edaliden = findViewById(R.id.ed_aliden);

        rgiden = findViewById(R.id.rgiden);
        rbktp = findViewById(R.id.rb_ktp);
        rbsim = findViewById(R.id.rb_sim);
        rbkpl = findViewById(R.id.rb_kpl);
        rbpspr = findViewById(R.id.rb_pspr);


        btnbackid = findViewById(R.id.btnbackiden);
        btnnextid = findViewById(R.id.btnnextiden);

        btnbackid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        btnnextid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reset_notif();
                check();
            }
        });
    }

    private void check(){
        strjenis = "";
        if(rbktp.isChecked() == true){
            strjenis = "KTP";
        }
        else if(rbsim.isChecked() == true){
            strjenis = "SIM";
        }
        else if(rbkpl.isChecked() == true){
            strjenis = "Kartu Pelajar";
        }
        else if(rbpspr.isChecked() == true){
            strjenis = "Paspor";
        }

        strididen = edididen.getEditText().getText().toString();
        strnmiden = ednmiden.getEditText().getText().toString();
        stremiden = edemiden.getEditText().getText().toString();
        strnoiden = ednoiden.getEditText().getText().toString();
        straliden = edaliden.getEditText().getText().toString();

        if(!strididen.matches("[0-9]+") || strjenis.equals("") || strnmiden.equals("Nama") ||
                stremiden.equals("") || !strnoiden.matches("[0-9]+") || straliden.equals("")){
            if(!strididen.matches("[0-9]+")){
                edididen.setError("Masukkan Hanya Angka");
            }
            if(strjenis.equals("")){
                Toast.makeText(this, "Pilih Jenis Identitas", Toast.LENGTH_SHORT).show();
            }
            if(strnmiden.equals("")){
                ednmiden.setError("Masukkan Nama Anda");
            }
            if(stremiden.equals("")){
                edemiden.setError("Masukkan Email Anda");
            }
            if(!strnoiden.matches("[0-9]+")){
                ednoiden.setError("Masukkan Hanya Angka");
            }
            if(straliden.equals("")){
                edaliden.setError("Masukkan Alamat Anda");
            }
        }
        else {
            Intent pindah = new Intent(Identitas.this, Pembayaran.class);
            pindah.putExtra("lempar_id_tanggal", getIntent().getExtras().getString("lempar_pb_tanggal"));
            pindah.putExtra("lempar_id_tiket1", getIntent().getExtras().getInt("lempar_pb_tiket1"));
            pindah.putExtra("lempar_id_tiket2", getIntent().getExtras().getInt("lempar_pb_tiket2"));
            pindah.putExtra("lempar_id_tiket3", getIntent().getExtras().getInt("lempar_pb_tiket3"));
            pindah.putExtra("lempar_id_kota", getIntent().getExtras().getString("lempar_pb_kota"));

            pindah.putExtra("lempar_id_ididen",strididen);
            pindah.putExtra("lempar_id_jnsiden",strjenis);
            pindah.putExtra("lempar_id_nmiden",strnmiden);
            pindah.putExtra("lempar_id_emiden",stremiden);
            pindah.putExtra("lempar_id_noiden",strnoiden);
            pindah.putExtra("lempar_id_aliden",straliden);

            startActivity(pindah);
        }

    }
    private void reset_notif(){
        edididen.setError(null);
        ednmiden.setError(null);
        edemiden.setError(null);
        ednoiden.setError(null);
        edaliden.setError(null);
    }
}