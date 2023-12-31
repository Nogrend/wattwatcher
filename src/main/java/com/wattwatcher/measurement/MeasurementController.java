package com.wattwatcher.measurement;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/measurements")
public class MeasurementController {
    private final MeasurementService measurementService;

    public MeasurementController(MeasurementService measurementService){
        this.measurementService = measurementService;
    }

    @GetMapping
    @ResponseBody
    public List<MeasurementDTO> getMeasurements() {
        return measurementService.findAll();
    }

    @PostMapping
    public void addMeasurement(@RequestBody SaveMeasurementCommand command) {
        measurementService.saveMeasurement(command);
    }
}
