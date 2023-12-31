package com.wattwatcher.measurement;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.UUID;

@Entity(name = "measurement")
@Table(name = "measurements")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Measurement {
    @Id
    private UUID id;
    private Instant timestamp;
    private double voltage;
    private double current;
    private double powerActive;
    private double powerApparent;
    private double powerReactive;
    private double powerFactor;
    private double phaseAngle;
    private double frequency;
    private double importEnergyActive;
    private double exportEnergyActive;
    private double importEnergyReactive;
    private double exportEnergyReactive;
    private double totalDemandPowerActive;
    private double maximumTotalDemandPowerActive;
    private double importDemandPowerActive;
    private double maximumImportDemandPowerActive;
    private double exportDemandPowerActive;
    private double maximumExportDemandPowerActive;
    private double totalDemandCurrent;
    private double maximumTotalDemandCurrent;
    private double totalEnergyActive;
    private double totalEnergyReactive;
}

