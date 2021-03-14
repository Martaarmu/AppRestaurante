package model.Order;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import model.Client.Client;
import model.Client.RepositoryClient;
import model.Product.Product;



@XmlRootElement(name = "repositoryOrders")
@XmlAccessorType (XmlAccessType.FIELD)
public class RepositoryOrders implements Serializable {
	
	private static RepositoryOrders instance;
	@XmlElement(name = "order")
	static List<Order> orders;
	
	private RepositoryOrders() {
		orders=new ArrayList<Order>();
	}
	
	public static RepositoryOrders getInstance() {
		if(instance==null) {
			instance= new RepositoryOrders();
			orders=new ArrayList<Order>();
		}
		return instance;
	}
	/**
	 * Añade pedidos al respositorio
	 * @param o
	 */
	
	public void addOrder(Order o) {
		orders.add(o);
	}
	/**
	 * Muestra todos los pedidos
	 */
	public void getAllOrders() {
		System.out.println(orders);
	}
	/**
	 * Muestra por pantalla los pedidos de un cliente por su dni
	 * @param dni
	 * @return lista de pedidos
	 */
	
	public List<Order> getOrdersByClient(String dni){
		List<Order>listOrders=new ArrayList<Order>();
		for(Order o:orders) {
			if(o.getClient().getDni().equals(dni)) {
				//System.out.println(o);
				listOrders.add(o);
			}
		}
		System.out.println(listOrders);
		return listOrders;
	}
	/**
	 * Busca los pedidos por su id
	 * @param id
	 * @return pedido
	 */
	public Order getOrderById(int id) {
		Order result= new Order();
		Iterator<Order> miiterador = orders.iterator();
		while (miiterador.hasNext()) {
			Order o = miiterador.next();
			if (o.getId()==id) {
				System.out.println(o);
				result=o;
			}
		}
		return result;
	}
	/**
	 * Muestra los pedidos segun la fecha
	 * @param ini
	 * @return lista de pedidos
	 */
	public List<Order> getOrdersByDate (LocalDateTime ini){
		List<Order>listOrders=new ArrayList<Order>();
		for (Order o:orders) {
			if(o.getDate().equals(ini)) {
				System.out.println(o);
				listOrders.add(o);
			}
		}
		return listOrders;
	}
	/**
	 * Muestra los pedidos no entregados
	 * @return lista de pedidos
	 */
	public List<Order> getOrdersNoDelivered(){
		List<Order>listOrders=new ArrayList<Order>();
		for (Order o:orders) {
			if(o!=null && !o.isDelivered()) {
				System.out.println(o);
				listOrders.add(o);
			}
		}
		return listOrders;
	}
	/**
	 * Muestra los pedidos que estan sin pagar
	 * @return lista de pedidos
	 */
	
	public List<Order> getOrderNoPayed(){
		List<Order>listOrders=new ArrayList<Order>();
		for (Order o:orders) {
			if(o!=null && !o.isPayed()) {
				System.out.println(o);
				listOrders.add(o);
			}
		}
		return listOrders;
	}
	/**
	 * Borra los pedidos segun su id
	 * @param id
	 */
	
	public void deleteOrder(int id) {
		Iterator<Order> miiterador = orders.iterator();
		while (miiterador.hasNext()) {
			Order o = miiterador.next();
			if (o.getId()==id) {
				miiterador.remove();
			}
		}
	}
	/**
	 * Calcula el total de cada pedido
	 * @return
	 */
	public double calculeTotal() {
		double result=0;
		for(Order o:orders) {
			result+=o.getTotal();
		}
		System.out.println(result);
		return result;
	}

	/**
	 * Guarda datos en fichero XML
	 * @param url
	 */
	public void saveOrder(String url) {
		// marshaling
		JAXBContext jaxbContext;
		try {
			jaxbContext = JAXBContext.newInstance(RepositoryOrders.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			jaxbMarshaller.marshal(getInstance(), new File(url));
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * Carga datos de los ficheros XML
	 * @param url
	 */
	
	public void loadOrder(String url) {
		JAXBContext jaxbContext;
		try {
			jaxbContext = JAXBContext.newInstance(RepositoryOrders.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

			RepositoryOrders newR = (RepositoryOrders) jaxbUnmarshaller.unmarshal(new File(url));
			orders = newR.orders;
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
