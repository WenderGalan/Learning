package br.ufms.facom.aularesource;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn = (Button) findViewById(R.id.btn_test);
        btn.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        Toast.makeText(MainActivity.this, "Clica no botão não VIADO!", Toast.LENGTH_LONG).show();
    }
    }
