package com.wendergalan.autenticacaousuario;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firebaseAuth = FirebaseAuth.getInstance();

        //deslogando o usuario
        firebaseAuth.signOut();

        //retorna o usuario caso contrario retorna nulo
        if (firebaseAuth.getCurrentUser() != null){
            Log.i("verificaUsuario", "Usuario logado");
        }else{
            Log.i("verificaUsuario", "Usuario não logado");
        }





        /**login do usuario**/
        /*firebaseAuth.signInWithEmailAndPassword("wendergalan2014@hotmail.com", "wendergalan")
                .addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){//sucesso ao cadastrar
                            Log.i("SignIn", "Sucesso ao fazer login do usuario!");
                        }else{//erro ao cadastrar
                            Log.i("SignIn", "Erro ao fazer o login do usuario!" + task.getException());
                        }
                    }
                });

        /**Cadastro do Usuario**/
        /*
        firebaseAuth.createUserWithEmailAndPassword("wendergalan2014@hotmail.com", "wendergalan")
                /**TRECHO DE CODIGO QUANDO TERMINAR DE REGISTRAR O USUARIO **/
                /*.addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (task.isSuccessful()){//sucesso ao cadastrar
                            Log.i("CREATE USER", "Sucesso ao cadastrar!");
                        }else{//erro ao cadastrar
                            Log.i("CREATE USER", "Erro ao cadastrar o usuario!");
                        }
                    }
                });
        */





    }



}
