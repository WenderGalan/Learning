package com.wendergalan.tarefaagendada;

import java.io.Serializable;

/**
 * Tarefa Agendada
 * Todos os direitos reservados ©
 * *********************************************
 * Nome do arquivo: AtividadePrincipal.java
 * Criado por : Wender Galan
 * Data da criação : 19/10/2018
 * Observação :
 * *********************************************
 */
public class AtividadePrincipal implements Serializable {

    private String text;
    private String code;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
