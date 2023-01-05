package com.example.factureservice.services;

import com.example.factureservice.models.Client;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "CLIENT-SERVICE")
public interface ClientRestService {
    @GetMapping(path = "/clients/{id}")
    Client findClientById(@PathVariable Long id);
}
