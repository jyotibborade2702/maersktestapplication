package com.jbb.maerskapplication.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.UUID;

@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Bookings {
    @PrimaryKey
    @Column("BOOKING_REF")
    private UUID bookingRef;
    @Column("CONTAINER_TYPE")
    private String containerType;
    @Column("ORIGIN")
    private String origin;
    @Column("DESTINATION")
    private String destination;
    @Column("QUANTITY")
    private Integer quantity;
    @Column("TIMESTAMP")
    private String timestamp;
}
