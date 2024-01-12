//package com.wattwatcher.measurementOverMqtt;
//
//import jakarta.validation.constraints.NotNull;
//
//import java.time.Instant;
//import java.util.UUID;
//
//public record SaveMqttMeasurementCommand(
//        @NotNull(message = "ID is mandatory")
//        UUID id,
//        @NotNull(message = "Name is mandatory")
//        Instant timestamp,
//        double randomValue
//) {
//}
