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
    private String deviceId;
    private Double powerActive;
    private Double totalEnergyActive;
}