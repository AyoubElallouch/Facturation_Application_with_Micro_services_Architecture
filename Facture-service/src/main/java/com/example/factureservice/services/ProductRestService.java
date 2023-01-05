package com.example.factureservice.services;

import com.example.factureservice.models.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "PRODUCT-SERVICE")
public interface ProductRestService {
    @GetMapping(path = "/products/{id}")
    Product findProductById(@PathVariable Long id);
    @GetMapping(path = "/products")
    PagedModel<Product> listProducts();
    @GetMapping(path = "/products")
    PagedModel<Product> listProducts(@RequestParam(value ="page") int page,
                                     @RequestParam(value = "taille") int taille);
}
