package com.ivan_andy_ramadhan.utsa.ticketbox;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class Daftar extends AppCompatActivity implements AdapterView.OnItemClickListener{
    ListView lvlist;
    ImageView iconlist;
    TextView txtlist;
    String slist[] = {"Aqours First Love Live! ～ Step! ZERO to ONE"
            ,"Aqours 2nd Love Live! ～ HAPPY PARTY TRAIN TOUR"
            ,"Aqours 3rd LoveLive! Tour ～ WONDERFUL STORIES"};
    int glist[] = {R.drawable.cover1, R.drawable.cover2, R.drawable.cover3};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar);
        setTitle("List Konser");

        lvlist = findViewById(R.id.lv_list);
        lvlist.setAdapter(new Pilih_ItemAdapter());
        lvlist.setOnItemClickListener((AdapterView.OnItemClickListener) this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int posisi, long id) {
        final String slpilih = (String) adapterView.getItemAtPosition(posisi);
        Intent pindah = new Intent(Daftar.this, JadwalKonser.class);
        pindah.putExtra("lempar_textlist", slpilih);
        pindah.putExtra("lempar_posisi", posisi);
        startActivity(pindah);
    }

    private class Pilih_ItemAdapter extends ArrayAdapter<String> {
        public Pilih_ItemAdapter(){
            super(Daftar.this, R.layout.activity_menulist, slist);
        }

        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup baris) {
            View cell = convertView;
            if(cell == null){
                LayoutInflater inflater = getLayoutInflater();
                cell = inflater.inflate(R.layout.activity_menulist, baris, false);
            }
            iconlist = cell.findViewById(R.id.img_menu);
            txtlist = cell.findViewById(R.id.txt_menu);
            iconlist.setScaleType(ImageView.ScaleType.FIT_XY);

            iconlist.setImageResource(glist[position]);
            txtlist.setText(slist[position]);
            return cell;
        }
    }
}