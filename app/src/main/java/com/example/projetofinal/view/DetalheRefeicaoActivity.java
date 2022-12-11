package com.example.projetofinal.view;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.projetofinal.R;
import com.example.projetofinal.model.Receita;
import com.example.projetofinal.repository.ReceitaDAO;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class DetalheRefeicaoActivity extends AppCompatActivity {
    TextView tvNomeReceitaRefeicao;
    ListView lista;
    ReceitaDAO dao;
    List<Receita> receitas;
    List<Receita> receitasFiltrados = new ArrayList<>();

    @SuppressLint({"WrongViewCast", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_refeicao);
        tvNomeReceitaRefeicao = findViewById(R.id.tvNomeReceitaRefeicao);

        Intent intent = getIntent();
        //String nomeRefeicao = intent.getStringExtra("nomeRefeicao");
        //tvNomeReceitaRefeicao.setText(nomeRefeicao);
        lista = findViewById(R.id.listViewReceitas);
        dao = new ReceitaDAO(this);
        receitas = dao.obterTodos();
        ArrayAdapter<Receita> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, receitas);
        lista.setAdapter(adapter);


    }
}