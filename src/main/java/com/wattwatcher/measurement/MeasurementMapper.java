package com.wattwatcher.measurement;

public class MeasurementMapper {

    public static SaveMeasurementCommand toSaveMeasurementCommand(Measurement measurement) {
        return new SaveMeasurementCommand(
                measurement.getId(),
                measurement.getTimestamp(),
                measurement.getVoltage(),
                measurement.getCurrent(),
                measurement.getPowerActive(),
                measurement.getPowerApparent(),
                measurement.getPowerReactive(),
                measurement.getPowerFactor(),
                measurement.getPhaseAngle(),
                measurement.getFrequency(),
                measurement.getImportEnergyActive(),
                measurement.getExportEnergyActive(),
                measurement.getImportEnergyReactive(),
                measurement.getExportEnergyReactive(),
                measurement.getTotalDemandPowerActive(),
                measurement.getMaximumTotalDemandPowerActive(),
                measurement.getImportDemandPowerActive(),
                measurement.getMaximumImportDemandPowerActive(),
                measurement.getExportDemandPowerActive(),
                measurement.getMaximumExportDemandPowerActive(),
                measurement.getTotalDemandCurrent(),
                measurement.getMaximumTotalDemandCurrent(),
                measurement.getTotalEnergyActive(),
                measurement.getTotalEnergyReactive()
        );
    }
}
