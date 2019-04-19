package com.example.zayano.bbi;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText t,nama;
    Button cek,exit,mButton;
    Bundle dataExtra;
    private Spinner spinner1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mButton = (Button) findViewById(R.id.button2);
        nama = (EditText) findViewById(R.id.editText2);
        t = (EditText) findViewById(R.id.editText);
        cek = (Button) findViewById(R.id.button);
        spinner1 = (Spinner) findViewById(R.id.spinner);
        dataExtra = getIntent().getExtras();
        exit = (Button) findViewById(R.id.keluar);

        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id){
                String kelamin = String.valueOf(parentView.getSelectedItem());
                Toast.makeText(getApplication(), "Jenis Kelamin Anda " + kelamin, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView){
            }
        });

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent tips = new Intent(MainActivity.this,TipsMenjaga.class);
                startActivity(tips);
            }
        });

        cek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (nama.length() == 0 && t.length() == 0){
                    Toast.makeText(getApplication(),"Nama dan Tinggi Badan tidak Boleh Kosong",Toast.LENGTH_SHORT).show();
                }
                if (nama.length() == 0) {
                    Toast.makeText(getApplication(),"Nama tidak Boleh Kosong", Toast.LENGTH_SHORT).show();
                }
                if (t.length() == 0) {
                    Toast.makeText(getApplication(),"Tinggi Badan tidak Boleh Kosong", Toast.LENGTH_SHORT).show();
                }

            else{

                int tb = Integer.parseInt(t.getText().toString());
                final int bbi = (tb - 100) * 90 / 100;

                Intent intent = new Intent(MainActivity.this, hasil.class);
                intent.putExtra("nama", nama.getText().toString());
                intent.putExtra("tinggi", t.getText().toString());
                intent.putExtra("kelamin", String.valueOf(spinner1.getSelectedItem()));
                intent.putExtra("hasil", Integer.toString(bbi));
                startActivity(intent);
            }
        }
        });

        exit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View view) {
                AlertDialog.Builder alertexit = new AlertDialog.Builder(MainActivity.this);
                alertexit.setMessage("Apa Anda ingin Keluar?")
                        .setTitle("Keluar")
                        .setCancelable(false)
                        .setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                System.exit(0);
                            }
                        }).setNegativeButton("Tidak",
                                    new AlertDialog.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog,
                                                        int which) {dialog.cancel();
                                    }
                                });
                AlertDialog a = alertexit.create();
                a.show();
            }
        });
    }
}



