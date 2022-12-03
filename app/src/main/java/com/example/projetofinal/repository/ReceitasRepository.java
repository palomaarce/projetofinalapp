package com.example.projetofinal.repository;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.projetofinal.model.Receita;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ReceitasRepository implements Response.Listener<JSONArray>, Response.ErrorListener {
    private final String TAG = "ReceitasRepository";
    private List<Receita> receitas;
    private static ReceitasRepository instance;
    private Context contexto;
    private OnReadyListener onReadyListener;

    public ReceitasRepository(Context contexto) {
        this.contexto = contexto;
        receitas = new ArrayList<>();
        RequestQueue queue = Volley.newRequestQueue(contexto);
        //usando o proprio objeto como ResponseListener
        JsonArrayRequest jaRequest = new JsonArrayRequest(Request.Method.GET,
                "https://raw.githubusercontent.com/adrianosferreira/afrodite.json/master/afrodite.json",
                null, this, this);
        queue.add(jaRequest);

        Log.e(TAG, "Receitas repository: lançado" );
    }

    public static ReceitasRepository getInstance() {
        return instance;

    }

    public static ReceitasRepository getInstance(Context contexto, OnReadyListener orl) {
        if (instance == null) {
            instance = new ReceitasRepository(contexto);
            instance.onReadyListener = orl;

        }
        if (!instance.getReceitas().isEmpty()) {
            if (orl != null) {
                orl.onReady();
                instance.onReadyListener = null;
            }
        }
        return instance;
    }

    public Receita createUserFromJson(JSONObject json) {
        try {
            return new Receita(json.getString("id"), json.getString("nome"),
                    json.getString("ingredientes"), json.getString("modoPreparo"));
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Receita> getReceitas() {
        return receitas;
    }

    @Override
    public void onResponse(JSONArray response) {
        Log.e(TAG, "onResponse: "+response.length());
        for (int i = 0; i < response.length(); i++) {
            try {
                JSONObject json = response.getJSONObject(i);
                Log.d(TAG, "onResponse: "+json.toString());
                receitas.add( new Receita(json.getString("id"), json.getString("nome"),
                        json.getString("ingredientes"), json.getString("modoPreparo")));
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
        if (onReadyListener != null) {
            onReadyListener.onReady();
        }
        onReadyListener = null;
        Log.e(TAG, "onResponse: terminei" );

    }

    @Override
    public void onErrorResponse(VolleyError error) {
        Log.e(TAG, "onErrorResponse: "+error.getMessage() );

    }
}
