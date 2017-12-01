package checkbox.wendergalan.com.checkbox;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends Activity {


    private CheckBox checkboxCao;
    private CheckBox checkboxGato;
    private CheckBox checkboxPapagaio;

    private Button botaoMostrar;
    private TextView textoExibicao;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkboxCao = findViewById(R.id.checkBoxCao);
        checkboxGato = findViewById(R.id.checkBoxGato);
        checkboxPapagaio = findViewById(R.id.checkBoxPapagaio);

        textoExibicao = findViewById(R.id.textMostrar);
        botaoMostrar = findViewById(R.id.botaoMostrarID);


        botaoMostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String itensSelecionados = "";

                itensSelecionados += "Item: " + checkboxCao.getText() + "Status: " + checkboxCao.isChecked() + "\n";
                itensSelecionados += "Item: " + checkboxGato.getText() + "Status: " + checkboxCao.isChecked() + "\n";
                itensSelecionados += "Item: " + checkboxPapagaio.getText() + "Status: " + checkboxCao.isChecked() + "\n";



                textoExibicao.setText(itensSelecionados);
            }
        });
    }
}
