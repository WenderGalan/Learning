package radionbutton.wendergalan.com.radionbutton;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends Activity {


    private RadioGroup radioGroup;
    private RadioButton radioButtonEscolhido;
    private Button botaoEscolher;
    private TextView textoExibicao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroup = findViewById(R.id.radionGroupID);
        botaoEscolher = findViewById(R.id.botaoEscolher);
        textoExibicao = findViewById(R.id.textExibicao);

        botaoEscolher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int idRadioButtonEscolhido = radioGroup.getCheckedRadioButtonId();

                if (idRadioButtonEscolhido > 0){
                    radioButtonEscolhido = findViewById(idRadioButtonEscolhido);
                    textoExibicao.setText(radioButtonEscolhido.getText());
                }

            }
        });


    }
}
