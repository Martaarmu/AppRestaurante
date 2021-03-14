package model.Order;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import model.Product.*;
 @XmlRootElement(name = "carrito")
 @XmlAccessorType (XmlAccessType.FIELD)
public class Chart {
	
	private static Chart instance;
	private Order order;
	private List<Product> productList=new ArrayList<Product>();

	private Chart() {}
	
	
	
	public Chart(Order order) {
		super();
		this.order = order;
	}

	public static Chart getInstance() {
		if(instance==null) {
			instance=new Chart();
		}
		return instance;
	}

	public List<Product> getProducts() {
		return productList;
	}
	public void setProducts(List<Product> products) {
		this.productList = products;
	}
	/**
	 * Añade productos al carrito
	 * @param product
	 */
	public void addProduct(Product product) {
		this.productList.add(product);
	}
	/**
	 * Borra productos del carrito
	 * @param product
	 */
	public void deleteProduct(Product product) {
		this.productList.remove(product);
	}
	/**
	 * Calcula el precio total del carrito
	 * @return
	 */
	public double calculeTotal() {
		double result=0;
		for(Product p:productList) {
		
			result+=p.getPrice();
		}
		return result;
	}



	@Override
	public String toString() {
		return "Chart [order=" + order + ", productList=" + productList + "]";
	}
	
}
	