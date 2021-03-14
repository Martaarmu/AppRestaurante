package vistas;

import java.time.LocalDateTime;
import java.util.Iterator;

import model.Client.Client;
import model.Order.Chart;
import model.Order.Order;
import model.Order.RepositoryOrders;
import model.Product.Drink;
import model.Product.Food;
import model.Product.Product;
import model.Product.RepositoryProduct;
import utils.Utilities;

public class vista3 {
	
	public static Order newOrder (Client c) {
		Chart carrito = Chart.getInstance();
		int id =0;
		LocalDateTime date= LocalDateTime.now();
		Order result = new Order (id, c, carrito, date);
		int opcion = -1;
		Drink d = new Drink ();
		Food f = new Food ();
		RepositoryProduct products = new RepositoryProduct();
		RepositoryOrders orders = RepositoryOrders.getInstance();
		products.rellena();
		System.out.println("Seleccione productos para añadir al carrito: ");
		System.out.println("1- Coca Cola");
		System.out.println("2- Fanta");
		System.out.println("3- Cebadina");
		System.out.println("4- Tequila");
		System.out.println("5- Pulque");
		System.out.println("6- Burrito vegetal");
		System.out.println("7- Burrito pollo");
		System.out.println("8- Pazole");
		System.out.println("9- Enchilada");
		System.out.println("10- Nachos con guacamole");
		System.out.println("0- Guadar y cerrar");
		
		do {
			opcion = Utilities.getInt();
			switch(opcion) {
			
			case 0:
				orders.addOrder(result);
				orders.saveOrder("myorders.txt");
				System.out.println(carrito.calculeTotal());
				//System.out.println(result.getTotal());
			break;
			case 1:
				d = products.searchDrinks("COCACOLA");
				carrito.addProduct(d);
				
			break;
			case 2:
				d = products.searchDrinks("FANTA");
				carrito.addProduct(d);
			break;
			case 3:
				d = products.searchDrinks("CEBADINA");
				carrito.addProduct(d);
			break;
			case 4:
				d = products.searchDrinks("TEQUILA");
				carrito.addProduct(d);
			break;
			case 5:
				f = products.searchFoods("PULQUE");
				carrito.addProduct(f);
			break;
			case 6:
				f = products.searchFoods("BURRITOS VEGETALES");
				carrito.addProduct(f);
			break;
			case 7:
				f = products.searchFoods("BURRITOS POLLO");
				carrito.addProduct(f);
			break;
			case 8:
				f = products.searchFoods("PAZOLE");
				carrito.addProduct(f);
			break;
			case 9:
				f = products.searchFoods("ENCHILADA");
				carrito.addProduct(f);
			break;
			case 10:
				f = products.searchFoods("NACHOS CON GUACAMOLE");
				carrito.addProduct(f);
			break;
			}

		}while(opcion!=0);
			return result;		
	}
	
	public static void editOrder (Order o) {
		System.out.println("Inserte el nombre del producto que quiere eliminar: ");
		String name = Utilities.getString();
		Iterator<Product> miiterador = o.getProducts().iterator();
		while (miiterador.hasNext()) {
			Product p = miiterador.next();
			if (p instanceof Drink && p.getName().equals(name)) {
				miiterador.remove();
			}else {
				if(p instanceof Food && p.getName().equals(name)) {
					miiterador.remove();
				}
			}
		}
		
	}
	
}
