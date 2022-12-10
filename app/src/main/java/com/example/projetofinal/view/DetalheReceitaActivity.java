package com.example.projetofinal.view;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.projetofinal.R;
import com.example.projetofinal.adapter.ReceitaAdapter;
import com.example.projetofinal.repository.ReceitasRepository;

public class DetalheReceitaActivity extends AppCompatActivity {
    TextView tvDetalheNomeReceita;
    TextView tvDetalheReceita;
    TextView tvModoPreparo;
    ReceitaAdapter adapter;
    ListaReceitasActivity lista;
    ImageView back;
    ImageView share;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_receita);
        tvDetalheNomeReceita = findViewById(R.id.tvDetalheNomeReceita);
        tvDetalheReceita = findViewById(R.id.tvDetalheReceita);
        tvModoPreparo = findViewById(R.id.tvModoPreparo);

        back = findViewById(R.id.image_logoBack);
        share = findViewById(R.id.image_logoShare);


        //Pega a intent de outra activity
        Intent intent = getIntent();


        //Recuperei a string da outra activity
        String nomeReceita = intent.getStringExtra("nomeReceita");
        tvDetalheNomeReceita.setText(nomeReceita);
        String ingredientes = ReceitasRepository.getReceitaByNome(nomeReceita).getIngredientes();
        //ReceitasRepository.getReceitaByNome(nomeReceita).get

        String modoPrepado = ReceitasRepository.getReceitaByNome(nomeReceita).getModoPreparo();

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



        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(DetalheReceitaActivity.this, ListaReceitasActivity.class);
                startActivity(intent2);
            }
        });

        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, nomeReceita + "\n Ingredientes: \n " + ingredientes + "\n Modo de preparo: " + modoPrepado);
                sendIntent.setType("text/plain");

                Intent shareIntent = Intent.createChooser(sendIntent, null);
                startActivity(shareIntent);

            }
        });

    }
}