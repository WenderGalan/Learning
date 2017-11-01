package br.ufms.facom.taskclass;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {

    private Button botaoCalcular;
    private String valor = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        botaoCalcular = (Button) findViewById(R.id.btn_calc);
        botaoCalcular.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                MyTask myTask = new MyTask();
                EditText txt = (EditText) findViewById(R.id.txt_number);
                valor = txt.getText().toString();
                myTask.execute(Integer.parseInt(valor));
                TextView textView = (TextView) findViewById(R.id.txt_answer);
                int value = 100;
                try {
                    value = myTask.get();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
                textView.setText(Integer.toString(value));
            }
        });


    }
}
