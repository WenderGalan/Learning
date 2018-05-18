package com.example.tdr.butterknifeapplication;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class UsuarioAdapter extends RecyclerView.Adapter<ViewHolderUsuario> {

    private ArrayList<User> usuarios;

    UsuarioAdapter(ArrayList<User> usuarios){
        this.usuarios = usuarios;
    }


    @NonNull
    @Override
    public ViewHolderUsuario onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.recycler_item, parent, false);
        ViewHolderUsuario holder = new ViewHolderUsuario(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderUsuario holder, int position) {
        if (usuarios != null) {
            holder.nome.setText(usuarios.get(position).getNome());
        }
    }

    @Override
    public int getItemCount() {
        return usuarios.size();
    }
}
