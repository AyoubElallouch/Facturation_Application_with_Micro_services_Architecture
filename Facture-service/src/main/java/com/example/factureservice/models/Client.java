package com.example.factureservice.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class Client {
    private Long id;
    private String name;
    private String email;
}
