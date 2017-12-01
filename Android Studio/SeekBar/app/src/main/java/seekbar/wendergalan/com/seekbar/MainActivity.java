package seekbar.wendergalan.com.seekbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private SeekBar seekBarPrimeira;
    private SeekBar seekBarSegunda;
    private TextView textoExibicao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seekBarPrimeira = findViewById(R.id.seekBarPrimeiraID);
        seekBarSegunda = findViewById(R.id.seekBarSegundaID);

        textoExibicao = findViewById(R.id.textExibicaoID);

        seekBarPrimeira.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override

            //monitoramento da seek bar
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                textoExibicao.setText("Progresso: " + i + " / " + seekBarPrimeira.getMax());
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Toast.makeText(MainActivity.this, "SeekBar Pressionado", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(MainActivity.this, "Salvar o valor", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
