package com.example.projetofinal.repository;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.projetofinal.model.Receita;

import java.util.ArrayList;
import java.util.List;

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
        //values.put("refeicao", receita.getRefeicao());
        return banco.insert("receita", null, values);
    }

    public List<Receita> obterTodos(){
        List<Receita> receitas = new ArrayList<>();
        Cursor cursor = banco.query("receita", new String[]{"id", "titulo", "ingredientes", "modoPreparo"},
                null, null, null, null, null);
        while(cursor.moveToNext()){
            Receita r = new Receita();
            r.setId(cursor.getInt(0));
            r.setNome(cursor.getString(1));
            r.setIngredientes(cursor.getString(2));
            r.setModoPreparo(cursor.getString(3));
            //r.setRefeicao(cursor.getString(4));
            receitas.add(r);
        }
        return receitas;

    }
}
