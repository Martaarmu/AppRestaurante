package model.Client;
import model.Order.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import java.util.ArrayList;
import java.util.List;
@XmlRootElement(name = "cliente")
@XmlAccessorType (XmlAccessType.FIELD)
public class Client extends Person implements Serializable {
	private List<String> address = new ArrayList<String>();
	private List<Order> orders = new ArrayList<Order>();
	private int points;
	
	
	public Client() {
		address = new ArrayList<String>();
		orders = new ArrayList<Order>();
	}
	
	
	public Client(String dni, String name, int age, String addres) {
		super(dni, name, age);
		address.add(addres);
		this.points = 0;
	}

	public Client(String dni, String name, int age, String addres, Order order, int points) {
		super(dni, name, age);
		address.add(addres);
		orders.add(order);
		this.points = points;
	}


	public List<String> getAddress() {
		return address;
	}


	public void setAddress(List<String> address) {
		this.address = address;
	}


	public List<Order> getOrders() {
		return orders;
	}

	
	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public int getPoints() {
		return points;
	}


	public void setPoints(int points) {
		this.points = points;
	}


	@Override
	public String toString() {
		return "CLIENTE \nDNI=" + getDni() + "\nNombre=" + getName() + "\nEdad=" + getAge() 
		+ "\nDireccion" + address + "\n\n";
	}
	
	
}
