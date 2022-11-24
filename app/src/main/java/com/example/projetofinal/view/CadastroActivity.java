package com.example.projetofinal.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.projetofinal.R;
import com.example.projetofinal.presenter.LoginPresenter;
import com.example.projetofinal.presenter.LoginPresenterContract;

public class CadastroActivity extends AppCompatActivity implements LoginPresenterContract.view{
    EditText nome;
    EditText email;
    EditText telefone;
    EditText senha;
    Button btnCadastrarUsuarios;
    private LoginPresenterContract.presenter contract;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        contract = new LoginPresenter(this);
        setContentView(R.layout.activity_cadastro);
        nome = findViewById(R.id.etNomeCadastro);
        email = findViewById(R.id.etEmailCadastro);
        telefone = findViewById(R.id.etTelefoneCadastro);
        senha = findViewById(R.id.etSenhaCadastro);
        btnCadastrarUsuarios = findViewById(R.id.btnCadastrarUsuario);
        btnCadastrarUsuarios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                contract.cadastrarLogin(email.getText().toString(), senha.getText().toString());
            }
        });
    }

    @Override
    public Context getContexto() {
        return null;
    }

    @Override
    public void entrar() {

    }

    @Override
    public void message(String msg) {
        Toast.makeText(this,msg, Toast.LENGTH_LONG).show();
    }
}