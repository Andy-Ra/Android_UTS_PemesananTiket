package com.ivan_andy_ramadhan.utsa.ticketbox;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class DetailPembelian extends AppCompatActivity {
    TextView tvjml1p, tvjml2p, tvjml3p,
            tvptglp, tvpnp, tvpip, tvpji, tvpem, tvptelpp,
            tvpalmtp, tvptk, tvptb, tvpjp, tvpnva, tvpan, tvpttl, tvpjml, tvpbp;
    LinearLayout lyjmld1,lyjmld2, lyjmld3;
    Button btnmenu;
    @Override
    protected void onCreate(Bundle savtvInstanceState) {
        super.onCreate(savtvInstanceState);
        setContentView(R.layout.activity_detail_pembelian);
        setTitle("Detail Pembelian");
        tvjml1p = findViewById(R.id.dt_jml1);
        tvjml2p = findViewById(R.id.dt_jml2);
        tvjml3p = findViewById(R.id.dt_jml3);

        tvptglp = findViewById(R.id.dp_tglp1);
        tvpnp = findViewById(R.id.dp_nama);
        tvpip = findViewById(R.id.dp_id);
        tvpji = findViewById(R.id.dp_jenis);
        tvpem = findViewById(R.id.dp_email);
        tvptelpp = findViewById(R.id.dp_no);
        tvpalmtp = findViewById(R.id.dp_alamat);
        tvptk = findViewById(R.id.dp_kota);

        tvptb = findViewById(R.id.dp_tglp2);
        tvpjp = findViewById(R.id.dp_jenisp);
        tvpnva = findViewById(R.id.dp_norek);
        tvpan = findViewById(R.id.dp_anp);
        tvpttl = findViewById(R.id.dp_ttlp);
        tvpjml = findViewById(R.id.dp_jbp);
        tvpbp = findViewById(R.id.dp_namabp);

        lyjmld1 = findViewById(R.id.ly_dtp1);
        lyjmld2 = findViewById(R.id.ly_dtp2);
        lyjmld3 = findViewById(R.id.ly_dtp3);

        btnmenu = findViewById(R.id.btn_menu);

        jumlah_dp();
        tampil();

        btnmenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pindah = new Intent(DetailPembelian.this, MainActivity.class);
                finish();
                startActivity(pindah);
            }
        });

    }

    private void tampil(){
        if(tvpbp.equals("Transfer Bank")){
            tvpnva.setVisibility(View.VISIBLE);
        }
        else{
            tvpnva.setVisibility(View.GONE);
        }
        tvptglp.setText("Tanggal Pesan \t: "+ getIntent().getExtras().getString("lempar_byr_tanggal"));
        tvpnp.setText("Nama Pelanggan  \t: "+ getIntent().getExtras().getString("lempar_byr_nmiden"));
        tvpem.setText("Email Pelanggan  \t: "+ getIntent().getExtras().getString("lempar_byr_emiden"));
        tvpip.setText("Id Pelanggan \t\t: "+ getIntent().getExtras().getString("lempar_byr_ididen"));
        tvpji.setText("Jenis Id \t\t\t\t: "+ getIntent().getExtras().getString("lempar_byr_jnsiden"));
        tvptelpp.setText("No Telp Pelangan \t: "+ getIntent().getExtras().getString("lempar_byr_noiden"));
        tvpalmtp.setText("Alamat Pelangan \t: "+ getIntent().getExtras().getString("lempar_byr_aliden"));
        tvptk.setText("Tempat konser \t: "+ getIntent().getExtras().getString("lempar_byr_kota"));

        tvptb.setText("Tanggal Bayar \t\t: "+ getIntent().getExtras().getString("lempar_byr_dt"));
        tvpjp.setText("Jenis Pembayaran \t: "+ getIntent().getExtras().getString("lempar_byr_jenis"));
        tvpbp.setText("Nama Bank \t\t\t: "+ getIntent().getExtras().getString("lempar_byr_bank"));
        tvpnva.setText("No Virtual Account : "+ getIntent().getExtras().getString("lempar_byr_ac"));
        tvpan.setText("Atas Nama \t\t\t: "+ getIntent().getExtras().getString("lempar_byr_nama"));
        tvpttl.setText("Total Yang harus di bayar : "+ getIntent().getExtras().getString("lempar_byr_total"));
        tvpjml.setText("Jumlah Bayar \t\t\t: "+ getIntent().getExtras().getString("lempar_byr_jmlh"));
    }

    private void jumlah_dp(){
        lyjmld1.setVisibility(View.GONE);
        lyjmld2.setVisibility(View.GONE);
        lyjmld3.setVisibility(View.GONE);


        String strjml1p = getIntent().getExtras().getString("lempar_byr_tiket1");
        String strjml2p = getIntent().getExtras().getString("lempar_byr_tiket2");
        String strjml3p = getIntent().getExtras().getString("lempar_byr_tiket3");

        if (!strjml1p.equals("0")){
            lyjmld1.setVisibility(View.VISIBLE);
            tvjml1p.setText(strjml1p);
        }
        if (!strjml2p.equals("0")){
            lyjmld2.setVisibility(View.VISIBLE);
            tvjml2p.setText(strjml2p);
        }
        if (!strjml3p.equals("0")){
            lyjmld3.setVisibility(View.VISIBLE);
            tvjml3p.setText(strjml3p);
        }
    }
}