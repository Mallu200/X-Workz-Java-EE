package com.xworkz.jsonb;

import com.xworkz.jsonb.dto.ProductDTO;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import java.time.LocalDate;

public class JSONBRunner {
    public static void main(String[] args) {

        System.out.println("Execution Started: JSONBRunner");

        // 1. Initialize JSON-B Engine
        // JsonbBuilder is the entry point for Jakarta JSON Binding
        Jsonb jsonb = JsonbBuilder.create();

        // 2. Prepare Data (Java Object)
        ProductDTO product = new ProductDTO();
        product.setId(101);
        product.setName("Industrial Transformer");
        product.setPrice(45000.0);
        product.setInternalSecretCode("SEC-998"); // This should be hidden
        product.setExpiryDate(LocalDate.of(2030, 12, 31));

        // --- STEP 1: SERIALIZATION (Object to JSON) ---
        System.out.println("\n--- Performing Serialization ---");
        String jsonResult = jsonb.toJson(product);

        System.out.println("Resulting JSON String:");
        System.out.println(jsonResult);

        // Logic Check: Verify Transient and Property annotations
        if (!jsonResult.contains("internalSecretCode")) {
            System.out.println("Verification: @JsonbTransient successfully hid the secret code.");
        }
        if (jsonResult.contains("product_id")) {
            System.out.println("Verification: @JsonbProperty correctly mapped 'id' to 'product_id'.");
        }

        // --- STEP 2: DESERIALIZATION (JSON to Object) ---
        System.out.println("\n--- Performing Deserialization ---");
        // Simulating a JSON response from a web request
        String inputJson = "{\"item_name\":\"Copper Coil\",\"price\":500.0,\"product_id\":202}";

        ProductDTO importedProduct = jsonb.fromJson(inputJson, ProductDTO.class);

        System.out.println("Imported Object State:");
        System.out.println("ID (mapped from product_id): " + importedProduct.getId());
        System.out.println("Name (mapped from item_name): " + importedProduct.getName());
        System.out.println("Price: " + importedProduct.getPrice());

        System.out.println("\nJSONBRunner process completed.");
    }
}