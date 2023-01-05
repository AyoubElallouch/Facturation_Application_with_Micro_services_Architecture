package com.example.factureservice.repositories;

import com.example.factureservice.entities.Facture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FactureRepo extends JpaRepository<Facture, Long> {
}
