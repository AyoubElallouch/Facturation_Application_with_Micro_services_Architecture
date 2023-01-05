package com.example.factureservice;

import com.example.factureservice.entities.Article;
import com.example.factureservice.entities.Facture;
import com.example.factureservice.models.Client;
import com.example.factureservice.models.Product;
import com.example.factureservice.repositories.FactureRepo;
import com.example.factureservice.repositories.ArticleRepo;
import com.example.factureservice.services.ClientRestService;
import com.example.factureservice.services.ProductRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.hateoas.PagedModel;


import java.util.*;

@SpringBootApplication
@EnableFeignClients
public class FactureServiceApplication implements CommandLineRunner {

    @Autowired
    FactureRepo factureRepo;
    @Autowired
    ArticleRepo productItemRepo;
    @Autowired
    ClientRestService clientRestService;
    @Autowired
    ProductRestService productRestService;
    public static void main(String[] args) {
        SpringApplication.run(FactureServiceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Collection<Product> listeProduitsDB = productRestService.listProducts().getContent();
        for(int i = 1; i<4; i++){
            Client client = clientRestService.findClientById((long) i);
            Facture facture = new Facture();
            facture.setReference(UUID.randomUUID().toString().substring(0,12));
            facture.setFactureDate(new Date());
            facture.setClientId(client.getId());
            facture.setClient(client);
            factureRepo.save(facture);

            listeProduitsDB.forEach(p -> {
                Article article = new Article();
                article.setProductId(p.getId());
                article.setProduct(p);
                article.setFacture(facture);
                article.setQuantity(1 + new Random().nextInt(10));
                article.setUnitePrice(p.getPrix());
                article.setSubTotal(p.getPrix() * article.getQuantity());
                facture.setPrixTotal(article.getSubTotal()+ facture.getPrixTotal());
                productItemRepo.save(article);
                factureRepo.save(facture);
            });

        }


    }
}
