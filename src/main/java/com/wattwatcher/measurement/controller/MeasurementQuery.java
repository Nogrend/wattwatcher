package com.wattwatcher.measurement.controller;

import java.time.Instant;
import java.util.UUID;

public record MeasurementQuery(
        UUID id,
        Instant timestamp,
        Double powerActive,
        Double totalEnergyActive
) {
}
