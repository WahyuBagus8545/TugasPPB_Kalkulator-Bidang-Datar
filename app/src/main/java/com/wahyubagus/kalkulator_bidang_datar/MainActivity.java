package com.wahyubagus.kalkulator_bidang_datar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    // Mendefinisikan Variable element
    private EditText etAngka1, etAngka2;
    private Button btPersegi, btSegitiga, btLingkaran;
    private TextView tvDisclaimer, tvHasilK,tvHasilL;

    // Variable

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // mendaftarkan element
        etAngka1 = findViewById(R.id.etAngka1);
        etAngka2 = findViewById(R.id.etAngka2);
        btPersegi = findViewById(R.id.btPersegi);
        btSegitiga = findViewById(R.id.btSegitiga);
        btLingkaran = findViewById(R.id.btLingkaran);
        tvDisclaimer = findViewById(R.id.tvDisclaimer);
        tvHasilK = findViewById(R.id.tvHasilK);
        tvHasilL = findViewById(R.id.tvHasilL);

        btPersegi.setOnClickListener(new View.OnClickListener() {
            private void doNothing() {

            }
            @Override
            public void onClick(View view) {
                if (!etAngka1.getText().toString().trim().equalsIgnoreCase("") && !etAngka2.getText().toString().trim().equalsIgnoreCase("")){
                    tvDisclaimer.setVisibility(View.VISIBLE);
                    tvHasilK.setText("" + "Keliling : " + "2*"+etAngka1.getText().toString().trim() + " + " + "2*"+etAngka2.getText().toString().trim() + " = " + hitungCalculator(Double.parseDouble(etAngka1.getText().toString().trim()), Double.parseDouble(etAngka2.getText().toString().trim()), "kelilingPersegi"));
                    tvHasilL.setText("" + "Luas : " +etAngka1.getText().toString().trim() + " * " +etAngka2.getText().toString().trim() + " = " + hitungCalculator(Double.parseDouble(etAngka1.getText().toString().trim()), Double.parseDouble(etAngka2.getText().toString().trim()), "luasPersegi"));
                    tvHasilK.setVisibility(View.VISIBLE);
                    tvHasilL.setVisibility(View.VISIBLE);
                    etAngka2.setText("");
                }else {
                    Toast.makeText(MainActivity.this, "Harap lengkapi isian yang tersedia !", Toast.LENGTH_LONG).show();
                }
            }
        });

        btSegitiga.setOnClickListener(new View.OnClickListener() {
            private void doNothing() {

            }
            @Override
            public void onClick(View view) {
                if (!etAngka1.getText().toString().trim().equalsIgnoreCase("") && !etAngka2.getText().toString().trim().equalsIgnoreCase("")){
                    tvDisclaimer.setVisibility(View.VISIBLE);
                    tvHasilK.setText("" + "Keliling : "+ etAngka1.getText().toString().trim() + " + " + etAngka2.getText().toString().trim() + "+ c" + " = " + hitungCalculator(Double.parseDouble(etAngka1.getText().toString().trim()), Double.parseDouble(etAngka2.getText().toString().trim()), "kelilingSegitiga"));
                    tvHasilL.setText("" + "Luas : "+ " ("+etAngka1.getText().toString().trim() + " * " + etAngka2.getText().toString().trim() + ") /2" + " = " + hitungCalculator(Double.parseDouble(etAngka1.getText().toString().trim()), Double.parseDouble(etAngka2.getText().toString().trim()), "luasSegitiga"));
                    tvHasilK.setVisibility(View.VISIBLE);
                    tvHasilL.setVisibility(View.VISIBLE);
                    etAngka1.setText("");
                    etAngka2.setText("");
                }else {
                    Toast.makeText(MainActivity.this, "Harap lengkapi isian yang tersedia !", Toast.LENGTH_LONG).show();
                }
            }
        });

        btLingkaran.setOnClickListener(new View.OnClickListener() {
            private void doNothing() {

            }
            @Override
            public void onClick(View view) {
                if (!etAngka1.getText().toString().trim().equalsIgnoreCase("") && !etAngka2.getText().toString().trim().equalsIgnoreCase("")){
                    tvDisclaimer.setVisibility(View.VISIBLE);
                    tvHasilK.setText("" + "Keliling : "+ "2*π*"+etAngka1.getText().toString().trim() +  " = " + hitungCalculator(Double.parseDouble(etAngka1.getText().toString().trim()), Double.parseDouble(etAngka1.getText().toString().trim()), "kelilingLingkaran"));
                    tvHasilL.setText("" + "luas : "+ "π*"+etAngka1.getText().toString().trim() + "*" + etAngka1.getText().toString().trim() + " = " + hitungCalculator(Double.parseDouble(etAngka1.getText().toString().trim()), Double.parseDouble(etAngka1.getText().toString().trim()), "luasLingkaran"));
                    tvHasilK.setVisibility(View.VISIBLE);
                    tvHasilL.setVisibility(View.VISIBLE);
                    etAngka1.setText("");
                    etAngka2.setText("");
                }else {
                    Toast.makeText(MainActivity.this, "Harap lengkapi isian yang tersedia !", Toast.LENGTH_LONG).show();
                }
            }
        });




    }

    private double hitungCalculator(double angka1, double angka2, String sOperator){
        if (sOperator.equalsIgnoreCase("kelilingPersegi")){
            return 2*angka1 + 2*angka2;
        }else if (sOperator.equalsIgnoreCase("luasPersegi")){
            return angka1 * angka2;
        }else if (sOperator.equalsIgnoreCase("kelilingSegitiga")){
            return angka1 + angka2 + (Math.sqrt(Math.pow(angka1, 2) + Math.pow(angka2, 2)));
        }else if (sOperator.equalsIgnoreCase("luasSegitiga")){
            return (angka1 * angka2)/2;
        }else if (sOperator.equalsIgnoreCase("kelilingLingkaran")){
            return 2*Math.PI*angka1;
        }else if (sOperator.equalsIgnoreCase("LuasLingkaran")){
            return Math.PI*angka1*angka1;
        }else{
            return 0;
        }
    }
}