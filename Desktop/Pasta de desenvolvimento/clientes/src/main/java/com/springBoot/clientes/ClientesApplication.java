package com.springBoot.clientes;



import com.springBoot.clientes.model.entity.Cliente;
import com.springBoot.clientes.model.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import static org.springframework.boot.SpringApplication.run;

@SpringBootApplication
public class ClientesApplication {

   
    public static void main(String[] args) {
       run(ClientesApplication.class, args);

    }


}
