package com.xworkz.jsonb;

import com.xworkz.jsonb.dto.ProductDTO;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import java.time.LocalDate;

public class JSONBRunner {
    public static void main(String[] args) {

        // 1. Initialize JSON-B
        Jsonb jsonb = JsonbBuilder.create();

        // 2. Create an Object (Java -> JSON)
        ProductDTO product = new ProductDTO();
        product.setId(101);
        product.setName("Industrial Transformer");
        product.setPrice(45000.0);
        product.setInternalSecretCode("SEC-998");
        product.setExpiryDate(LocalDate.of(2030, 12, 31));

        // --- SERIALIZATION ---
        String jsonResult = jsonb.toJson(product);
        System.out.println("Generated JSON:");
        System.out.println(jsonResult);

        // --- DESERIALIZATION (JSON -> Java) ---
        String inputJson = "{\"item_name\":\"Copper Coil\",\"price\":500.0,\"product_id\":202}";
        ProductDTO importedProduct = jsonb.fromJson(inputJson, ProductDTO.class);

        System.out.println("\nImported Object from JSON:");
        System.out.println("ID: " + importedProduct.getId());
        System.out.println("Name: " + importedProduct.getName());
    }
}
