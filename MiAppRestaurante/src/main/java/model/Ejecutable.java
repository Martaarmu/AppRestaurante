package model;

import java.time.LocalDateTime;
import java.util.List;

import model.Client.Client;
import model.Client.RepositoryClient;
import utils.Utilities;
import vistas.vista1;
import vistas.vista2;
import vistas.vista3;
import model.Order.*;
public class Ejecutable {
	public static void main(String[] args) {
		
		RepositoryClient clients = RepositoryClient.getInstance();
		RepositoryOrders orders = RepositoryOrders.getInstance();
		Chart carrito = Chart.getInstance();
		Client c = new Client ();
		int id = Order.nOrder;
		LocalDateTime date= LocalDateTime.now();
		Order o = new Order(id,c, carrito, date);
		String dni="";
		
		clients.loadClient("myclients.txt");
		orders.loadOrder("myorders.txt");

		do {
			switch (vista1.principal()) {
			case 1:
				switch(vista2.menu1()) {
				case 1:
					c = vista2.newClient();
					clients.addClient(c);
					clients.saveClient("myclients.txt");
					vista3.newOrder(c);	
				break;
				case 2:
					clients.getAllClients();
					dni=Utilities.getDNI();
					if(clients.existClient(dni)) {
						c = clients.searchClientDni(dni);
						vista3.newOrder(c);
					}
				break;
				}
			break;
			case 2:
				clients.getAllClients();
				dni = Utilities.getDNI();
				orders.getOrdersByClient(dni);
				System.out.println("ID:");
				id = Utilities.getInt();
				vista3.editOrder(orders.getOrderById(id));
				orders.saveOrder("myorders.txt");
				
			break;
			case 3:
				orders.getAllOrders();
				id = Utilities.getInt();
				orders.deleteOrder(id);
				orders.saveOrder("myorders.txt");
				
			break;
			case 4:
				clients.getAllClients();
				dni = Utilities.getDNI();
				clients.deleteClient(dni);
				clients.saveClient("myclients.txt");
			break;
			case 5:
				clients.getAllClients();
				dni=Utilities.getDNI();
				if(clients.existClient(dni)) {
					c = clients.searchClientDni(dni);
				}
				vista2.editClient(c);
				clients.saveClient("myclients.txt");
			break;
			case 6:
				orders.calculeTotal();
			break;
				
			
			}
		}while(vistas.vista1.principal()!=0);
		System.out.println("Hasta luego. Gracias");	
		
	}
}
