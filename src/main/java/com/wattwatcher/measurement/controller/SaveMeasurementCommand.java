package com.wattwatcher.measurement.controller;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;

import java.time.Instant;
import java.util.UUID;

public record SaveMeasurementCommand(
        @NotNull(message = "ID is mandatory") UUID id, Instant timestamp, Double voltage,
        Double current, @JsonProperty("power_active") Double powerActive,

        @JsonProperty("power_apparent") Double powerApparent,

        @JsonProperty("power_reactive") Double powerReactive,

        @JsonProperty("power_factor") Double powerFactor,

        @JsonProperty("phase_angle") Double phaseAngle,

        @JsonProperty("frequency") Double frequency,

        @JsonProperty("import_energy_active") Double importEnergyActive,

        @JsonProperty("export_energy_active") Double exportEnergyActive,

        @JsonProperty("import_energy_reactive") Double importEnergyReactive,

        @JsonProperty("export_energy_reactive") Double exportEnergyReactive,

        @JsonProperty("total_demand_power_active") Double totalDemandPowerActive,

        @JsonProperty("maximum_total_demand_power_active") Double maximumTotalDemandPowerActive,

        @JsonProperty("import_demand_power_active") Double importDemandPowerActive,

        @JsonProperty("maximum_import_demand_power_active") Double maximumImportDemandPowerActive,

        @JsonProperty("export_demand_power_active") Double exportDemandPowerActive,

        @JsonProperty("maximum_export_demand_power_active") Double maximumExportDemandPowerActive,

        @JsonProperty("total_demand_current") Double totalDemandCurrent,

        @JsonProperty("maximum_total_demand_current") Double maximumTotalDemandCurrent,

        @JsonProperty("total_energy_active") Double totalEnergyActive,

        @JsonProperty("total_energy_reactive") Double totalEnergyReactive) {
}



