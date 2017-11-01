package cursoandroid.com.jogodavelha;

import android.graphics.ImageFormat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private Button botao_1;
    private Button botao_2;
    private Button botao_3;
    private Button botao_4;
    private Button botao_5;
    private Button botao_6;
    private Button botao_7;
    private Button botao_8;
    private Button botao_9;
    private int contadorDeJogadas = 1;
    private String opcaoX = "X";
    private String opcaoO = "O";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botao_1 = (Button) findViewById(R.id.botao_1);
        botao_2 = (Button) findViewById(R.id.botao_2);
        botao_3 = (Button) findViewById(R.id.botao_3);
        botao_4 = (Button) findViewById(R.id.botao_4);
        botao_5 = (Button) findViewById(R.id.botao_5);
        botao_6 = (Button) findViewById(R.id.botao_6);
        botao_7 = (Button) findViewById(R.id.botao_7);
        botao_8 = (Button) findViewById(R.id.botao_8);
        botao_9 = (Button) findViewById(R.id.botao_9);


        botao_1.setOnClickListener(this);
        botao_2.setOnClickListener(this);
        botao_3.setOnClickListener(this);
        botao_4.setOnClickListener(this);
        botao_5.setOnClickListener(this);
        botao_6.setOnClickListener(this);
        botao_7.setOnClickListener(this);
        botao_8.setOnClickListener(this);
        botao_9.setOnClickListener(this);



    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.botao_1:
                jogada(R.id.botao_1);
            break;

            case R.id.botao_2:
                jogada(R.id.botao_2);
                break;

            case R.id.botao_3:
                jogada(R.id.botao_3);
                break;

            case R.id.botao_4:
                jogada(R.id.botao_4);
                break;

            case R.id.botao_5:
                jogada(R.id.botao_5);
                break;

            case R.id.botao_6:
                jogada(R.id.botao_6);
                break;

            case R.id.botao_7:
                jogada(R.id.botao_7);
                break;

            case R.id.botao_8:
                jogada(R.id.botao_8);
                break;

            case R.id.botao_9:
                jogada(R.id.botao_9);
                break;
        }
    }

    public void jogada(int numeroDoBotao){
        Button btn = (Button) findViewById(numeroDoBotao);
        if (btn.getText() == "X" || btn.getText() == "O"){
            Toast.makeText(this, "Escolha outro campo!", Toast.LENGTH_SHORT).show();
        }else{
            if (contadorDeJogadas == 1 || contadorDeJogadas == 3 || contadorDeJogadas == 5 || contadorDeJogadas == 7 || contadorDeJogadas == 9 ){
                btn.setText(opcaoX);
                contadorDeJogadas++;
                ganhou();
            }else{
                btn.setText(opcaoO);
                contadorDeJogadas++;
                ganhou();
            }

        }
    }

    public void ganhou(){
        if (botao_1.getText().equals(botao_2.getText()) && botao_2.getText().equals(botao_3.getText())){
            if (botao_1.getText().equals("")){
                //VERIFICA SE NÃO ESTA VAZIO OS BOTÕES
            }else {
                //VERIFICA SE ALGUEM JA GANHOU PARA NÃO EXIBIR MAIS MENSAGENS NA TELA
                if (jaGanhou != true){
                    Toast.makeText(this, "O JOGADOR " + botao_1.getText() + " GANHOU :)", Toast.LENGTH_LONG).show();
                    jaGanhou = true;
                }
            }
        }
        if (botao_1.getText().equals(botao_4.getText()) && botao_4.getText().equals(botao_7.getText())){
            if (botao_1.getText().equals("")){
                //VERIFICA SE NÃO ESTA VAZIO OS BOTÕES
            }else{
                if (jaGanhou != true){
                    Toast.makeText(this, "O JOGADOR " + botao_1.getText() + " GANHOU :)", Toast.LENGTH_LONG).show();
                    jaGanhou = true;
                }
            }
        }else if (botao_7.getText().equals(botao_8.getText()) && botao_8.getText().equals(botao_9.getText())){
            if (botao_7.getText().equals("")){
                //VERIFICA SE NÃO ESTA VAZIO OS BOTÕES
            }else {
                if (jaGanhou != true){
                    Toast.makeText(this, "O JOGADOR " + botao_7.getText() + " GANHOU :)", Toast.LENGTH_LONG).show();
                    jaGanhou = true;
                }
            }
        }else if (botao_3.getText().equals(botao_6.getText()) && botao_6.getText().equals(botao_9.getText())){
            if (botao_3.getText().equals("")){
                //VERIFICA SE NÃO ESTA VAZIO OS BOTÕES
            }else{
                if (jaGanhou != true){
                    Toast.makeText(this, "O JOGADOR " + botao_3.getText() + " GANHOU :)", Toast.LENGTH_LONG).show();
                    jaGanhou = true;
                }
            }
        }else if (botao_1.getText().equals(botao_5.getText()) && botao_5.getText().equals(botao_9.getText())){
            if (botao_1.getText().equals("")){
                //VERIFICA SE NÃO ESTA VAZIO OS BOTÕES
            }else{
                if (jaGanhou != true){
                    Toast.makeText(this, "O JOGADOR " + botao_1.getText() + " GANHOU :)", Toast.LENGTH_LONG).show();
                    jaGanhou = true;
                }
            }
        }else if (botao_3.getText().equals(botao_5.getText()) && botao_5.getText().equals(botao_7.getText())){
            if (botao_3.getText().equals("")){
                //VERIFICA SE NÃO ESTA VAZIO OS BOTÕES
            }else{
                if (jaGanhou != true){
                    Toast.makeText(this, "O JOGADOR " + botao_3.getText() + " GANHOU :)", Toast.LENGTH_LONG).show();
                    jaGanhou = true;
                }
            }
        }else if (botao_4.getText().equals(botao_5.getText()) && botao_5.getText().equals(botao_6.getText())){
            if (botao_4.getText().equals("")){
                //VERIFICA SE NÃO ESTA VAZIO OS BOTÕES
            }else{
                if (jaGanhou != true){
                    Toast.makeText(this, "O JOGADOR " + botao_4.getText() + " GANHOU :)", Toast.LENGTH_LONG).show();
                    jaGanhou = true;
                }
            }
        }else if (botao_2.getText().equals(botao_5.getText()) && botao_5.getText().equals(botao_8.getText())){
            if (botao_2.getText().equals("")){
                //VERIFICA SE NÃO ESTA VAZIO OS BOTÕES
            }else{
                if (jaGanhou != true){
                    Toast.makeText(this, "O JOGADOR " + botao_2.getText() + " GANHOU :)", Toast.LENGTH_LONG).show();
                    jaGanhou = true;
                }
            }
        }

        if (contadorDeJogadas == 10 && jaGanhou == false){
            Toast.makeText(this, "EMPATOU :(", Toast.LENGTH_LONG).show();
        }
    }
}
