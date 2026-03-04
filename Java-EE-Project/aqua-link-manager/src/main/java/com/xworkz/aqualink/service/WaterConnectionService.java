package com.xworkz.aqualink.service;

import com.xworkz.aqualink.dto.WaterConnectionDTO;
import java.util.List;
import java.util.Optional;

/**
 * Service Layer Interface for AquaLink.
 * This defines the 'Contract' for all business operations.
 */
public interface WaterConnectionService {

    /**
     * Business Logic: Validates the DTO (using your ValidationUtil)
     * before calling the Repository to persist in MySQL.
     */
    boolean validateAndSave(WaterConnectionDTO dto);

    /**
     * Business Logic: Ensures the connection exists before updating.
     */
    boolean validateAndUpdate(WaterConnectionDTO dto);

    /**
     * Logic: Specific update for meter readings—could trigger
     * a JTA Transaction or a bill generation logic.
     */
    boolean updateMeterReading(int id, double newReading);

    // --- READ Operations ---

    // Optional prevents null issues if an ID doesn't exist in the database
    Optional<WaterConnectionDTO> getById(int id);

    Optional<WaterConnectionDTO> getByMeterNumber(String meterNumber);

    List<WaterConnectionDTO> getAll();

    List<WaterConnectionDTO> searchByConsumerName(String name);

    // --- DELETE Operations ---

    boolean removeById(int id);
}