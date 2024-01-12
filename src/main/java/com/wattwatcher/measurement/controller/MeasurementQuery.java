package com.wattwatcher.measurement.controller;

import java.time.Instant;
import java.util.UUID;

public record MeasurementQuery(
        UUID id,
        Instant timestamp,
        Double voltage,
        Double current,
        Double powerActive,
        Double powerApparent,
        Double powerReactive,
        Double powerFactor,
        Double phaseAngle,
        Double frequency,
        Double importEnergyActive,
        Double exportEnergyActive,
        Double importEnergyReactive,
        Double exportEnergyReactive,
        Double totalDemandPowerActive,
        Double maximumTotalDemandPowerActive,
        Double importDemandPowerActive,
        Double maximumImportDemandPowerActive,
        Double exportDemandPowerActive,
        Double maximumExportDemandPowerActive,
        Double totalDemandCurrent,
        Double maximumTotalDemandCurrent,
        Double totalEnergyActive,
        Double totalEnergyReactive
) {
}
