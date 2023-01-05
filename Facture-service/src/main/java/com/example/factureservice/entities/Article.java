package com.example.factureservice.entities;

import com.example.factureservice.models.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long productId;
    @ManyToOne
    private Facture facture;
    private int quantity;
    private double unitePrice;
    private double subTotal;
    @Transient
    private Product product;
}
