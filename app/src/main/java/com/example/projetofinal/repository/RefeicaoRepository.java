package com.example.projetofinal.repository;

import com.example.projetofinal.model.Refeicao;

import java.util.ArrayList;
import java.util.List;

public class RefeicaoRepository {
    private List<Refeicao> refeicoes;
    private static RefeicaoRepository instance;

    private RefeicaoRepository(){
        super();
        refeicoes = new ArrayList<>();
        refeicoes.add(new Refeicao("1", "Café da manhã", "A refeição mais importante do dia"));
        refeicoes.add(new Refeicao("2", "Lanche da manhã", "A refeição mais importante do dia"));
        refeicoes.add(new Refeicao("3", "Almoço", "Essencial"));
        refeicoes.add(new Refeicao("4", "Café da tarde", "Momento para recarregar as energias"));
        refeicoes.add(new Refeicao("5", "Lanche da tarde", "A refeição mais importante do dia"));
        refeicoes.add(new Refeicao("6", "Jantar", "Refeição repleta de nutrientes"));
    }

    public static RefeicaoRepository getInstance() {

        instance = new RefeicaoRepository();
        return instance;
    }

    public List<Refeicao> getRefeicoes() {
        return refeicoes;
    }

    public Refeicao getRefeicaoById(String id) {
        Refeicao ref = null;
        for(Refeicao r : refeicoes) {
            if (r.getId() == id) {
                ref = r;
            }
        }
        return ref;
    }



}
