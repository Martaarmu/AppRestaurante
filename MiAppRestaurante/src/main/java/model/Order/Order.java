package model.Order;
import  model.Client.*;
import model.Product.Product;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import utils.LocalDateAdapter;


@XmlRootElement(name = "order")
@XmlAccessorType (XmlAccessType.FIELD)
public class Order implements Serializable{
	
	static public int nOrder=0;
	
	private int id;
	private Client client;
	private List<Product> listProducts;
	private double total;
	@XmlJavaTypeAdapter (value=LocalDateAdapter.class)
	private LocalDateTime date=LocalDateTime.now();
	private String adress;
	private boolean delivered;
	private boolean payed;

	public Order() {
		nOrder++;
	}
	
	
	
	public Order(Client client, List<Product> listProducts, double total, LocalDateTime date, String adress,
			boolean delivered, boolean payed) {
		super();
		this.client = client;
		this.listProducts = listProducts;
		this.total = total;
		this.date = date;
		this.adress = adress;
		this.delivered = delivered;
		this.payed = payed;
	}



	public Order(int id, Client client, Chart carrito, LocalDateTime date) {
		this.id=nOrder;
		this.client=client;
		this.listProducts=carrito.getProducts();
		this.date=LocalDateTime.now();
		nOrder++;
	}

	public Order(Client client) {
		super();
		this.client = client;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public List<Product> getProducts() {
		return listProducts;
	}
	public void setProducts(List<Product> listProducts) {
		this.listProducts = listProducts;
	}
	public double getTotal() {
		double total=0;
		for(Product p:listProducts) {
			total+=p.getPrice();
		}
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public LocalDateTime getDate() {
		return date;
	}
	public void setDate(LocalDateTime date) {
		this.date = date;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public boolean isDelivered() {
		return delivered;
	}
	public void setDelivered(boolean delivered) {
		this.delivered = delivered;
	}
	public boolean isPayed() {
		return payed;
	}
	public void setPayed(boolean payed) {
		this.payed = payed;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		if (id != other.id)
			return false;
		return true;
	}



	@Override
	public String toString() {
		return "\n\nORDER\n--------\nId: "+id+"\n\n" + client + "PRODUCTOS: " + listProducts + "\nTotal:" + getTotal() + "\nFecha: "
				+ date +"\n";
	}
	
	
}
