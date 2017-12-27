package com.wendergalan.firebaseapp;

/**
 * Created by Wender Galan Gamer on 27/12/2017.
 */

public class Produto {

    private String descricao;
    private String cor;
    private String Fabricante;

    public Produto() {
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getFabricante() {
        return Fabricante;
    }

    public void setFabricante(String fabricante) {
        Fabricante = fabricante;
    }
}
