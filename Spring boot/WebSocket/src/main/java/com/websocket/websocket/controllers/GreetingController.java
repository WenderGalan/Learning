package com.websocket.websocket.controllers;

import com.websocket.websocket.models.Greeting;
import com.websocket.websocket.models.HelloMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

/**
 * websocket
 * TDR Informática Ltda
 * Todos os direitos reservados ©
 * ***********************************************
 * Nome do arquivo: GreetingController.java
 * Criado por : Wender Galan Benage
 * Data da criação : 04/07/19
 * Observação :
 * ***********************************************
 */
@Controller
public class GreetingController {

    @MessageMapping("/hello") // RECEBE A MENSAGEM
    @SendTo("/topic/greetings") // ASSINANTES QUE IRÃO RECEBER
    public Greeting greeting(HelloMessage message) throws Exception {
        Thread.sleep(1000);
        return new Greeting(HtmlUtils.htmlEscape(message.getName()));
    }
}
