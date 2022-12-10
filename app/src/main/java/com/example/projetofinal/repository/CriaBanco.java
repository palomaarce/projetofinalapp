package com.example.projetofinal.repository;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class CriaBanco extends SQLiteOpenHelper {
    public static final String NOME_BANCO = "projetoFinal";
    public static final String TABELA = "receitas";
    public static final String ID = "ID";
    public static final String NOME = "NOME";
    public static final String INGREDIENTES = "INGREDIENTES";
    public static final String MODOPREPARO = "MODOPREPARO";
    public static final String IDREFEICAO = "IDREFEICAO";
    public static final int VERSAO = 1;

    public CriaBanco(@Nullable Context context) {
        super(context, NOME_BANCO, null, VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //criar o banco de dados
        String sql = "CREATE TABLE "+TABELA+"("
                //+ ID + " integer primary key autoincrement,"
                + NOME + " text,"
                + INGREDIENTES + " text,"
                + MODOPREPARO + " text" + ")";
        //+ IDREFEICAO + " text" + ")";
        sqLiteDatabase.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists" + TABELA);
        onCreate(sqLiteDatabase);

    }
}
