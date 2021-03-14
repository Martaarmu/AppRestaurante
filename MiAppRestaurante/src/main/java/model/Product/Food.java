package model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
@XmlRootElement(name = "food")
@XmlAccessorType (XmlAccessType.FIELD)
public class Food extends Product{
	
	private boolean forVegan;
	
	public Food () {}
	public Food(UUID id,String name, double price,boolean forCeliac,boolean forVegan) {
		super(id,name, price, forCeliac);
		this.forVegan = forVegan;
	}

	public boolean isForVegan() {
		return forVegan;
	}
	
	@Override
	public List<Product> getBundlePack(Product p) {

		return null;
	}
	

	@Override
	public String toString() {
		return "Food ["+super.toString()+"forVegan=" + forVegan + "\n";
	}
	

	
	
	
}
