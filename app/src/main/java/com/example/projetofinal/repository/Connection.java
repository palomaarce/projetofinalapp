package com.example.projetofinal.repository;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Connection extends SQLiteOpenHelper {
    private static final String name = "banco";
    private static final int version=1;


    public Connection(@Nullable Context context) {
        super(context, name, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table receita(id integer primary key autoincrement, " +
                "titulo varchar(100), ingredientes varchar(250), modoPreparo varchar(250), refeicao varchar(200))");

        db.execSQL("create table receitas(id integer primary key autoincrement, " +
                "titulo varchar(100), ingredientes varchar(250), modoPreparo varchar(250), refeicao varchar(200))");


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
