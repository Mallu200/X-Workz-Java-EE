package com.xworkz.jsonb.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.json.bind.annotation.JsonbDateFormat;
import javax.json.bind.annotation.JsonbProperty;
import javax.json.bind.annotation.JsonbTransient;
import java.time.LocalDate;

@Data @NoArgsConstructor @AllArgsConstructor
public class ProductDTO {

    @JsonbProperty("product_id")
    private int id;

    @JsonbProperty("item_name")
    private String name;

    private double price;

    @JsonbTransient
    private String internalSecretCode;

    @JsonbDateFormat("dd-MM-yyyy")
    private LocalDate expiryDate;
}
