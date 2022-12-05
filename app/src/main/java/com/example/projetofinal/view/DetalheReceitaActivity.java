package com.example.projetofinal.view;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.projetofinal.R;
import com.example.projetofinal.adapter.ReceitaAdapter;

public class DetalheReceitaActivity extends AppCompatActivity {
    TextView tvDetalheNomeReceita;
    TextView tvDetalheReceita;
    TextView tvModoPreparo;
    ReceitaAdapter adapter;
    ListaReceitasActivity lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_receita);
        tvDetalheNomeReceita = findViewById(R.id.tvDetalheNomeReceita);
        tvDetalheReceita = findViewById(R.id.tvDetalheReceita);
        tvModoPreparo = findViewById(R.id.tvModoPreparo);


        //Pega a intent de outra activity
        Intent intent = getIntent();


        //Recuperei a string da outra activity
        String nomeReceita = intent.getStringExtra("nomeReceita");
        tvDetalheNomeReceita.setText(nomeReceita);
        String ingredientes = ListaReceitasActivity.getReceitaByNome(nomeReceita).getIngredientes();

        String modoPrepado = ListaReceitasActivity.getReceitaByNome(nomeReceita).getModoPreparo();

        int auxiliar1 = ingredientes.indexOf("Ingredientes");
        int auxiliar2 = ingredientes.indexOf("]");

        String corte = ingredientes.substring(auxiliar1+26,auxiliar2-3);
        String[] valores = corte.split(",");

        Log.d(TAG, "onCreate: ingredientes " + valores + " modo de preparo: " + modoPrepado);

        String valoresJuntos="";
        for(int x=0; x< valores.length; x++){
            valoresJuntos += System.lineSeparator() + valores[x];

        }

        //tvDetalheReceita.setText(ListaReceitasActivity.getReceitaByNome(nomeReceita).getIngredientes());
        tvDetalheReceita.setText(valoresJuntos.replaceAll("\"", ""));
        
        int auxiliar3 = modoPrepado.indexOf("Modo de Preparo");
        int auxiliar4 = modoPrepado.indexOf("]", auxiliar3);
        String corte2 = modoPrepado.substring(auxiliar3+30, auxiliar4-3);
        String[] valores2 = corte2.split(",");
        String valoresJuntosPreparo="";
        for(int z=0; z<valores2.length; z++){
            valoresJuntosPreparo+= System.lineSeparator() + valores2[z];
        }

        tvModoPreparo.setText(valoresJuntosPreparo.replaceAll("\"", ""));

    }
}