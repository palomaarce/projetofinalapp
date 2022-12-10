package com.example.projetofinal.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.projetofinal.R;

import org.w3c.dom.Text;

public class DetalheRefeicaoActivity extends AppCompatActivity {
    TextView tvNomeReceitaRefeicao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_refeicao);
        tvNomeReceitaRefeicao = findViewById(R.id.tvNomeReceitaRefeicao);

        Intent intent = getIntent();
        String nomeRefeicao = intent.getStringExtra("nomeRefeicao");
        tvNomeReceitaRefeicao.setText(nomeRefeicao);

    }
}