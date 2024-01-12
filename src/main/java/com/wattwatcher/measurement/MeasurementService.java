package com.wattwatcher.measurement;

import com.wattwatcher.measurement.controller.MeasurementQuery;
import com.wattwatcher.measurement.controller.SaveMeasurementCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MeasurementService {

    private final MeasurementRepository measurementRepository;

    @Autowired
    public MeasurementService(MeasurementRepository measurementRepository) {
        this.measurementRepository = measurementRepository;
    }

    public List<MeasurementQuery> findAll() {
        var measurements = measurementRepository.findAll();
        return measurements.stream()
                .map(this::convertMeasurementToMeasurementQuery)
                .collect(Collectors.toList());
    }

    private MeasurementQuery convertMeasurementToMeasurementQuery(Measurement measurement) {
        return new MeasurementQuery(
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


    public void saveMeasurement(SaveMeasurementCommand command) {
        var measurement = new Measurement(
                command.id(),
                command.timestamp(),
                command.voltage(),
                command.current(),
                command.powerActive(),
                command.powerApparent(),
                command.powerReactive(),
                command.powerFactor(),
                command.phaseAngle(),
                command.frequency(),
                command.importEnergyActive(),
                command.exportEnergyActive(),
                command.importEnergyReactive(),
                command.exportEnergyReactive(),
                command.totalDemandPowerActive(),
                command.maximumTotalDemandPowerActive(),
                command.importDemandPowerActive(),
                command.maximumImportDemandPowerActive(),
                command.exportDemandPowerActive(),
                command.maximumExportDemandPowerActive(),
                command.totalDemandCurrent(),
                command.maximumTotalDemandCurrent(),
                command.totalEnergyActive(),
                command.totalEnergyReactive()
        );
        measurementRepository.save(measurement);
    }
}