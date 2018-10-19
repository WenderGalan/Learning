package com.wendergalan.tarefaagendada;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * Tarefa Agendada
 * Todos os direitos reservados ©
 * *********************************************
 * Nome do arquivo: CNPJClient.java
 * Criado por : Wender Galan
 * Data da criação : 19/10/2018
 * Observação :
 * *********************************************
 */
@Component
public class CNPJClient {

    private static int TIMEOUT = 5000;

    public Cnpj buscaCNPJ(String cnpj) {
        RestTemplate restTemplate = new RestTemplate(getClientHttpRequestFactory());
        Cnpj result = restTemplate.getForObject("https://www.receitaws.com.br/v1/cnpj/{cnpj}", Cnpj.class, cnpj);
        System.out.println(result);
        return result;
    }

    private ClientHttpRequestFactory getClientHttpRequestFactory() {
        RequestConfig config = RequestConfig.custom()
                .setConnectTimeout(TIMEOUT)
                .setConnectionRequestTimeout(TIMEOUT)
                .setSocketTimeout(TIMEOUT)
                .build();
        CloseableHttpClient client = HttpClientBuilder
                .create()
                .setDefaultRequestConfig(config)
                .build();
        return new HttpComponentsClientHttpRequestFactory(client);
    }
}
