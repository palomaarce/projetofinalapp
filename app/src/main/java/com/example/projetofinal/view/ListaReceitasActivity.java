package com.example.projetofinal.view;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Adapter;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.projetofinal.R;
import com.example.projetofinal.adapter.ReceitaAdapter;
import com.example.projetofinal.model.Receita;
import com.example.projetofinal.repository.ReceitasRepository;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ListaReceitasActivity extends AppCompatActivity {
    RecyclerView recycler;
    public static List<Receita> receitas;
    private static String JSON_URL="https://raw.githubusercontent.com/adrianosferreira/afrodite.json/master/afrodite.json ";
    ReceitaAdapter adapter;
    //ReceitasRepository repository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate: Activity Lista de receitas iniciado");
        setContentView(R.layout.activity_lista_receitas);

        recycler = findViewById(R.id.rcReceitas);
        receitas = new ArrayList<>();

        //repository = new ReceitasRepository(this);

        //adapter = new ReceitaAdapter(getApplicationContext(), receitas);
        //adapter = new ReceitaAdapter(getApplicationContext(), ReceitasRepository.getInstance().getReceitas());
        //recycler.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));


        //recycler.setAdapter(adapter);


        extrairReceitas();


    }

    private void extrairReceitas() {


        RequestQueue queue = Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, JSON_URL, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject receitaObjeto = response.getJSONObject(i);
                        Receita receita = new Receita();
                        receita.setId(i);
                        receita.setNome(receitaObjeto.getString("nome"));
                        //receita.setIngredientes(receitaObjeto.getString("secao").);
                        String conteudo = receitaObjeto.getString("secao");
                        //int auxiliar = conteudo.indexOf("Ingredientes");
                        //int auxiliar2 = conteudo.indexOf("]");
                        //System.out.println("Auxiliar1 = " + auxiliar + " / auxiliar2 = " + auxiliar2);
                        //String ingredientes = conteudo.substring(auxiliar, auxiliar2);
                        receita.setIngredientes(receitaObjeto.getString("secao"));
                        receita.setModoPreparo(receitaObjeto.getString("secao"));
                        receitas.add(receita);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }


                }


                recycler.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));
                //adapter = new ReceitaAdapter(getApplicationContext(), receitas);
                adapter = new ReceitaAdapter(getApplicationContext(), receitas);

                recycler.setAdapter(adapter);




            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d(TAG, "onErrorResponse: " + error.getMessage());
            }

        });

        queue.add(jsonArrayRequest);
    }


    public static Receita getReceitaByNome(String nome) {
        Receita ret = null;
        for(int x=0; x<receitas.size(); x++) {
            if (receitas.get(x).getNome().equals(nome)) {
                ret = receitas.get(x);
            }
        }
        return ret;
    }
    /*
    public static Receita getReceitaByNome(String nome) {
        Receita rec = null;
        for(Receita r : receitas) {
            if (r.getNome() == nome) {
                rec = r;
            }
        }
        return rec;
    }*/
}