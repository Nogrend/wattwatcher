package com.wattwatcher.measurement.controller;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.Instant;
import java.util.UUID;

public record SaveMeasurementCommand(
        UUID id,
        Instant timestamp,
        @JsonProperty("device_id")
        String deviceId,
        @JsonProperty("power_active")
        Double powerActive,
        @JsonProperty("total_energy_active")
        Double totalEnergyActive
) {
}



