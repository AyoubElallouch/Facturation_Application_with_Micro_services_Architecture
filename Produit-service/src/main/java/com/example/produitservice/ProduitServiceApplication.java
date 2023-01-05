package com.example.produitservice;

import com.example.produitservice.entities.Product;
import com.example.produitservice.repositories.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class ProduitServiceApplication implements CommandLineRunner {
    @Autowired
    RepositoryRestConfiguration repositoryRestConfiguration;
    @Autowired
    ProductRepo productRepo;

    public static void main(String[] args) {
        SpringApplication.run(ProduitServiceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        repositoryRestConfiguration.exposeIdsFor(Product.class);
        productRepo.save(new Product(null, "Samsung Watch 5", "SMGW5", 2500.00));
        productRepo.save(new Product(null, "Samsung Galaxy S22", "SMGG20", 9500.00));
        productRepo.save(new Product(null, "Samsung Galaxy Z Fold 4", "SMGZF4", 11000.00));
        productRepo.save(new Product(null, "Samsung Neo QLED 8K", "SMGNQ8", 21000.00));

    }
}
