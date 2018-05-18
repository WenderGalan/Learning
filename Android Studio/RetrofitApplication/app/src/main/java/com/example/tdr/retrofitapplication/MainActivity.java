package com.example.tdr.retrofitapplication;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;

import okhttp3.internal.platform.Platform;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

public class MainActivity extends AppCompatActivity {

    public static final String API_URL = "http://api.postmon.com.br/v1/cep/";
    private EditText editTextCep;
    private Button botao;
    private TextView textView;
    private Retrofit retrofit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextCep = findViewById(R.id.editTextCep);
        botao = findViewById(R.id.buttonEnviar);
        textView = findViewById(R.id.textViewResultado);

        retrofit = new Retrofit.Builder()
                .baseUrl(API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                solicitarEndereco();
            }
        });


    }

    private void solicitarEndereco() {
        String cep = editTextCep.getText().toString();

        PostmonService service = retrofit.create(PostmonService.class);

        Call<Endereco> call = service.getEndereco(cep);

        call.enqueue(new Callback<Endereco>() {
            @Override
            public void onResponse(Call<Endereco> call, Response<Endereco> response) {
                if (response.isSuccessful()) {
                    Endereco endereco = response.body();

                    String strEndereco = "Cidade: " + endereco.getCidade() + "\n" +
                            "Bairro: " + endereco.getBairro() + "\n" +
                            "Logradouro: " + endereco.getLogradouro() + "\n" +
                            "Estado: " + endereco.getEstado();

                    textView.setText(strEndereco);
                }
            }

            @Override
            public void onFailure(Call<Endereco> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Não foi possível realizar a requisição", Toast.LENGTH_SHORT).show();
            }
        });

    }


}
