package com.wattwatcher.measurement.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wattwatcher.measurement.MeasurementService;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.MessageHandler;
import org.springframework.stereotype.Controller;


@Controller
public class MeasurementMessageHandler {

    private final ObjectMapper objectMapper;
    private final MeasurementService measurementService;

    public MeasurementMessageHandler(ObjectMapper objectMapper, MeasurementService measurementService) {
        this.objectMapper = objectMapper;
        this.measurementService = measurementService;
    }


    @Bean
    @ServiceActivator(inputChannel = "mqttInputChannel")
    public MessageHandler handler() {
        return message -> {
            var payload = message.getPayload();
            try {
                var saveMeasurementCommand = objectMapper.readValue((String) payload, SaveMeasurementCommand.class);
                measurementService.saveMeasurement(saveMeasurementCommand);
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        };
    }
}