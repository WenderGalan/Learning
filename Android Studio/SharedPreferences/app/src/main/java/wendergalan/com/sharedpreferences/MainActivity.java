package wendergalan.com.sharedpreferences;

import android.app.Activity;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends Activity {

    private EditText textoNome;
    private Button salvar;
    private TextView textoExibicao;
    private static final String ARQUIVO_PREFERENCIA = "ArquivoPreferencia";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textoNome = findViewById(R.id.editTextID);
        textoExibicao = findViewById(R.id.textNomeID);
        salvar = findViewById(R.id.botaoSalvarID);

        salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SharedPreferences sharedPreferences = getSharedPreferences(ARQUIVO_PREFERENCIA, 0);
                SharedPreferences.Editor editor = sharedPreferences.edit();

                if (textoNome.getText().toString().equals("")){
                    Toast.makeText(MainActivity.this, "Por favor, preencher o nom!", Toast.LENGTH_SHORT).show();
                }else{
                    editor.putString("nome", textoNome.getText().toString());
                    editor.commit();
                    textoExibicao.setText("Olá, " + textoNome.getText().toString());
                }
            }
        });

        //recuperar os dados salvos
        SharedPreferences sharedPreferences = getSharedPreferences(ARQUIVO_PREFERENCIA, 0);
        if (sharedPreferences.contains("nome")){
            String nomeUsuario = sharedPreferences.getString("nome", "Usuario não definido");
            textoExibicao.setText("Olá, " + nomeUsuario);
        }else{
            textoExibicao.setText("Olá usuario não definido.");
        }
    }



}
