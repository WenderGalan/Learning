package com.wendergalan.tarefaagendada;

import java.io.Serializable;

/**
 * Tarefa Agendada
 * Todos os direitos reservados ©
 * *********************************************
 * Nome do arquivo: Billing.java
 * Criado por : Wender Galan
 * Data da criação : 19/10/2018
 * Observação :
 * *********************************************
 */
public class Billing implements Serializable {

    private boolean free;
    private boolean database;

    public boolean isFree() {
        return free;
    }

    public void setFree(boolean free) {
        this.free = free;
    }

    public boolean isDatabase() {
        return database;
    }

    public void setDatabase(boolean database) {
        this.database = database;
    }
}
