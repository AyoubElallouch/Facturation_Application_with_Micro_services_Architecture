package com.example.factureservice.web;

import com.example.factureservice.entities.Article;
import com.example.factureservice.entities.Facture;
import com.example.factureservice.models.Product;
import com.example.factureservice.repositories.ArticleRepo;
import com.example.factureservice.repositories.FactureRepo;
import com.example.factureservice.services.ClientRestService;
import com.example.factureservice.services.ProductRestService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FactureRestController {
    FactureRepo factureRepo;
    ClientRestService clientRestClient;
    ProductRestService produitRestClient;
    ArticleRepo produitArticleRepo;
    public FactureRestController(FactureRepo factureRepo, ClientRestService clientRestClient,
                                 ProductRestService produitRestClient, ArticleRepo produitArticleRepo) {
        this.factureRepo = factureRepo;
        this.clientRestClient = clientRestClient;
        this.produitRestClient = produitRestClient;
        this.produitArticleRepo = produitArticleRepo;
    }

    @GetMapping("/factures/{id}")
    public Facture getFacture(@PathVariable Long id){
        Facture facture = factureRepo.findById(id).get();
        facture.setClient(clientRestClient.findClientById(facture.getClientId()));
        facture.getProductList().forEach(produitArticle -> {
            Product p = produitRestClient.findProductById(produitArticle.getProductId());
            produitArticle.setProduct(p);
        });
        return facture;
    }
    @GetMapping("/factures")
    public List<Facture> getAll(){
        System.out.println("liste factures");
        return factureRepo.findAll();
    }
    @DeleteMapping("/factures/{factureId}/article/{id}")
    public void deleteItem(@PathVariable Long id, @PathVariable Long factureId){
        System.out.println(factureId);
        System.out.println(id);
        Facture facture = factureRepo.findById(factureId).get();
        List<Article> productList = facture.getProductList();
        productList.remove(id);
        facture.setProductList(productList);
        facture.setPrixTotal(0);
        for (Article p: productList) {
            facture.setPrixTotal(p.getSubTotal()+ facture.getPrixTotal());
        }
        factureRepo.save(facture);

    }
}
