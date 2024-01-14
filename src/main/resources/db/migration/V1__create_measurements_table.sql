CREATE TABLE measurements
(
    id                                 UUID             NOT NULL,
    timestamp                          TIMESTAMP WITHOUT TIME ZONE,
    device_id                          VARCHAR(20),
    power_active                       DOUBLE PRECISION NOT NULL,
    total_energy_active                DOUBLE PRECISION NOT NULL,
    CONSTRAINT pk_measurements PRIMARY KEY (id)
);
