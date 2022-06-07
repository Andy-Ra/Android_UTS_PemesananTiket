package com.ivan_andy_ramadhan.utsa.ticketbox;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Pembayaran extends AppCompatActivity {
TextView etjml1, etjml2, etjml3, etttl1, etttl2, etttl3, etttl4, tvtanggaltrf;
int intjml1, intjml2, intjml3, intttl1, intttl2, intttl3, intttl4;
TextInputLayout edbyrbank, edbyrnama, edbyrjmlh, edbyrac;
DatePicker dtbyr;
Button btnprs;
RadioButton rbtf, rbcc;
LinearLayout lypbdt1, lypbdt2, lypbdt3;

String strbyrjenis, strbyrbank, strbyrnama, strbyrjmlh, strbyrac, strbyrdt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pembayaran);
        setTitle("Info Pembayaran");
        etjml1 = findViewById(R.id.et_jml1);
        etjml2 = findViewById(R.id.et_jml2);
        etjml3 = findViewById(R.id.et_jml3);

        etttl1 = findViewById(R.id.et_ttl1);
        etttl2 = findViewById(R.id.et_ttl2);
        etttl3 = findViewById(R.id.et_ttl3);
        etttl4 = findViewById(R.id.et_ttl4);

        lypbdt1 = findViewById(R.id.ly_dt1);
        lypbdt2 = findViewById(R.id.ly_dt2);
        lypbdt3 = findViewById(R.id.ly_dt3);

        rbtf = findViewById(R.id.rbbyr1);
        rbcc = findViewById(R.id.rbbyr2);

        edbyrbank = findViewById(R.id.ed_byrbank);
        edbyrnama = findViewById(R.id.ed_byrnama);
        edbyrjmlh = findViewById(R.id.ed_byrjmlh);
        edbyrac = findViewById(R.id.ed_byrac);

        dtbyr = findViewById(R.id.dp_byrtgl);
        btnprs = findViewById(R.id.btnpprsbyr);
        tvtanggaltrf = findViewById(R.id.tvtanggaltrf);

        cekbeli();
        resettampilan();
        resetnotif();

        rbtf.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                ubah_bayar();
            }
        });
        rbcc.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                ubah_bayar();
            }
        });
        btnprs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bayar();
            }
        });
    }

    private void cekbeli(){
        intjml1 = 0;
        intjml2 = 0;
        intjml3 = 0;
        intttl1 = 0;
        intttl2 = 0;
        intttl3 = 0;

        lypbdt1.setVisibility(View.GONE);
        lypbdt2.setVisibility(View.GONE);
        lypbdt3.setVisibility(View.GONE);
        tvtanggaltrf.setVisibility(View.GONE);

        intjml1 = getIntent().getExtras().getInt("lempar_id_tiket1");
        intjml2 = getIntent().getExtras().getInt("lempar_id_tiket2");
        intjml3 = getIntent().getExtras().getInt("lempar_id_tiket3");
        if (intjml1 > 0){
            intttl1 = intjml1 * 250000;
            lypbdt1.setVisibility(View.VISIBLE);
            etjml1.setText(String.valueOf(intjml1));
            etttl1.setText(String.valueOf(intttl1));
        }
        if (intjml2 > 0){
            intttl2 = intjml2 * 300000;
            lypbdt2.setVisibility(View.VISIBLE);
            etjml2.setText(String.valueOf(intjml2));
            etttl2.setText(String.valueOf(intttl2));
        }
        if (intjml3 > 0){
            intttl3 = intjml3 * 500000;
            lypbdt3.setVisibility(View.VISIBLE);
            etjml3.setText(String.valueOf(intjml3));
            etttl3.setText(String.valueOf(intttl3));
        }
        intttl4 = intttl1 + intttl2 + intttl3;
        etttl4.setText(String.valueOf(intttl4));

    }

    private void ubah_bayar(){
        resettampilan();
        if(rbtf.isChecked()){
            edbyrbank.setVisibility(View.VISIBLE);
            edbyrbank.setHint("Via Bank");
            edbyrnama.setVisibility(View.VISIBLE);
            edbyrnama.setHint("Atas Nama");
            edbyrjmlh.setVisibility(View.VISIBLE);
            edbyrjmlh.setHint("Jumlah transfer");
            edbyrac.setVisibility(View.VISIBLE);
            edbyrac.setHint("No Virtual Acoount");
            dtbyr.setVisibility(View.VISIBLE);
            btnprs.setVisibility(View.VISIBLE);
            tvtanggaltrf.setVisibility(View.VISIBLE);
        }

        else if(rbcc.isChecked()){
            edbyrbank.setVisibility(View.VISIBLE);
            edbyrbank.setHint("Nama Kartu Kredit");
            edbyrnama.setVisibility(View.VISIBLE);
            edbyrnama.setHint("Atas Nama");
            edbyrjmlh.setVisibility(View.VISIBLE);
            edbyrjmlh.setHint("Jumlah bayar");
            edbyrac.setVisibility(View.GONE);
            dtbyr.setVisibility(View.VISIBLE);
            btnprs.setVisibility(View.VISIBLE);
            tvtanggaltrf.setVisibility(View.VISIBLE);
        }
    }

    private void resettampilan(){
        edbyrbank.setVisibility(View.GONE);
        edbyrnama.setVisibility(View.GONE);
        edbyrjmlh.setVisibility(View.GONE);
        edbyrac.setVisibility(View.GONE);
        dtbyr.setVisibility(View.GONE);
        btnprs.setVisibility(View.GONE);
    }

    public void bayar(){
        resetnotif();
        strbyrbank = edbyrbank.getEditText().getText().toString();
        strbyrnama = edbyrnama.getEditText().getText().toString();
        strbyrjmlh = edbyrjmlh.getEditText().getText().toString();
        strbyrac = edbyrac.getEditText().getText().toString();
        try{
            int day = dtbyr.getDayOfMonth();
            int month = dtbyr.getMonth();
            int year = dtbyr.getYear();
            strbyrdt = String.valueOf(day) + " - " + String.valueOf(month) + " - " + String.valueOf(year);
        }
        catch (Exception e){

        }
        if(rbtf.isChecked()) {
            strbyrjenis = "Transfer Bank";
            if (strbyrbank.equals("") || strbyrnama.equals("") || strbyrjmlh.equals("") || strbyrac.equals("")
                ||!strbyrjmlh.matches("[0-9]+")){
                if (strbyrbank.equals("")) {
                    edbyrbank.setError("Mohon Isi Kolom ini");
                }
                if (strbyrnama.equals("")) {
                    edbyrnama.setError("Mohon Isi Kolom ini");
                }
                if (!strbyrjmlh.matches("[0-9]+")) {
                    edbyrjmlh.setError("Mohon isi Hanya Angka");
                }
                if (strbyrac.equals("")) {
                    edbyrac.setError("Mohon Isi Kolom ini");
                }
            }
            else{
                berhasilbayar();
            }
        }
        else if(rbcc.isChecked()) {
            strbyrjenis = "Kartu Kredit";
            if (strbyrbank.equals("") || strbyrnama.equals("") || strbyrjmlh.equals("") || !strbyrjmlh.matches("[0-9]+")) {
                if (strbyrbank.equals("")) {
                    edbyrbank.setError("Mohon Isi Kolom ini");
                }
                if (strbyrnama.equals("")) {
                    edbyrnama.setError("Mohon Isi Kolom ini");
                }
                if (!strbyrjmlh.matches("[0-9]+")) {
                    edbyrjmlh.setError("Mohon isi Hanya Angka");
                }
            }
            else{
                berhasilbayar();
            }
        }
    }

    public void berhasilbayar(){
        Intent pindah = new Intent(Pembayaran.this, DetailPembelian.class);
        pindah.putExtra("lempar_byr_tanggal", getIntent().getExtras().getString("lempar_id_tanggal"));
        pindah.putExtra("lempar_byr_tiket1", String.valueOf(intjml1));
        pindah.putExtra("lempar_byr_tiket2", String.valueOf(intjml2));
        pindah.putExtra("lempar_byr_tiket3", String.valueOf(intjml3));
        pindah.putExtra("lempar_byr_total", String.valueOf(intttl4));
        pindah.putExtra("lempar_byr_kota", getIntent().getExtras().getString("lempar_id_kota"));

        pindah.putExtra("lempar_byr_ididen", getIntent().getExtras().getString("lempar_id_ididen"));
        pindah.putExtra("lempar_byr_jnsiden", getIntent().getExtras().getString("lempar_id_jnsiden"));
        pindah.putExtra("lempar_byr_nmiden", getIntent().getExtras().getString("lempar_id_nmiden"));
        pindah.putExtra("lempar_byr_emiden", getIntent().getExtras().getString("lempar_id_emiden"));
        pindah.putExtra("lempar_byr_noiden", getIntent().getExtras().getString("lempar_id_noiden"));
        pindah.putExtra("lempar_byr_aliden", getIntent().getExtras().getString("lempar_id_aliden"));

        pindah.putExtra("lempar_byr_jenis",strbyrjenis);
        pindah.putExtra("lempar_byr_bank",strbyrbank);
        pindah.putExtra("lempar_byr_nama",strbyrnama);
        pindah.putExtra("lempar_byr_jmlh",strbyrjmlh);
        pindah.putExtra("lempar_byr_ac",strbyrac);
        pindah.putExtra("lempar_byr_dt",strbyrdt);

        startActivity(pindah);
    }

    private void resetnotif(){
        edbyrbank.setError(null);
        edbyrnama.setError(null);
        edbyrjmlh.setError(null);
        edbyrac.setError(null);
    }
}