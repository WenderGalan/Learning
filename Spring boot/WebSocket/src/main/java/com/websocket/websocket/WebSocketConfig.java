package com.websocket.websocket;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

/**
 * websocket
 * TDR Informática Ltda
 * Todos os direitos reservados ©
 * ***********************************************
 * Nome do arquivo: WebSocketConfig.java
 * Criado por : Wender Galan Benage
 * Data da criação : 04/07/19
 * Observação :
 * ***********************************************
 */
@Configuration
@EnableWebSocketMessageBroker // Ativa o tratamento de mensagem
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    // Configure o intermedio das mensagens
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        // Ativa o intermediário de mensagens
        registry.enableSimpleBroker("/topic");
        // Designa o app para mensagens que estão vinculadas ao @MessageMapping
        // Para chamar o hello tem que mapear por exemplo -> /app/hello
        registry.setApplicationDestinationPrefixes("/app");
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/gs-guide-websocket").withSockJS();
    }
}
