package com.example.tdr.roomapplication;

import android.arch.persistence.room.Room;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tdr.roomapplication.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {

    public ActivityMainBinding binding;
    private EditText nome;
    private EditText sobrenome;
    private EditText telefone;
    private Button salvar;
    private Button pesquisar;
    private TextView nomeText;
    private TextView telefoneText;
    private Button proximo;
    private int contador = 0;
    private List<User> usuarios = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        nome = findViewById(R.id.editTextNome);
        sobrenome = findViewById(R.id.editTextSobrenome);
        telefone = findViewById(R.id.editTextTelefone);
        salvar = findViewById(R.id.botaoSalvar);
        pesquisar = findViewById(R.id.botaoPesquisar);
        nomeText = findViewById(R.id.textNome);
        telefoneText = findViewById(R.id.textTelefone);
        proximo = findViewById(R.id.botaoProximo);

        final AppDatabase db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "database").build();



        salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final User user = new User(nome.getText().toString().toUpperCase(), sobrenome.getText().toString().toUpperCase(), telefone.getText().toString().toUpperCase());

                contador = 0;

                new AsyncTask<User, Context, Void>() {
                    boolean retorno = true;

                    @Override
                    protected Void doInBackground(User... users) {


                        AppDatabase db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "database").build();
                        long[] ids = db.userDao().insertAll(user);
                        user.setUid((int) ids[0]);

                        return null;
                    }


                    @Override
                    protected void onPostExecute(Void aVoid) {
                        super.onPostExecute(aVoid);
                        Toast.makeText(getApplicationContext(), "Usuário inserido com sucesso", Toast.LENGTH_LONG).show();
                        binding.setUser(user);
                        binding.notifyChange();
                    }

                    @Override
                    protected void onCancelled(Void aVoid) {
                        super.onCancelled(aVoid);
                        Toast.makeText(getApplicationContext(), "Usuário não inserido", Toast.LENGTH_LONG).show();
                    }
                }.execute();

                nome.setText("");
                sobrenome.setText("");
                telefone.setText("");

            }
        });

        pesquisar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /*User user = null;

                try {
                    user = new AsyncTask<String, Context, User>() {


                        @Override
                        protected User doInBackground(String... strings) {

                            User user = null;
                            user = db.userDao().findByFirstName(pesquisarTexto);
                            return user;
                        }

                        @Override
                        protected void onPostExecute(User user) {
                            super.onPostExecute(user);
                            if (user == null) {
                                Toast.makeText(getApplicationContext(), "Usuário não encontrado!", Toast.LENGTH_LONG).show();
                                binding.setUser(null);
                            } else if (user != null) {
                                binding.setUser(user);
                                binding.notifyChange();
                            }
                        }
                    }.execute().get();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }*/


                new AsyncTask<Void, Void, Void>() {


                    @Override
                    protected Void doInBackground(Void... voids) {

                        List<User> users = db.userDao().getAll();
                        usuarios = users;

                        return null;
                    }

                    @Override
                    protected void onPostExecute(Void aVoid) {
                        super.onPostExecute(aVoid);
                        if (usuarios != null && usuarios.size() > 0){
                            binding.setUser(usuarios.get(contador));
                            binding.notifyChange();
                        }
                    }
                }.execute();



            }


        });

        proximo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (contador == usuarios.size()){
                    binding.setUser(usuarios.get(contador));
                    binding.notifyChange();
                }else if (contador < usuarios.size() - 1){

                    binding.setUser(usuarios.get(++contador));
                    binding.notifyChange();
                }else{
                    contador = 0;
                    binding.setUser(usuarios.get(contador));
                    binding.notifyChange();
                }
            }
        });


    }
}
