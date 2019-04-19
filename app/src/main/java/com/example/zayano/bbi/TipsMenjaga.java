package com.example.zayano.bbi;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class TipsMenjaga extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tips_menjaga);

        ActionBar cek = getSupportActionBar();
        cek.setDisplayShowHomeEnabled(true);
        cek.setDisplayHomeAsUpEnabled(true);
    }
}
