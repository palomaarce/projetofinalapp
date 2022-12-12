package com.example.projetofinal.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.projetofinal.R;

public class TelaPrincipalActivity extends AppCompatActivity {
    CardView cvReceitas;
    CardView cvCardapio;
    CardView cvContador;
    Button button3;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_principal);
        cvReceitas = findViewById(R.id.cvReceitas);
        cvCardapio = findViewById(R.id.cvCardapio);
        //cvContador = findViewById(R.id.cvContador);




        cvCardapio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TelaPrincipalActivity.this, ListaCardapioActivity.class);
                startActivity(intent);
            }
        });

        cvReceitas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //new inten
                Intent intent = new Intent(TelaPrincipalActivity.this, ListaReceitasActivity.class);
                startActivity(intent);
            }
        });
    }
}