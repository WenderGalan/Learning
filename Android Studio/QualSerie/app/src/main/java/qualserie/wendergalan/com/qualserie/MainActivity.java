package qualserie.wendergalan.com.qualserie;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.SeekBar;

public class MainActivity extends Activity {


    private SeekBar seekBar;
    private ImageView imagemExibicao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        seekBar = findViewById(R.id.seekBarID);
        imagemExibicao = findViewById(R.id.imageExibicaoID);


        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                int valorProgresso = i;

                if (valorProgresso == 1){
                    imagemExibicao.setImageResource( R.drawable.pouco );
                }else if (valorProgresso == 2){
                    imagemExibicao.setImageResource(R.drawable.medio);
                }else if (valorProgresso == 3){
                    imagemExibicao.setImageResource(R.drawable.muito);
                }else if (valorProgresso == 4 ){
                    imagemExibicao.setImageResource(R.drawable.susto);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


    }
}
