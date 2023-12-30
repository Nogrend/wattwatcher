package com.wattwatcher.measurementcollection;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;

import java.time.Instant;
import java.util.UUID;

@Builder
@Getter
public class CollectionDTO {
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
