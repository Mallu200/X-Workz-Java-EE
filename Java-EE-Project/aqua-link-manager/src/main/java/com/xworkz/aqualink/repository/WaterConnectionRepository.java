package com.xworkz.aqualink.repository;

import com.xworkz.aqualink.entity.WaterConnectionEntity;
import java.util.List;
import java.util.Optional;

/**
 * Repository Interface for AquaLink.
 * Focus: Pure CRUD operations and MySQL Query logic.
 */
public interface WaterConnectionRepository {

    /**
     * Persists a new connection entity into the water_connections table.
     */
    boolean save(WaterConnectionEntity entity);

    /**
     * Updates an existing record.
     */
    boolean update(WaterConnectionEntity entity);

    /**
     * Optimized update for meter readings.
     * Essential for JTA Transaction testing and high-performance updates.
     */
    boolean updateReading(int id, double newReading);

    /**
     * Retrieves an entity by Primary Key.
     * Returns Optional to prevent NullPointerExceptions in the Service layer.
     */
    Optional<WaterConnectionEntity> findById(int id);

    /**
     * Retrieves a connection using the unique Meter Number.
     */
    Optional<WaterConnectionEntity> findByMeterNumber(String meterNumber);

    /**
     * Retrieves all registered water connections.
     */
    List<WaterConnectionEntity> findAll();

    /**
     * Performs a search using the Consumer's name (likely using a LIKE query).
     */
    List<WaterConnectionEntity> findByConsumerName(String name);

    /**
     * Removes a record from MySQL by its ID.
     */
    boolean deleteById(int id);
}