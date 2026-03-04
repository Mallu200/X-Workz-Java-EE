package com.xworkz.aqualink.repository.impl;

import com.xworkz.aqualink.entity.WaterConnectionEntity;
import com.xworkz.aqualink.repository.WaterConnectionRepository;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

public class WaterConnectionRepositoryImpl implements WaterConnectionRepository {

    @Inject
    private EntityManager entityManager;

    @Override
    public boolean save(WaterConnectionEntity entity) {
        System.out.println("Repo: Attempting to save entity for: " + entity.getConsumerName());
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(entity);
            transaction.commit();
            System.out.println("Repo: Save successful. Generated ID: " + entity.getId());
            return true;
        } catch (Exception e) {
            System.err.println("Repo Error: Save failed. Rolling back transaction.");
            if (transaction.isActive()) transaction.rollback();
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(WaterConnectionEntity entity) {
        System.out.println("Repo: Attempting update for Connection ID: " + entity.getId());
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.merge(entity);
            transaction.commit();
            System.out.println("Repo: Update committed successfully.");
            return true;
        } catch (Exception e) {
            System.err.println("Repo Error: Update failed for ID: " + entity.getId());
            if (transaction.isActive()) transaction.rollback();
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateReading(int id, double newReading) {
        System.out.println("Repo: Targeted update for Meter Reading. ID: " + id + ", New Value: " + newReading);
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            WaterConnectionEntity entity = entityManager.find(WaterConnectionEntity.class, id);
            if (entity != null) {
                entity.setCurrentReading(newReading);
                entityManager.merge(entity);
                transaction.commit();
                System.out.println("Repo: Reading updated successfully.");
                return true;
            }
            System.out.println("Repo: Update failed. No entity found with ID: " + id);
            return false;
        } catch (Exception e) {
            System.err.println("Repo Error: Reading update failed.");
            if (transaction.isActive()) transaction.rollback();
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteById(int id) {
        System.out.println("Repo: Attempting to delete record with ID: " + id);
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            WaterConnectionEntity entity = entityManager.find(WaterConnectionEntity.class, id);
            if (entity != null) {
                entityManager.remove(entity);
                transaction.commit();
                System.out.println("Repo: Record deleted successfully.");
                return true;
            }
            System.out.println("Repo: Delete failed. Record not found.");
            return false;
        } catch (Exception e) {
            System.err.println("Repo Error: Deletion failed for ID: " + id);
            if (transaction.isActive()) transaction.rollback();
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Optional<WaterConnectionEntity> findById(int id) {
        System.out.println("Repo: Finding connection by ID: " + id);
        return Optional.ofNullable(entityManager.find(WaterConnectionEntity.class, id));
    }

    @Override
    public Optional<WaterConnectionEntity> findByMeterNumber(String meterNumber) {
        System.out.println("Repo: Finding connection by Meter Number: " + meterNumber);
        TypedQuery<WaterConnectionEntity> query = entityManager.createQuery(
                "SELECT w FROM WaterConnectionEntity w WHERE w.meterNumber = :meter",
                WaterConnectionEntity.class);
        query.setParameter("meter", meterNumber);
        return query.getResultList().stream().findFirst();
    }

    @Override
    public List<WaterConnectionEntity> findAll() {
        System.out.println("Repo: Fetching all water connection records.");
        return entityManager.createQuery("SELECT w FROM WaterConnectionEntity w",
                WaterConnectionEntity.class).getResultList();
    }

    @Override
    public List<WaterConnectionEntity> findByConsumerName(String name) {
        System.out.println("Repo: Searching connections for name containing: " + name);
        TypedQuery<WaterConnectionEntity> query = entityManager.createQuery(
                "SELECT w FROM WaterConnectionEntity w WHERE w.consumerName LIKE :name",
                WaterConnectionEntity.class);
        query.setParameter("name", "%" + name + "%");
        return query.getResultList();
    }
}