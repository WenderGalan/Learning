package com.websocket.websocket.models;

/**
 * websocket
 * TDR Informática Ltda
 * Todos os direitos reservados ©
 * ***********************************************
 * Nome do arquivo: HelloMessage.java
 * Criado por : Wender Galan Benage
 * Data da criação : 04/07/19
 * Observação :
 * ***********************************************
 */
public class HelloMessage {

    private String name;

    public HelloMessage() {
    }

    public HelloMessage(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
