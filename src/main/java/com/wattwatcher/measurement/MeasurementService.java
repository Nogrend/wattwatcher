package com.wattwatcher.measurement;

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

    public List<MeasurementDTO> findAll() {
        List<Measurement> measurements = measurementRepository.findAll();
        return measurements.stream()
                .map(this::convertMeasurementToMeasurementDTO)
                .collect(Collectors.toList());
    }

    private MeasurementDTO convertMeasurementToMeasurementDTO(Measurement measurement) {
        return MeasurementDTO.builder()
                .id(measurement.getId())
                .timestamp(measurement.getTimestamp())
                .voltage(measurement.getVoltage())
                .current(measurement.getCurrent())
                .powerActive(measurement.getPowerActive())
                .powerApparent(measurement.getPowerApparent())
                .powerReactive(measurement.getPowerReactive())
                .powerFactor(measurement.getPowerFactor())
                .phaseAngle(measurement.getPhaseAngle())
                .frequency(measurement.getFrequency())
                .importEnergyActive(measurement.getImportEnergyActive())
                .exportEnergyActive(measurement.getExportEnergyActive())
                .importEnergyReactive(measurement.getImportEnergyReactive())
                .exportEnergyReactive(measurement.getExportEnergyReactive())
                .totalDemandPowerActive(measurement.getTotalDemandPowerActive())
                .maximumTotalDemandPowerActive(measurement.getMaximumTotalDemandPowerActive())
                .importDemandPowerActive(measurement.getImportDemandPowerActive())
                .maximumImportDemandPowerActive(measurement.getMaximumImportDemandPowerActive())
                .exportDemandPowerActive(measurement.getExportDemandPowerActive())
                .maximumExportDemandPowerActive(measurement.getMaximumExportDemandPowerActive())
                .totalDemandCurrent(measurement.getTotalDemandCurrent())
                .maximumTotalDemandCurrent(measurement.getMaximumTotalDemandCurrent())
                .totalEnergyActive(measurement.getTotalEnergyActive())
                .totalEnergyReactive(measurement.getTotalEnergyReactive())
                .build();
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