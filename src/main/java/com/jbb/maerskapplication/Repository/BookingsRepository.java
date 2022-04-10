package com.jbb.maerskapplication.Repository;

import com.jbb.maerskapplication.Entity.Bookings;
import org.springframework.data.cassandra.repository.CassandraRepository;

import java.util.UUID;

public interface BookingsRepository extends CassandraRepository<Bookings, UUID> {
}
