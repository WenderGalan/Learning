package com.wendergalan.materialtheme;

import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatEditText;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private AppCompatEditText editTextEmail;
    private AppCompatEditText editTextPassword;

    private TextInputLayout textInputLayoutEmail;
    private TextInputLayout textInputLayoutPassword;

    private Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextEmail = findViewById(R.id.email);
        editTextPassword = findViewById(R.id.senha);

        textInputLayoutEmail = findViewById(R.id.txtLayoutEmail);
        textInputLayoutPassword = findViewById(R.id.txtLayoutPassword);

        button = findViewById(R.id.btnLogin);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validateForm();
            }
        });
    }

    private void validateForm(){
        if (editTextEmail.getText().toString().isEmpty()){
            textInputLayoutEmail.setErrorEnabled(true);
            textInputLayoutEmail.setError("Preencha com seu email");
        }
        if (editTextPassword.getText().toString().isEmpty()){
            textInputLayoutPassword.setErrorEnabled(true);
            textInputLayoutPassword.setError("Preencha com sua senha");
        }
    }
}
