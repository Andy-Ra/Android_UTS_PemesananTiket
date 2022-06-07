package com.ivan_andy_ramadhan.utsa.ticketbox;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

public class Official extends AppCompatActivity {
WebView webofc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_official);
        setTitle("Official Website");
        webofc = findViewById(R.id.wv_off);
        webofc.loadUrl("https://www.lovelive-anime.jp/uranohoshi/");
    }
}