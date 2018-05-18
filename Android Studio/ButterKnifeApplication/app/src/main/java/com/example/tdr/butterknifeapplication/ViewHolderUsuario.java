package com.example.tdr.butterknifeapplication;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class ViewHolderUsuario extends RecyclerView.ViewHolder {

    private ArrayList<User> usuarios;
    public TextView nome;

    public ViewHolderUsuario(View itemView) {
        super(itemView);
        nome = itemView.findViewById(R.id.textViewNome);
    }
}
