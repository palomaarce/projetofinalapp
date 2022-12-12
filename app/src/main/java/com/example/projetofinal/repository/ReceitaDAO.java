package com.example.projetofinal.repository;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.projetofinal.model.Receita;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ReceitaDAO {
    private Connection conexao;
    private SQLiteDatabase banco;

    public ReceitaDAO(Context contexto) {
        conexao = new Connection(contexto);
        banco = conexao.getWritableDatabase();
    }

    public long inserir(Receita receita){
        ContentValues values = new ContentValues();
        values.put("titulo", receita.getNome());
        values.put("ingredientes", receita.getIngredientes());
        values.put("modoPreparo", receita.getModoPreparo());
        values.put("refeicao", receita.getRefeicao());
        System.out.println("refeição inserida foi: " + receita.getRefeicao());
        return banco.insert("receita", null, values);
    }

    public List<Receita> obterTodos(){
        List<Receita> receitas = new ArrayList<>();
        Cursor cursor = banco.query("receita", new String[]{"id", "titulo", "ingredientes", "modoPreparo", "refeicao"},
                null, null, null, null, null);
        while(cursor.moveToNext()){
            Receita r = new Receita();
            r.setId(cursor.getInt(0));
            r.setNome(cursor.getString(1));
            r.setIngredientes(cursor.getString(2));
            r.setModoPreparo(cursor.getString(3));
            r.setRefeicao(cursor.getString(4));
            receitas.add(r);
        }
        return receitas;

    }

    public List<Receita> obterReceitasPorRefeicao(String refeicao){
        List<Receita> receitasFiltradas = new ArrayList<>();
        List<Receita> receitasTotal = obterTodos();
        for(Receita r: receitasTotal){
            System.out.println("Titulo receita " + r.getNome());
            System.out.println("Ingredientes receita " + r.getIngredientes());
            System.out.println("Modo de preparo receita " + r.getModoPreparo());
            System.out.println("Refeição receita " + r.getRefeicao());
            System.out.println("Refeição objeto =  " + r.getRefeicao() + " e refeição selecionada " + refeicao);
            if(r.getRefeicao() != null && r.getRefeicao().contains(refeicao)){
                 receitasFiltradas.add(r);
            }

        }

        return receitasFiltradas;


    }

    public Receita obterReceitaPeloNome(String nome){
        List<Receita> receitasTotal = obterTodos();
        Receita receita = new Receita();
        for(Receita r: receitasTotal){
            if(r.getNome()!= null && r.getNome().contains(nome)){
                receita = r;

            }
        }
        return receita;

    }


}
