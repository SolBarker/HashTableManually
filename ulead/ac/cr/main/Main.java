package ulead.ac.cr.main;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner input = new Scanner(System.in);
		Lista miLista = new Lista();
		Menu();
		switch (input.nextInt()) {
		case 1:
			miLista.CargarDatos();
		case 2:
			System.out.println(
					"Programa Incompleto. No se logro hacer listas en el Array, solo guardar la informacion y si entra nueva se remplaza el dato existente en el array");

			break;
		}
	}

	private static void Menu() {
		System.out.println("Bienvenido");
		System.out.println("1. Cargar datos");
		System.out.println("2. Ingresar posiccion a buscar");

	}

}
