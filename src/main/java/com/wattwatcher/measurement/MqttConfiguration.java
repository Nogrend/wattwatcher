package com.wattwatcher.measurement;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wattwatcher.measurement.controller.SaveMeasurementCommand;
import org.eclipse.paho.client.mqttv3.IMqttClient;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.Transformer;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.core.MessageProducer;
import org.springframework.integration.mqtt.core.DefaultMqttPahoClientFactory;
import org.springframework.integration.mqtt.core.MqttPahoClientFactory;
import org.springframework.integration.mqtt.inbound.MqttPahoMessageDrivenChannelAdapter;
import org.springframework.integration.mqtt.support.DefaultPahoMessageConverter;
import org.springframework.messaging.MessageChannel;

import java.util.concurrent.SubmissionPublisher;

@Configuration
public class MqttConfiguration {
    private ObjectMapper objectMapper;

    public MqttConfiguration(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Bean
    @ConfigurationProperties(prefix = "mqtt")
    public MqttConnectOptions mqttConnectOptions() {
        return new MqttConnectOptions();
    }

    @Bean
    public MessageChannel mqttInputChannel() {
        return new DirectChannel();
    }

    @Bean
    public MessageChannel processedInputChannel() {
        return new DirectChannel();
    }

    @Bean
    public MqttPahoClientFactory mqttClientFactory() {
        var factory = new DefaultMqttPahoClientFactory();
        var options = new MqttConnectOptions();
        options.setServerURIs(new String[]{ "tcp://localhost:1883" });
        options.setUserName("bram");
        options.setPassword("lovePat".toCharArray());
        factory.setConnectionOptions(options);
        return factory;
    }

    @Transformer(inputChannel = "mqttInputChannel", outputChannel = "processedInputChannel")
    public SaveMeasurementCommand transform(String payload) {
        try {
            return objectMapper.readValue(payload, SaveMeasurementCommand.class);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Bean
    public MessageProducer incoming() {
        var adapter = new MqttPahoMessageDrivenChannelAdapter(
                "wattwatcher",
                mqttClientFactory(),
                "sdmMeasurement/all"
        );
        adapter.setCompletionTimeout(5000);
        adapter.setConverter(new DefaultPahoMessageConverter());
        adapter.setQos(0);
        adapter.setOutputChannel(mqttInputChannel());
        return adapter;
    }

}
