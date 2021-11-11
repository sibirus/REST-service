package com.example.calculator.config;

import com.example.calculator.ws.CalculatorWsClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class WsConfig {

    @Value("${calculator.url}")
    private String url;

    @Bean
    public Jaxb2Marshaller calculatorMarshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("org.tempuri");
        return marshaller;
    }

    @Bean
    public CalculatorWsClient calculatorServiceClient(final Jaxb2Marshaller calculatorMarshaller) {
        CalculatorWsClient client = new CalculatorWsClient();
        client.setDefaultUri(url);
        client.setMarshaller(calculatorMarshaller);
        client.setUnmarshaller(calculatorMarshaller);
        return client;
    }

}
