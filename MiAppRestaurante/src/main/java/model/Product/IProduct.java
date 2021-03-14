package model.Product;

import java.util.List;

public interface IProduct {
	public List<Product> getBundlePack(Product p);
	public String getName();
	public double getPrice();
	public boolean getIsForCeliac();
}
