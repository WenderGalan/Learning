package br.ufms.facom.taskclass;

import android.os.AsyncTask;
import okhttp3.OkHttpClient;


/**
 * Created by wender on 13/10/2017.
 */

public class MyTask extends AsyncTask<Integer, Void, Integer>{

    public int fatorial = 1;

    @Override
    protected Integer doInBackground(Integer... integers) {
        for(int i = 2; i <= integers[0]; i++ ){
            fatorial *= i;
        }
        return fatorial;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    protected void onPostExecute(int fatorial) {
        super.onPostExecute(fatorial);
    }

}
