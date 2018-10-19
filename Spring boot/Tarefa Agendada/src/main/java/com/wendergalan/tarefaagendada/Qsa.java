package com.wendergalan.tarefaagendada;

import java.io.Serializable;

/**
 * Tarefa Agendada
 * Todos os direitos reservados ©
 * *********************************************
 * Nome do arquivo: Qsa.java
 * Criado por : Wender Galan
 * Data da criação : 19/10/2018
 * Observação :
 * *********************************************
 */
public class Qsa implements Serializable {

    private String nome;
    private String qual;
    private String pais_origem;
    private String nome_rep_legal;
    private String qual_rep_legal;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getQual() {
        return qual;
    }

    public void setQual(String qual) {
        this.qual = qual;
    }

    public String getPais_origem() {
        return pais_origem;
    }

    public void setPais_origem(String pais_origem) {
        this.pais_origem = pais_origem;
    }

    public String getNome_rep_legal() {
        return nome_rep_legal;
    }

    public void setNome_rep_legal(String nome_rep_legal) {
        this.nome_rep_legal = nome_rep_legal;
    }

    public String getQual_rep_legal() {
        return qual_rep_legal;
    }

    public void setQual_rep_legal(String qual_rep_legal) {
        this.qual_rep_legal = qual_rep_legal;
    }
}
