package com.wattwatcher.measurement;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.UUID;

@Entity(name = "measurement")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Measurement {
    @Id
    private UUID id;
    private Instant timestamp;
    private double voltage;
    private double current;
    @JsonProperty("power_active")
    private double powerActive;

    @JsonProperty("power_apparent")
    private double powerApparent;

    @JsonProperty("power_reactive")
    private double powerReactive;

    @JsonProperty("power_factor")
    private double powerFactor;

    @JsonProperty("phase_angle")
    private double phaseAngle;

    @JsonProperty("frequency")
    private double frequency;

    @JsonProperty("import_energy_active")
    private double importEnergyActive;

    @JsonProperty("export_energy_active")
    private double exportEnergyActive;

    @JsonProperty("import_energy_reactive")
    private double importEnergyReactive;

    @JsonProperty("export_energy_reactive")
    private double exportEnergyReactive;

    @JsonProperty("total_demand_power_active")
    private double totalDemandPowerActive;

    @JsonProperty("maximum_total_demand_power_active")
    private double maximumTotalDemandPowerActive;

    @JsonProperty("import_demand_power_active")
    private double importDemandPowerActive;

    @JsonProperty("maximum_import_demand_power_active")
    private double maximumImportDemandPowerActive;

    @JsonProperty("export_demand_power_active")
    private double exportDemandPowerActive;

    @JsonProperty("maximum_export_demand_power_active")
    private double maximumExportDemandPowerActive;

    @JsonProperty("total_demand_current")
    private double totalDemandCurrent;

    @JsonProperty("maximum_total_demand_current")
    private double maximumTotalDemandCurrent;

    @JsonProperty("total_energy_active")
    private double totalEnergyActive;

    @JsonProperty("total_energy_reactive")
    private double totalEnergyReactive;
}

