package com.example.projetofinal.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.projetofinal.R;
import com.example.projetofinal.repository.BancoController;

public class CadastrarReceitaActivity extends AppCompatActivity {
    EditText tituloReceita;
    EditText ingredientesReceita;
    EditText modoPreparoReceita;
    Button btnCadastrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_receita);

        tituloReceita = findViewById(R.id.etTituloReceita);
        ingredientesReceita = findViewById(R.id.etIngredientes);
        modoPreparoReceita = findViewById(R.id.etModoPreparo);
        btnCadastrar = findViewById(R.id.btnCadastrarReceita);

        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id=0;
                id++;
                BancoController controller = new BancoController(getBaseContext());
                String titulo = tituloReceita.getText().toString();
                String ingredientes = ingredientesReceita.getText().toString();
                String modoPreparo = modoPreparoReceita.getText().toString();
                String resultado;
                resultado = controller.inserirDados(id,titulo, ingredientes, modoPreparo);
                Toast.makeText(getApplicationContext(), resultado, Toast.LENGTH_LONG).show();


            }
        });

    }
}