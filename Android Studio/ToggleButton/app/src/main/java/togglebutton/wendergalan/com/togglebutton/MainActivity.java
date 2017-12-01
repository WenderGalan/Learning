package togglebutton.wendergalan.com.togglebutton;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends Activity {

    private ToggleButton toggleButton;
    private TextView textoExibicao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toggleButton = findViewById(R.id.toggleButtonID);
        textoExibicao = findViewById(R.id.textExibicaoID);

        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                textoExibicao.setText("");

                if (b){
                    textoExibicao.setText("Mostrar...");
                }
            }
        });
    }
}
