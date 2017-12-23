package wendergalan.com.sqlite;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            SQLiteDatabase bancoDados = openOrCreateDatabase("app", MODE_PRIVATE, null);

            //tabela
            //ID PODE COLOCAR COMO INTEGER COM PRIMARY KEY E AUTOINCREMENT,
            bancoDados.execSQL("CREATE TABLE IF NOT EXISTS pessoas(nome VARCHAR, idade INT(3))");

            //inserir dados
            //bancoDados.execSQL("INSERT INTO pessoas (nome, idade) VALUES ('Sabrina', 10)");
            //bancoDados.execSQL("INSERT INTO pessoas (nome, idade) VALUES ('Catarina', 65)");

            // update
           // bancoDados.execSQL("UPDATE pessoas SET idade = 28 WHERE nome = 'Marcos'");

            //delete
            bancoDados.execSQL("DELETE FROM pessoas WHERE nome = 'Marcos'");

            //recuperar dados
            Cursor cursor = bancoDados.rawQuery("SELECT nome, idade FROM pessoas", null);

            int indiceColunaNome = cursor.getColumnIndex("nome");
            int indiceColunaIdade = cursor.getColumnIndex("idade");

            cursor.moveToFirst();

            while(cursor != null){

                Log.i("Resultado - nome: ", cursor.getString(indiceColunaNome));
                Log.i("Resultado - idade: ", cursor.getString(indiceColunaIdade));
                cursor.moveToNext();

            }
        }catch(Exception e){
            e.printStackTrace();
        }



    }
}
