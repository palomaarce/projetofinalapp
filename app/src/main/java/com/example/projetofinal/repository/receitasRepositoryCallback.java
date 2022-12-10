package com.example.projetofinal.repository;

import android.content.Context;

import com.example.projetofinal.model.Receita;

import java.util.List;

public interface receitasRepositoryCallback {



        public Context getContexto();

        public void onLoad(List<Receita> receitas);




}
