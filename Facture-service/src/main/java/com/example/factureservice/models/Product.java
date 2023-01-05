package com.example.factureservice.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class Product {
    private Long id ;
    private String name ;
    private String reference ;
    private Double prix ;
}
