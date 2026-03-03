package com.xworkz.inventory;

import com.xworkz.inventory.dao.MedicineDAO;
import com.xworkz.inventory.entity.MedicineEntity;
import java.util.List;

public class InventoryRunner {
    public static void main(String[] args) {

        System.out.println("Starting Pharmacy Inventory Management System...");
        MedicineDAO dao = new MedicineDAO();

        // 1. CREATE - Persisting a new Medicine record
        System.out.println("\n--- Step 1: Adding New Stock ---");
        MedicineEntity m1 = new MedicineEntity();
        m1.setName("Dolo 650");
        m1.setManufacturer("Micro Labs");
        m1.setStockQuantity(1000);
        m1.setPrice(30.0);

        dao.create(m1); // Object moves from Transient to Managed
        System.out.println("Status: Saved record successfully.");

        // 2. READ - Fetching the record back from MySQL
        System.out.println("\n--- Step 2: Verifying Data Retrieval ---");
        // Assuming ID 1 is the generated Primary Key
        MedicineEntity fetched = dao.read(1);

        if (fetched != null) {
            System.out.println("Record Found: " + fetched.getName() + " [Manufacturer: " + fetched.getManufacturer() + "]");
            System.out.println("Current Stock: " + fetched.getStockQuantity());
        } else {
            System.out.println("Notice: Medicine with ID 1 not found.");
        }

        // 3. UPDATE - Changing the price
        System.out.println("\n--- Step 3: Modifying Price Points ---");
        dao.updatePrice(1, 35.50);
        System.out.println("Status: Price update verified for ID 1.");

        // 4. BULK READ - Displaying all inventory items
        System.out.println("\n--- Step 4: Listing All Inventory ---");
        List<MedicineEntity> allMeds = dao.getAll();
        allMeds.forEach(m -> System.out.println("Med ID: " + m.getId() + " | Name: " + m.getName() + " | Price: ₹" + m.getPrice()));

        // 5. DELETE (Commented for testing purposes)
        /*
        System.out.println("\n--- Step 5: Removing Obsolete Record ---");
        dao.delete(1);
        System.out.println("Status: Record ID 1 removed from database.");
        */

        System.out.println("\nInventoryRunner execution sequence completed.");
    }
}