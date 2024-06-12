package com.example.tpo;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.tpo.accessingdatamongodb.Carrito.*;
import com.example.tpo.accessingdatamongodb.Factura.*;
import com.example.tpo.accessingdatamongodb.Pago.*;
import com.example.tpo.accessingdatamongodb.Pedido.*;
import com.example.tpo.accessingdatamongodb.Producto.*;
import com.example.tpo.accessingdatamongodb.RegistroActividad.*;
import com.example.tpo.accessingdatamongodb.Usuario.*;

@SpringBootApplication
public class GestionPedidos implements CommandLineRunner {

	// Crea servicios
	private final UsuarioServicio servicioUsuario;
	private final ProductoServicio servicioProducto;
	private final RegistroActividadServicio servicioRegistroActividad;
	private final CarritoServicio servicioCarrito;
	private final PedidoServicio servicioPedido;
	private final FacturaServicio servicioFactura;
	private final PagoServicio servicioPago;

	// Constructor de clases de servicios
	public GestionPedidos(UsuarioServicio servicioUsuario, ProductoServicio servicioProducto, RegistroActividadServicio servicioRegistroActividad, CarritoServicio servicioCarrito,PedidoServicio servicioPedido, FacturaServicio servicioFactura, PagoServicio servicioPago) {
		this.servicioUsuario = servicioUsuario;
		this.servicioProducto = servicioProducto;
		this.servicioRegistroActividad = servicioRegistroActividad;
		this.servicioCarrito = servicioCarrito;
		this.servicioPedido = servicioPedido;
		this.servicioFactura = servicioFactura;
		this.servicioPago = servicioPago;
	}

	public static void main(String[] args) {		// Inicia el programa
		SpringApplication.run(GestionPedidos.class, args);
	}

	@Override
	public void run(String... args) throws Exception {	// Corre el programa

		// Borra todo para hacer PRUEBAS
		servicioUsuario.deleteAllUsuarios();
		servicioProducto.deleteAllProductos();
		servicioRegistroActividad.deleteAllRegistros();
		servicioCarrito.deleteAllCarritos();
		servicioPedido.deleteAllPedidos();
		servicioFactura.deleteAllFacturas();
		servicioPago.deleteAllPagos();
		


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

		// Crea un carrito con la coca cola actualizada
		ItemCarrito item1 = new ItemCarrito(coca_cola_actualizada.getId(), 2, coca_cola_actualizada.getPrecio());
		Carrito carrito_coca = new Carrito("66691c39fd538f2d3f2985ad", Arrays.asList(item1));
		servicioCarrito.createCarrito(carrito_coca);

		// Crea un pedido con el carrito
		Pedido pedido_coca = servicioPedido.createPedido(carrito_coca.getId(), 50, 100);

		// Crea una factura con el pedido
		Factura factura_coca = servicioFactura.createFactura(pedido_coca.getId(), "TARJETA DE CREDITO");
		servicioFactura.persistFactura(factura_coca.getId());

		// Crea un pago con la factura
		servicioPago.createPago(factura_coca.getId(), "TARJETA DE CREDITO", "Gabriel Diaz");

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
		System.out.println(servicioCarrito.getAllCarritos()); // Muestra todos los carritos
		System.out.println();
		System.out.println();
		System.out.println(servicioPedido.getAllPedidos()); // Muestra todos los carritos
		System.out.println();
		System.out.println();
		System.out.println(servicioFactura.getAllFacturas()); // Muestra todas las facturas
		System.out.println();
		System.out.println();
		System.out.println(servicioPago.getAllPagos()); // Muestra todos los carritos
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
