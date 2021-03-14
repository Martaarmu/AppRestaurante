package model.Product;

import java.util.List;
import java.util.UUID;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement(name = "drink")
@XmlAccessorType (XmlAccessType.FIELD)
public class Drink extends Product{
	
	public boolean alcoholic;
	public Drink () {}

	public Drink(UUID id, String name, double price, boolean alcoholic) {
		super(id, name, price);
		this.alcoholic = alcoholic;
	}
	public boolean isAlcoholic() {
		return alcoholic;
	}
	
	public List<Product> getBundlePack(Product p) {
		
		return null;
	}


	@Override
	public String toString() {
		return "Drink [id= " + this.getid() + ", name=" + this.getName() + ", price=" + this.getPrice() +
				", alcoholic=" + alcoholic + "]\n";
	}

	
	
	

}
