package com.example.projetofinal.repository;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class BancoController {
    private SQLiteDatabase db;
    private CriaBanco banco;

    public BancoController(Context contexto) {
        banco = new CriaBanco(contexto);
    }

    public String inserirDados(String titulo, String ingredientes, String modoPreparo){

        ContentValues valores;
        long resultado;

        db = banco.getWritableDatabase();
        valores = new ContentValues();
        valores.put(CriaBanco.NOME, titulo);
        valores.put(CriaBanco.INGREDIENTES, ingredientes);
        valores.put(CriaBanco.MODOPREPARO, modoPreparo);
        //valores.put(CriaBanco.IDREFEICAO, idRefeicao);

        resultado = db.insert(CriaBanco.TABELA, null, valores);
        db.close();

        if (resultado ==-1) {
            return "Erro ao inserir registro";
        } else {
            return "Registro inserido com sucesso";
        }

    }

    public Cursor carregaDados(){
        Cursor cursor;
        String[] campos =  {banco.NOME,banco.INGREDIENTES, banco.MODOPREPARO};
        db = banco.getReadableDatabase();
        cursor = db.query(banco.TABELA, campos, null, null, null, null, null, null);

        if(cursor!=null){
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }


    }


