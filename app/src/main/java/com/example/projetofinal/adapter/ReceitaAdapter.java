package com.example.projetofinal.adapter;

import static android.content.ContentValues.TAG;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projetofinal.R;
import com.example.projetofinal.model.Receita;

import java.util.List;

public class ReceitaAdapter extends RecyclerView.Adapter {
    LayoutInflater inflater;
    List<Receita> receitas;

    public ReceitaAdapter(Context ctx, List<Receita> receitas){
        this.inflater = LayoutInflater.from(ctx);
        this.receitas = receitas;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.receita_tem_activity, parent, false);

        return new ReceitaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Receita receita = receitas.get(position);
        TextView nomeReceita = holder.itemView.findViewById(R.id.tvNomeReceita);
        nomeReceita.setText(receita.getNome());
        //TextView titulo = holder.itemView.findViewById(R.id.tvTitle);
        //titulo.setText(album.getTitle());
    }

    @Override
    public int getItemCount() {
        return receitas.size();
    }
}

class ReceitaViewHolder extends RecyclerView.ViewHolder{
    TextView nomeReceita;

    public ReceitaViewHolder(@NonNull View itemView) {
        super(itemView);
        nomeReceita = itemView.findViewById(R.id.tvNomeReceita);
        nomeReceita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: " + nomeReceita.getText());
            }
        });
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: clicou na opção " + view);
            }
        });
    }
}
