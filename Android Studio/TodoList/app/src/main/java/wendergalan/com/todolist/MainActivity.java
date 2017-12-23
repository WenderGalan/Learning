package wendergalan.com.todolist;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends Activity {

    private Button botaoAdicionar;
    private EditText textoTarefa;
    private ListView listaTarefa;
    private SQLiteDatabase bancoDados;
    private ArrayAdapter<String> itensAdaptador;
    private ArrayList<String> itens;
    private ArrayList<Integer> ids;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            //recuperar os componentes
            textoTarefa = findViewById(R.id.textoId);
            botaoAdicionar = findViewById(R.id.botaoAdicionarId);
            listaTarefa = findViewById(R.id.listViewId);

            //banco de dados
            bancoDados = openOrCreateDatabase("apptarefas", MODE_PRIVATE, null);

            //tabela tarefas
            bancoDados.execSQL("CREATE TABLE IF NOT EXISTS tarefas (id INTEGER PRIMARY KEY AUTOINCREMENT, tarefa VARCHAR)");

            botaoAdicionar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    salvarTarefa(textoTarefa.getText().toString());
                }
            });

            listaTarefa.setLongClickable(true);
            listaTarefa.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
                @Override
                public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                    removerTarefa( ids.get( position ) );
                    return true;
                }
            });

            //listar tarefas
            recuperarTarefas();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void salvarTarefa(String texto){
        try {
            if (texto.equals("")){
                Toast.makeText(MainActivity.this, "Digite uma tarefa!", Toast.LENGTH_SHORT).show();

            }else {
                bancoDados.execSQL("INSERT INTO tarefas (tarefa) VALUES ('" + texto + "')");
                Toast.makeText(MainActivity.this, "Tarefa Inserida com sucesso!", Toast.LENGTH_SHORT).show();
                recuperarTarefas();
                textoTarefa.setText("");
            }
            }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void recuperarTarefas(){
        try {

            //cursor recupera as tarefas
            Cursor cursor = bancoDados.rawQuery("SELECT * FROM tarefas ORDER BY id DESC", null);

            //recuperar os ids das colunas
            int indiceColunaId = cursor.getColumnIndex("id");
            int indiceColunaTarefa = cursor.getColumnIndex("tarefa");

            //criar adaptador
            itens = new ArrayList<String>();
            ids = new ArrayList<Integer>();
            itensAdaptador = new ArrayAdapter<String>(getApplicationContext(),
                    android.R.layout.simple_list_item_2,
                    android.R.id.text2,
                    itens);
            listaTarefa.setAdapter(itensAdaptador);

            //listar as tarefas
            cursor.moveToFirst();
            while (cursor != null){
                Log.i("Resultado - ", "Id Tarefa: " + cursor.getString(indiceColunaId) + "Tarefa: " + cursor.getString(indiceColunaTarefa));
                itens.add(cursor.getString(indiceColunaTarefa));
                ids.add(Integer.parseInt(cursor.getString(indiceColunaId)));
                cursor.moveToNext();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void removerTarefa(Integer id){
        try {
            bancoDados.execSQL("DELETE FROM tarefas WHERE id ="+id);
            recuperarTarefas();
            Toast.makeText(MainActivity.this, "Tarefa Removida com sucesso!", Toast.LENGTH_SHORT).show();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
