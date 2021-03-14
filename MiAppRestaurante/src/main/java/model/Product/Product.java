package model.Product;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

@XmlRootElement(name = "products")
@XmlAccessorType (XmlAccessType.FIELD)
@XmlSeeAlso ({Drink.class,Food.class})

public abstract class Product implements IProduct, Serializable {
	private UUID id;
	private String name;
	private double price;
	private boolean forCeliac;
	
	public Product () {}
	public Product(UUID id, String name, double price) {
		super();
		this.id = UUID.randomUUID();
		this.name = name;
		this.price = price;
	}
	
	
	public Product(UUID id, String name, double price, boolean forCeliac) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.forCeliac = forCeliac;
	}


	public UUID getid() {
		return id;
	}
	abstract public List<Product> getBundlePack(Product p);

	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}

	public boolean getIsForCeliac() {
		return forCeliac;
	}


	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + ", forCeliac=" + forCeliac+" ";
	}
	
	public boolean equals(Object o) {
		boolean result=false;
		if(this==o) {
			result=true;
		}else if(this.getClass()==o.getClass()){
			Product p=(Product)o;
			String n=p.getName();
			String miNombre=name;
			if(miNombre.equals(n)) {
				result=true;
			}
		}
		return result;
	}

}
