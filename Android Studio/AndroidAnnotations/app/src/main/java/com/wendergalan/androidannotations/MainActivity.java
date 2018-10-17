package com.wendergalan.androidannotations;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;

import java.io.InputStream;

@EActivity(R.layout.activity_main)
public class MainActivity extends AppCompatActivity {

    @ViewById
    TextView textView;

    @ViewById
    ImageView imagem;

    @Click
    void button(){
        textView.setText("Hello User");
        executarDownload();
    }

    @Background
    void executarDownload(){
        Bitmap img = null;
        try {
            InputStream in = new java.net.URL("https://cdn.shopify.com/s/files/1/1061/1924/files/Tongue_Out_Emoji_2.png?13752525173949329807").openStream();
            Log.i("DEBUGGER", in.toString());
            img = BitmapFactory.decodeStream(in);
        } catch (Exception e) {
            Log.e("Error", e.getMessage());
            e.printStackTrace();
        }

        atualizaViews(img);
    }


    @UiThread
    void atualizaViews(Bitmap bitmap){
        imagem.setImageBitmap(bitmap);
        textView.setText("Carregou!");
    }


}
