CREATE TABLE "mqtt-measurement"
(
    id           UUID             NOT NULL,
    timestamp    TIMESTAMP WITHOUT TIME ZONE,
    random_value DOUBLE PRECISION NOT NULL,
    CONSTRAINT "pk_mqtt-measurement" PRIMARY KEY (id)
);