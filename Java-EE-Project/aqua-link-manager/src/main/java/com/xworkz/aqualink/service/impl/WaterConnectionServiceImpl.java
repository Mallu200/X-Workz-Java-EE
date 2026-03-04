package com.xworkz.aqualink.service.impl;

import com.xworkz.aqualink.dto.WaterConnectionDTO;
import com.xworkz.aqualink.entity.WaterConnectionEntity;
import com.xworkz.aqualink.repository.WaterConnectionRepository;
import com.xworkz.aqualink.service.WaterConnectionService;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Service Implementation for AquaLink.
 * Handles Business Logic, Transaction Management, and DTO-Entity Mapping.
 */
public class WaterConnectionServiceImpl implements WaterConnectionService {

    @Inject
    private WaterConnectionRepository repository;

    @Override
    @Transactional // JTA: Ensures atomicity for the save operation
    public boolean validateAndSave(WaterConnectionDTO dto) {
        System.out.println("Service: validateAndSave for -> " + dto.getConsumerName());
        if (dto != null) {
            WaterConnectionEntity entity = new WaterConnectionEntity();
            copyDtoToEntity(dto, entity);
            entity.setActive(true);
            return repository.save(entity);
        }
        return false;
    }

    @Override
    @Transactional // JTA: Rolls back if the repository update fails
    public boolean validateAndUpdate(WaterConnectionDTO dto) {
        System.out.println("Service: validateAndUpdate for ID -> " + dto.getId());
        if (dto != null && dto.getId() > 0) {
            WaterConnectionEntity entity = new WaterConnectionEntity();
            copyDtoToEntity(dto, entity);
            return repository.update(entity);
        }
        return false;
    }

    @Override
    @Transactional
    public boolean updateMeterReading(int id, double newReading) {
        System.out.println("Service: Updating Meter Reading for ID: " + id + " to: " + newReading);
        if (id > 0 && newReading >= 0) {
            return repository.updateReading(id, newReading);
        }
        return false;
    }

    @Override
    public Optional<WaterConnectionDTO> getById(int id) {
        // map() automatically applies copyEntityToDto ONLY if findById returns data
        return repository.findById(id).map(this::copyEntityToDto);
    }

    @Override
    public Optional<WaterConnectionDTO> getByMeterNumber(String meterNumber) {
        return repository.findByMeterNumber(meterNumber).map(this::copyEntityToDto);
    }

    @Override
    public List<WaterConnectionDTO> getAll() {
        System.out.println("Service: Fetching all water connections...");
        return repository.findAll().stream()
                .map(this::copyEntityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<WaterConnectionDTO> searchByConsumerName(String name) {
        return repository.findByConsumerName(name).stream()
                .map(this::copyEntityToDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public boolean removeById(int id) {
        System.out.println("Service: Attempting to remove connection ID: " + id);
        return repository.deleteById(id);
    }

    // --- MAPPING LOGIC (The Bridge between DB and UI) ---

    private void copyDtoToEntity(WaterConnectionDTO dto, WaterConnectionEntity entity) {
        entity.setId(dto.getId());
        entity.setConsumerName(dto.getConsumerName());
        entity.setMeterNumber(dto.getMeterNumber());
        entity.setCurrentReading(dto.getCurrentReading());
        entity.setType(dto.getType());
        entity.setActive(dto.isActive());
    }

    private WaterConnectionDTO copyEntityToDto(WaterConnectionEntity entity) {
        WaterConnectionDTO dto = new WaterConnectionDTO();
        dto.setId(entity.getId());
        dto.setConsumerName(entity.getConsumerName());
        dto.setMeterNumber(entity.getMeterNumber());
        dto.setCurrentReading(entity.getCurrentReading());
        dto.setType(entity.getType());
        dto.setActive(entity.isActive());
        return dto;
    }
}