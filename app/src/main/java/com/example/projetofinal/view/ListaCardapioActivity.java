package com.example.projetofinal.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.projetofinal.R;
import com.example.projetofinal.adapter.RefeicaoAdapter;
import com.example.projetofinal.model.Refeicao;

import java.util.ArrayList;

public class ListaCardapioActivity extends AppCompatActivity {
    private RecyclerView rcRefeicoes;
    private RefeicaoAdapter adapter;
    private ArrayList<Refeicao> refeicoes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_cardapio);
        rcRefeicoes = findViewById(R.id.rcRefeicoes);
        refeicoes = new ArrayList<Refeicao>();
        refeicoes.add(new Refeicao("1", "Café da manhã", "A refeição mais importante do dia"));
        refeicoes.add(new Refeicao("2", "Lanche da manhã", "A refeição mais importante do dia"));
        refeicoes.add(new Refeicao("3", "Almoço", "Essencial para o seu desempenho ao longo do dia"));
        refeicoes.add(new Refeicao("4", "Café da tarde", "Momento para recarregar as energias"));
        refeicoes.add(new Refeicao("5", "Lanche da tarde", "A refeição mais importante do dia"));
        refeicoes.add(new Refeicao("6", "Jantar", "Refeição repleta de nutrientes"));
        //implementar o sql lite para cadastrar receitas
        adapter = new RefeicaoAdapter(ListaCardapioActivity.this, refeicoes);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(ListaCardapioActivity.this, LinearLayoutManager.VERTICAL,false);
        rcRefeicoes.setLayoutManager(layoutManager);
        rcRefeicoes.setAdapter(adapter);
    }
}