package com.wendergalan.projetofragmento;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button botaoLogar;
    private Boolean status = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botaoLogar = findViewById(R.id.bt_logar);

        botaoLogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
                android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                if (status){
                    LoginFragment loginFragment = new LoginFragment();
                    fragmentTransaction.add(R.id.rl_container_fragment, loginFragment);
                    fragmentTransaction.commit();
                    botaoLogar.setText("Cadastre-se");
                    status = false;
                }else{
                    CadastroFragment cadastroFragment = new CadastroFragment();
                    fragmentTransaction.add(R.id.rl_container_fragment, cadastroFragment);
                    fragmentTransaction.commit();
                    botaoLogar.setText("Logar");
                    status = true;
                }



            }
        });

    }
}
