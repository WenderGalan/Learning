package com.wendergalan.tarefaagendada;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Tarefa Agendada
 * Todos os direitos reservados ©
 * *********************************************
 * Nome do arquivo: SchedulingTask.java
 * Criado por : Wender Galan
 * Data da criação : 19/10/2018
 * Observação :
 * *********************************************
 */
@Component
@EnableScheduling
public class SchedulingTask {

    private final long MINUTO = 10000;

    @Scheduled(fixedDelay = MINUTO)
    public void scheduleFutureTask() {
        System.out.println(new Date());
        ViaCEPClient viaCEPClient = new ViaCEPClient();
        System.out.println(viaCEPClient.buscaEnderecoPor("79071203"));

        CNPJClient cnpjClient = new CNPJClient();
        cnpjClient.buscaCNPJ("27865757000102");
    }
}
