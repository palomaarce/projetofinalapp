package com.example.projetofinal.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projetofinal.R;
import com.example.projetofinal.model.Refeicao;

import java.util.ArrayList;

public class RefeicaoAdapter extends RecyclerView.Adapter {
    private Context context;
    private ArrayList<Refeicao> refeicoes;

    public RefeicaoAdapter(Context context, ArrayList<Refeicao> refeicoes) {
        this.context = context;
        this.refeicoes = refeicoes;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.refeicao_item_activity, parent, false);
        RefeicaoViewHolder viewHolder = new RefeicaoViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Refeicao refeicao = refeicoes.get(position);
        TextView nome = holder.itemView.findViewById(R.id.tvRefeicao);
        nome.setText(refeicao.getNome());
        TextView descricao = holder.itemView.findViewById(R.id.tvDescricaoRefeicao);
        descricao.setText(refeicao.getDescricao());

    }

    @Override
    public int getItemCount() {
        return refeicoes.size();
    }
}

class RefeicaoViewHolder extends RecyclerView.ViewHolder {
    TextView nome;
    TextView descricao;

    public RefeicaoViewHolder(@NonNull View itemView) {
        super(itemView);
        nome = itemView.findViewById(R.id.tvRefeicao);
        descricao = itemView.findViewById(R.id.tvDescricaoRefeicao);
    }
}
