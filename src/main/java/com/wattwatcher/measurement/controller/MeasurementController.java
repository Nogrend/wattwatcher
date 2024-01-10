package com.wattwatcher.measurement.controller;

import com.wattwatcher.measurement.MeasurementDTO;
import com.wattwatcher.measurement.MeasurementService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/measurements")
public class MeasurementController {
    private final MeasurementService measurementService;

    public MeasurementController(MeasurementService measurementService) {
        this.measurementService = measurementService;
    }

    @GetMapping
    @ResponseBody
    public List<MeasurementDTO> getMeasurements() {
        return measurementService.findAll();
    }

}
