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
                measurement.getPowerActive(),
                measurement.getTotalEnergyActive()
        );
    }


    public void saveMeasurement(SaveMeasurementCommand command) {
        var measurement = new Measurement(
                command.id(),
                command.timestamp(),
                command.deviceId(),
                command.powerActive(),
                command.totalEnergyActive()
        );
        measurementRepository.save(measurement);
    }
}