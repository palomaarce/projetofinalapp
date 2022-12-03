package com.example.projetofinal.view;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.projetofinal.R;
import com.example.projetofinal.presenter.LoginPresenter;
import com.example.projetofinal.presenter.LoginPresenterContract;
import com.example.projetofinal.repository.UsuarioRepository;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity implements LoginPresenterContract.view {
    EditText etEmail;
    EditText etSenha;
    Button btnLogar;
    Button btnCadastrar;
    private LoginPresenterContract.presenter contract;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAuth = FirebaseAuth.getInstance();


        contract = new LoginPresenter(this);
        etEmail = findViewById(R.id.tvLoginEmail);
        etSenha = findViewById(R.id.tvLoginSenha);
        btnLogar = findViewById(R.id.button);
        btnCadastrar = findViewById(R.id.button2);
        btnLogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //contract.logar(etEmail.getText().toString(), etSenha.getText().toString());
                contract.logar(etEmail.getText().toString(), etSenha.getText().toString());
            }
        });

        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CadastroActivity.class);
                startActivity(intent);
            }
        });
    }



    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        //updateUI(currentUser);
    }

    private void updateUI(FirebaseUser currentUser) {
    }

    @Override
    public Context getContexto() {
        return this;
    }

    @Override
    public void entrar() {
        startActivity(new Intent(this, UsuarioRepository.class));
    }

    @Override
    public void message(String msg) {

        Toast.makeText(this,msg, Toast.LENGTH_LONG).show();
        if(msg == "Logado com sucesso"){
            Log.d(TAG, "intent tela principal");
            Intent intent = new Intent(this, TelaPrincipalActivity.class);
            startActivity(intent);

        }
    }
}