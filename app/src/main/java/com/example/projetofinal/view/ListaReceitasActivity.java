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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ListaReceitasActivity extends AppCompatActivity {
    RecyclerView recycler;
    List<Receita> receitas;
    private static String JSON_URL="https://raw.githubusercontent.com/adrianosferreira/afrodite.json/master/afrodite.json ";
    ReceitaAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_receitas);

        recycler = findViewById(R.id.rcReceitas);
        receitas = new ArrayList<>();

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
                        receita.setId("1");
                        receita.setNome(receitaObjeto.getString("nome"));
                        receita.setIngredientes("teste");
                        receita.setModoPreparo("teste");
                        receitas.add(receita);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }


                }
                recycler.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));
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
}