package com.wendergalan.firebaseapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    //pega o acesso ao banco de dados
    private DatabaseReference databasereferencia = FirebaseDatabase.getInstance().getReference();
    private DatabaseReference usuarioReferencia = databasereferencia.child("usuarios");
    private DatabaseReference produtoReferencia = databasereferencia.child("produtos").child("001");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       /* Usuario usuario = new Usuario();
        usuario.setNome("Ana Helena");
        usuario.setSobrenome("Silva");
        usuario.setIdade(25);
        usuario.setSexo("Feminino");

        Produto produto = new Produto();
        produto.setDescricao("Notebook WP40");
        produto.setCor("Branco");
        produto.setFabricante("HP");*/

        /*produtoReferencia.child("001").setValue( produto );*/


        usuarioReferencia.addValueEventListener(new ValueEventListener() {

            //sempre q os dados forem modificados
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Log.i("FIREBASE", dataSnapshot.getValue().toString());
            }

            //caso tenha erro ao recuperar dados
            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }
}
