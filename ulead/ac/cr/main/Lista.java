package ulead.ac.cr.main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Lista {
	private Nodo inicio = null;
	private String codigo;
	private String nombre;
	private String categoria;
	
	@Override
	public String toString() {
		return "Lista [inicio=" + inicio + ", codigo=" + codigo + ", nombre=" + nombre + ", categoria=" + categoria
				+ ", lista=" + Arrays.toString(lista) + "]";
	}
	public Nodo[] lista = new Nodo[4096];

	public Lista(String codigo, String nombre, String categoria) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.categoria = categoria;
	}

	public Lista(Nodo inicio) {

		this.inicio = inicio;
	}

	public Lista() {

	}

	public void CargarDatos() throws FileNotFoundException {
		Scanner lector = new Scanner(new File(
				"C:\\Users\\SolanllyBarkerVargas\\eclipse-workspace\\llTareaProgramada\\src\\flipkart_com-ecommerce_sample.csv"));

		while (lector.hasNextLine()) {
			String[] datos = lector.nextLine().split(",");
			int decimal = Integer.parseInt(datos[0].substring(datos[0].length() - 3, datos[0].length()), 16);
			if (lista[decimal] != null) {
				Lista miLista = new Lista(lista[decimal]);
				miLista.agregar(new Nodo(new Lista(datos[0], datos[1], datos[2])));
			} else {
				Lista miLista = new Lista(datos[0], datos[1], datos[2]);
				lista[decimal] = miLista.agregar(new Nodo(new Lista(datos[0], datos[1], datos[2])));
			}
		}
		lector.close();

		System.out.println("DATOS CARGADOS!");
		System.out.println("-------------------------------------------");
		for(int i =0; i<4096; i++) {
			System.out.println(lista[i]);
		}
		
	}

	public Nodo agregar(Nodo nuevoNodo) {
		if (inicio == null) {
			inicio = nuevoNodo;
		} else {
			Nodo temp = inicio;
			while (temp.next != null) {
				temp = temp.next;
			}
			temp.next = nuevoNodo;
		}
		return nuevoNodo;
	}

	public void imprimirLista(Nodo[] nodo) {
		Nodo temp = inicio;
		while (temp != null) {
			System.out.println("Valor del Nodo " + temp.value);
			temp = temp.next;
		}
	}

	public boolean estaVacia() {
		return inicio == null;
	}
}
