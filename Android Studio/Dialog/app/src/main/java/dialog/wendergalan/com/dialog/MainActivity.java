package dialog.wendergalan.com.dialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

    private Button botao;
    private AlertDialog.Builder dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    botao = findViewById(R.id.botaoID);
    botao.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            //criar o alert dialog
            dialog = new AlertDialog.Builder(MainActivity.this);

            //configuraçao do titulo
            dialog.setTitle("Titulo do dialog");

            //configurar a mensagen
            dialog.setMessage("Mensagem da dialog");

            //pode ser cancelado ou nao
            dialog.setCancelable(false);

            //definir um icone para exibir na dialog
            dialog.setIcon(android.R.drawable.ic_delete);

            //botao negativo
            dialog.setNegativeButton("Não",
                    new DialogInterface.OnClickListener(){
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Toast.makeText(MainActivity.this, "Pressionado o botão não", Toast.LENGTH_SHORT).show();
                        }
                    });

            //botao positivo
            dialog.setPositiveButton("Sim",
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Toast.makeText(MainActivity.this, "Pressionado o botão sim", Toast.LENGTH_SHORT).show();
                        }
                    });

            dialog.create();
            dialog.show();
        }
    });

    }


}
