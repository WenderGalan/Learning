package com.websocket.websocket.models;

/**
 * websocket
 * TDR Informática Ltda
 * Todos os direitos reservados ©
 * ***********************************************
 * Nome do arquivo: Greeting.java
 * Criado por : Wender Galan Benage
 * Data da criação : 04/07/19
 * Observação :
 * ***********************************************
 */
public class Greeting {

    private String content;

    public Greeting() {
    }

    public Greeting(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
