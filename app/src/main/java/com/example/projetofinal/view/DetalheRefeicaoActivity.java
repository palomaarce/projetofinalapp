package com.example.projetofinal.view;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

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

    ImageButton cadastrarReceita;


    @SuppressLint({"WrongViewCast", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_refeicao);
        tvNomeReceitaRefeicao = findViewById(R.id.tvNomeReceitaRefeicao);
        cadastrarReceita = findViewById(R.id.imageButton);


        Intent intent = getIntent();
        String nomeRefeicao = intent.getStringExtra("nomeRefeicao");
        tvNomeReceitaRefeicao.setText("Receitas para " + nomeRefeicao);
        lista = findViewById(R.id.listViewReceitas);
        dao = new ReceitaDAO(this);
        receitas = dao.obterReceitasPorRefeicao(nomeRefeicao);
        ArrayAdapter<Receita> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, receitas);
        lista.setAdapter(adapter);



        cadastrarReceita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(DetalheRefeicaoActivity.this, CadastrarReceitaActivity.class);
                startActivity(intent2);
            }
        });

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(DetalheRefeicaoActivity.this, "Clicou na receita " + ((TextView) view).getText(), Toast.LENGTH_SHORT).show();
                System.out.println("clicou na receita " + ((TextView) view).getText());
                Intent intent = new Intent(DetalheRefeicaoActivity.this, DetalheReceitaActivity.class);
                intent.putExtra("nomeReceita", ((TextView) view).getText());
                intent.putExtra("activityName", "DetalheRefeicaoActivity");
                startActivity(intent);

            }
        });


    }


}