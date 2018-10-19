package com.wendergalan.tarefaagendada;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TarefaAgendadaApplication {

    public static void main(String[] args) {
        SpringApplication.run(TarefaAgendadaApplication.class, args);

        SchedulingTask schedulingTask = new SchedulingTask();
        schedulingTask.scheduleFutureTask();
    }

}
