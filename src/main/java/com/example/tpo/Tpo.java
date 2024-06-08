package com.example.tpo;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.tpo.accessingdatamongodb.Producto.*;
import com.example.tpo.accessingdatamongodb.RegistroActividad.*;
import com.example.tpo.accessingdatamongodb.Usuario.*;

@SpringBootApplication
public class Tpo implements CommandLineRunner {

	// Crea servicios
	private final UsuarioServicio servicioUsuario;
	private final ProductoServicio servicioProducto;
	private final RegistroActividadServicio servicioRegistroActividad;


	// Constructor de clases de servicios
	public Tpo(UsuarioServicio servicioUsuario, ProductoServicio servicioProducto, RegistroActividadServicio servicioRegistroActividad) {
		this.servicioUsuario = servicioUsuario;
		this.servicioProducto = servicioProducto;
		this.servicioRegistroActividad = servicioRegistroActividad;

	}

	public static void main(String[] args) {		// Inicia el programa
		SpringApplication.run(Tpo.class, args);
	}

	@Override
	public void run(String... args) throws Exception {	// Corre el programa

		// Borra todo para hacer PRUEBAS
		servicioUsuario.deleteAllUsuarios();
		servicioProducto.deleteAllProductos();
		servicioRegistroActividad.deleteAllRegistros();


		// Guarda algunas instancias
		servicioUsuario.createUsuario(new Usuario("Charlie", "Smith", "Guido Spano 5684", "46821497", 20));
		servicioProducto.createProducto(new Producto("Coca Cola", "Bebida gaseosa", 100.0, null, null, Arrays.asList("Muy rica", "Me encanta")));

		//Muestra el producto creado
		System.out.println();
		System.out.println("-------------------------------------------------------------------");
		System.out.println("Documents found using Services");
		System.out.println("-------------------------------------------------------------------");
		System.out.println();

		System.out.println(servicioProducto.getAllProductos());

		// Actualiza la instancia Coca Cola
		Producto coca_cola_actualizada = new Producto("Coca Cola", "Bebida gaseosa grande", 250, null, null, Arrays.asList("Muy rica", "Me encanta"));
		servicioProducto.updateProducto(servicioProducto.getProductoByNombre("Coca Cola").getId(), coca_cola_actualizada, "Gabriel Diaz");

		// Muestra todo lo generado
		System.out.println();
		System.out.println("-------------------------------------------------------------------");
		System.out.println("Documents found using Services");
		System.out.println("-------------------------------------------------------------------");
		System.out.println();

		System.out.println(servicioUsuario.getAllUsuarios()); // Muestra todos los usuarios
		System.out.println();
		System.out.println(servicioProducto.getAllProductos()); // Muestra todos los productos
		System.out.println();
		System.out.println(servicioRegistroActividad.getAllRegistros()); // Muestra todos los registros de actividad
		System.out.println();

		

		
		/*
		// fetch an individual customer
		System.out.println("Customer found with findByFirstName('Alice'):");
		System.out.println("--------------------------------");
		System.out.println(repositorioUsuario.findByNombre("Alice"));

		System.out.println("Customers found with findByLastName('Smith'):");
		System.out.println("--------------------------------");
		for (Usuario usuario : repositorioUsuario.findByApellido("Smith")) {
			System.out.println(usuario);
		}
		*/
	}
}
