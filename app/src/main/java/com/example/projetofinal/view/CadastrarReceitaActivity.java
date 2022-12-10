package com.example.projetofinal.view;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.projetofinal.R;
import com.example.projetofinal.model.Refeicao;
import com.example.projetofinal.repository.BancoController;

import java.util.ArrayList;
import java.util.List;

public class CadastrarReceitaActivity extends AppCompatActivity {
    EditText tituloReceita;
    EditText ingredientesReceita;
    EditText modoPreparoReceita;
    Button btnCadastrar;
    Spinner spinnerDropdown;
    //ListaCardapioActivity listaCardapio;
    List<String> refeicoes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_receita);

        tituloReceita = findViewById(R.id.etTituloReceita);
        ingredientesReceita = findViewById(R.id.etIngredientes);
        modoPreparoReceita = findViewById(R.id.etModoPreparo);
        btnCadastrar = findViewById(R.id.btnCadastrarReceita);
        spinnerDropdown = findViewById(R.id.spRefeicoes);
        //listaCardapio = new ListaCardapioActivity();
        refeicoes = new ArrayList<>();
        refeicoes.add("Café da manhã");
        refeicoes.add("Lanche da manhã");
        refeicoes.add( "Almoço");
        refeicoes.add("Café da tarde");
        refeicoes.add("Lanche da tarde");
        refeicoes.add("Jantar");


        //refeicoes = listaCardapio.getRefeicoes();
        Log.d(TAG, "onCreate: " + refeicoes.get(1) + " - size " + refeicoes.size());
        Log.e(TAG, "onCreate: " + refeicoes.get(1) + " - size " + refeicoes.size());
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, refeicoes);
        spinnerDropdown.setAdapter(adapter);




                btnCadastrar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        int id = 0;
                        id++;
                        BancoController controller = new BancoController(getBaseContext());
                        String titulo = tituloReceita.getText().toString();
                        String ingredientes = ingredientesReceita.getText().toString();
                        String modoPreparo = modoPreparoReceita.getText().toString();
                        int idRefeicao = (int) spinnerDropdown.getSelectedItemId();


                        String resultado;
                        resultado = controller.inserirDados(titulo, ingredientes, modoPreparo);
                        Toast.makeText(getApplicationContext(), resultado, Toast.LENGTH_LONG).show();

                        Toast.makeText(getApplicationContext(), "A opção clicada foi " + idRefeicao +
                                " na posição ", Toast.LENGTH_LONG).show();


                    }
                });

    }
}