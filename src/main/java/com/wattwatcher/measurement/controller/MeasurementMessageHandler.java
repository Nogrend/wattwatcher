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
    private final MeasurementService measurementService;

    public MeasurementMessageHandler(MeasurementService measurementService) {
        this.measurementService = measurementService;
    }

    @ServiceActivator(inputChannel = "processedInputChannel")
    public void handleMeasurement(SaveMeasurementCommand saveMeasurementCommand) {
        measurementService.saveMeasurement(saveMeasurementCommand);
    }
}