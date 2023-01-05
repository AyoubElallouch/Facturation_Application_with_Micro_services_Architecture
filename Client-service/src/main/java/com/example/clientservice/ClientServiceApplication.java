package com.example.clientservice;

import com.example.clientservice.entities.Client;
import com.example.clientservice.repositories.ClientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class ClientServiceApplication implements CommandLineRunner {
    @Autowired
    ClientRepo clientRepo;
    @Autowired
    RepositoryRestConfiguration repositoryRestConfiguration;

    public static void main(String[] args) {
        SpringApplication.run(ClientServiceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        repositoryRestConfiguration.exposeIdsFor(Client.class);
        for(int i=0; i<5; i++){
            clientRepo.save(new Client(null, "Client"+i, "Client"+i+"@Gmail.com"));
        }
    }
}
