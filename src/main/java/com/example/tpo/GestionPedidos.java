package com.example.tpo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GestionPedidos implements CommandLineRunner {

	public static void main(String[] args) {		// Inicia el programa
		SpringApplication.run(GestionPedidos.class, args);
	}

	@Override
	public void run(String... args) throws Exception {	// Corre el programa
		System.out.println("----------------------------------------------------");
		System.out.println("Gestion de Pedidos");
		System.out.println("----------------------------------------------------");
	}
}
