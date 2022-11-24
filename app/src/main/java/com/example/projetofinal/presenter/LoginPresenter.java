package com.example.projetofinal.presenter;

import static android.content.ContentValues.TAG;

import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.projetofinal.repository.UsuarioRepository;
import com.example.projetofinal.view.MainActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.concurrent.Executor;

public class LoginPresenter implements LoginPresenterContract.presenter{
    LoginPresenterContract.view view;
    private UsuarioRepository repository;
    private FirebaseAuth mAuth;
    private FirebaseUser user;


    public LoginPresenter(LoginPresenterContract.view view) {
        this.view = view;
        repository = new UsuarioRepository();
        mAuth = FirebaseAuth.getInstance();
        this.user = mAuth.getCurrentUser();
        if (user != null) {
            mAuth.signOut();
            this.user = mAuth.getCurrentUser();
        }
        Log.d(TAG, "LoginPresenter: "+user);
    }

    @Override
    public void logar(String email, String senha) {
        mAuth.signInWithEmailAndPassword(email, senha)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithCustomToken:success");
                            view.message("Logado com sucesso");
                            FirebaseUser user = mAuth.getCurrentUser();
                            //view.entrar();
                            //updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithCustomToken:failure", task.getException());
                            view.message("Falha no login");
                            //updateUI(null);
                        }
                    }
                });

    }

    @Override
    public void cadastrarLogin(String email, String senha) {
        //configurar a validação da senha, digita uma vez e digita outra para confirmar
        mAuth.createUserWithEmailAndPassword(email, senha)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "createUserWithEmail:success");
                            view.message("Usuário criado com sucesso");
                            FirebaseUser user = mAuth.getCurrentUser();

                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "createUserWithEmail:failure", task.getException());
                            view.message("Falha na criação do usuário");

                        }
                    }
                });

    }
}
