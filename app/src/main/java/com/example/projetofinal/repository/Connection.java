package com.example.projetofinal.repository;

import static android.content.ContentValues.TAG;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class Connection extends SQLiteOpenHelper {
    private static final String name = "banco";
    private static final int version=2;


    public Connection(@Nullable Context context) {
        super(context, name, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table receita(id integer primary key autoincrement, " +
                "titulo varchar(100), ingredientes varchar(250), modoPreparo varchar(250), refeicao varchar(200))");

        db.execSQL("create table receitas(id integer primary key autoincrement, " +
                "titulo varchar(100), ingredientes varchar(250), modoPreparo varchar(250), refeicao varchar(200))");
        System.out.println("Tabela criada");
        Log.d(TAG, "deletaTabela: tabela criada");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        String sql = "DROP TABLE IF EXISTS receita;";
        System.out.println("Tabela removida");
        Log.d(TAG, "deletaTabela: tabela removida");

        db.execSQL(sql);

    }

    public void deletaTabela() {


        SQLiteDatabase db = getWritableDatabase();
        String sql = "DROP TABLE IF EXISTS receita;";
        System.out.println("Tabela removida");
        Log.d(TAG, "deletaTabela: tabela removida");

        db.execSQL(sql);
    }
}
