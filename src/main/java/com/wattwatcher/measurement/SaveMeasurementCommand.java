package com.wattwatcher.measurement;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.Instant;
import java.util.UUID;

public record SaveMeasurementCommand(
        @NotNull(message = "ID is mandatory")
        UUID id,
        @NotNull(message = "Name is mandatory")
        Instant timestamp,
        double voltage,
        double current,
        double powerActive,
        double powerApparent,
        double powerReactive,
        double powerFactor,
        double phaseAngle,
        double frequency,
        double importEnergyActive,
        double exportEnergyActive,
        double importEnergyReactive,
        double exportEnergyReactive,
        double totalDemandPowerActive,
        double maximumTotalDemandPowerActive,
        double importDemandPowerActive,
        double maximumImportDemandPowerActive,
        double exportDemandPowerActive,
        double maximumExportDemandPowerActive,
        double totalDemandCurrent,
        double maximumTotalDemandCurrent,
        @NotBlank
        double totalEnergyActive,
        double totalEnergyReactive
) {
}



