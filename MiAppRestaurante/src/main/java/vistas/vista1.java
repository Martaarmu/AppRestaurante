package vistas;

import utils.Utilities;

public class vista1 {
	
	public static int principal(){
		int opcion=-1;
		System.out.println("****BIENVENIDO****\n");
		System.out.println("1- Nueva Orden");
		System.out.println("2- Editar Orden");
		System.out.println("3- Borrar Orden");
		System.out.println("4- Borrar Cliente");
		System.out.println("5- Editar Cliente");
		System.out.println("6- Cash total");
		System.out.println("0- Salir");
		opcion = Utilities.getInt();
		
		return opcion;
	}
}
