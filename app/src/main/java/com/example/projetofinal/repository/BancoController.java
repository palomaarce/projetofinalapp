package com.example.projetofinal.repository;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class BancoController {
    private SQLiteDatabase db;
    private CriaBanco banco;

    public BancoController(Context contexto) {
        banco = new CriaBanco(contexto);
    }

    public String inserirDados(int id, String titulo, String ingredientes, String modoPreparo){

        ContentValues valores;
        long resultado;

        db = banco.getWritableDatabase();
        valores = new ContentValues();
        valores.put(CriaBanco.NOME, titulo);
        valores.put(CriaBanco.INGREDIENTES, ingredientes);
        valores.put(CriaBanco.MODOPREPARO, modoPreparo);

        resultado = db.insert(CriaBanco.TABELA, null, valores);
        db.close();

        if (resultado ==-1) {
            return "Erro ao inserir registro";
        } else {
            return "Registro inserido com sucesso";
        }

    }

    }


