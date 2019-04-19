package com.example.zayano.bbi;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class hasil extends AppCompatActivity {

    TextView nama,tinggi,bbi,kelamin;
    Bundle dataExtra;
    String NAMA,TINGGI,HASIL,KELAMIN;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil);

        nama = (TextView) findViewById(R.id.textView15);
        tinggi = (TextView) findViewById(R.id.textView17);
        bbi = (TextView) findViewById(R.id.textView18);
        kelamin = (TextView) findViewById(R.id.textView16);
        dataExtra = getIntent().getExtras();

        NAMA = dataExtra.getString("nama");
        TINGGI = dataExtra.getString("tinggi");
        HASIL = dataExtra.getString("hasil");
        KELAMIN = dataExtra.get("kelamin").toString();

        nama.setText(NAMA);
        tinggi.setText(TINGGI+" CM");
        bbi.setText(HASIL+" KG");
        kelamin.setText(KELAMIN);

        ActionBar cek = getSupportActionBar();
        cek.setDisplayShowHomeEnabled(true);
        cek.setDisplayHomeAsUpEnabled(true);
    }
}
