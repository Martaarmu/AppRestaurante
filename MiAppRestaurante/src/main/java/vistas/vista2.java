package vistas;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import model.Client.*;
import model.Order.Order;
import utils.Utilities;

public class vista2 {
	
	public static int menu1 () {
		int opcion=-1;
		System.out.println("1- Nuevo cliente");
		System.out.println("2- Buscar cliente");
		opcion = Utilities.getInt();
		return opcion;
	}
	
	public static Client newClient() {
		String dni = Utilities.getDNI();
		System.out.println("Nombre: ");
		String nombre = Utilities.getString();
		System.out.println("Edad: ");
		int edad = Utilities.getInt();
		System.out.println("Direccion: ");
		String direccion = Utilities.getString();
		Client c = new Client(dni, nombre, edad, direccion);
		System.out.println(c);
		return c;
	}
	
	public static void editClient(Client c) {
		int opcion=-1;
		System.out.println("Editar:");
		System.out.println("1- Nombre");
		System.out.println("2- Direccion");
		opcion=Utilities.getInt();
		switch(opcion) {
		case 1:
			System.out.println("Inserte nuevo nombre: ");
			String name = Utilities.getString();
			c.setName(name);
		break;
		case 2:
			System.out.println("Inserte nueva direccion: ");
			List<String> address = new ArrayList<String>();
			String a1 = Utilities.getString();
			address.add(a1);
			c.setAddress(address);
			
		}
		
	}
}
