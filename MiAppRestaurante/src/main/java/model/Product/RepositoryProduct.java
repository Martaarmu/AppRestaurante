package model.Product;


import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement(name = "repository")
@XmlAccessorType (XmlAccessType.FIELD)

public class RepositoryProduct {
	@XmlElement(name="product")
	
	List<Product>carta=new ArrayList<Product>();
	/**
	 * Añade productos a la carta
	 * @param p
	 */
	public void addProduct(Product p) {
		carta.add(p);
	}
		
	public void rellena() {
		
		carta.add(new Drink (UUID.randomUUID(),"COCACOLA", 1.50, false));
		carta.add(new Drink(UUID.randomUUID(), "FANTA", 2.00, false));
		carta.add(new Drink(UUID.randomUUID(),"CEBADINA",3.50,false));
		carta.add(new Drink(UUID.randomUUID(),"TEQUILA",3.00,true));
		carta.add(new Drink(UUID.randomUUID(),"PULQUE",2.50,true));
		carta.add(new Food(UUID.randomUUID(), "BURRITOS VEGETALES", 6.00, true, true));
		carta.add(new Food(UUID.randomUUID(), "BURRITOS POLLO", 5.00, false, false));
		carta.add(new Food(UUID.randomUUID(), "PAZOLE", 7.00, false, false));
		carta.add(new Food(UUID.randomUUID(), "ENCHILADA", 10.00, false, false));
		carta.add(new Food(UUID.randomUUID(), "NACHOS CON GUACAMOLE", 6.00, true, true));
		
			
	}

	@Override
	public String toString() {
		return "Repository [carta=" + carta + "]";
	}
	/**
	 * Muestra la carta
	 */
		
	public void getAllProducts() {
		System.out.println(carta);	
	}
	/**
	 * Muestra todas las bebidas
	 * @return lista de bebidas
	 */
	public List<Drink> getAllDrinks() {
		List<Drink>listDrinks=new ArrayList<Drink>();
		for(Product p:carta) {
			if(p instanceof Drink) {
				System.out.println(p);
				listDrinks.add((Drink) p);
			}
		}
		return listDrinks;
	}
	/**
	 * Muestra todas las comidas
	 * @return lista de comidas
	 */
	public List<Food> getAllFood() {
		List<Food>listFoods=new ArrayList<Food>();
		for(Product p:carta) {
			if(p instanceof Food) {
				System.out.println(p);
				listFoods.add((Food) p);
			}
		}
		return listFoods;
		
	}
	/**
	 * Muestra las bebidas no alcoholicas
	 * @return lista de bebidas
	 */
	
	public List<Drink> getAllNoAlcoholicDrinks(){
		List<Drink>listDrinks=new ArrayList<Drink>();
		for(Product p:carta) {
			if(p instanceof Drink && !((Drink) p).alcoholic) {
				System.out.println(p);
				listDrinks.add((Drink) p);
			}
		}
		return listDrinks;
	}
	/**
	 * Muestra bebidas alchoholicas
	 * @return lista bebidas
	 */
	
	public List<Drink> getAllAlcoholicDrinks(){
		List<Drink>listDrinks=new ArrayList<Drink>();
		for(Product p:carta) {
			if(p instanceof Drink && ((Drink) p).alcoholic) {
				System.out.println(p);
				listDrinks.add((Drink) p);
			}
		}
		return listDrinks;
	}
	/**
	 * Muestra comidas veganas
	 * @return lista de comidas
	 */
	public List<Food> getAllForVeganFood(){
		List<Food>listFoods=new ArrayList<Food>();
		for(Product p:carta) {
			if(p instanceof Food && ((Food) p).isForVegan()) {
				System.out.println(p);
				listFoods.add((Food) p);
			}
		}
		return listFoods;
	}
	/**
	 * Busca productos por su nombre
	 * @param name
	 * @return true si esta o false si no esta
	 */
	public boolean searchProduct(String name) {
		boolean result = false;
		for(Product p:carta) {
			if(p!=null && p.getName()!=null && p.getName().equals(name)) {
				result=true;
				System.out.println(p);
			}
		}
		return result;
	}
	/**
	 * Busca bebidas por su nombre
	 * @param name
	 * @return una bebida
	 */
	public Drink searchDrinks(String name){	
		Drink d = new Drink ();
		for(Product p:carta) {
			if(p!=null && p.getName()!=null && p.getName().equals(name) && p instanceof Drink) {
				d = (Drink) p;
				System.out.println(d);
			}
		}
		return d;
	}
	/**
	 * Busca comidas por su nombre
	 * @param name
	 * @return una comida
	 */
	public Food searchFoods(String name) {
		Food f = new Food ();
		for(Product p:carta) {
			if(p!=null && p.getName()!=null && p.getName().equals(name) && p instanceof Food) {
				f = (Food) p;
				System.out.println(f);
			}
		}
		return f;
	}
		
	
}
