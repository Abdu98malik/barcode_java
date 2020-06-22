package uz.savdo.ombor.dao;

import java.util.List;

import uz.savdo.ombor.entity.OptomProducts;

public interface OptomProductsDao {

	public void addProduct(OptomProducts optom);
	
	public List<OptomProducts> listProducts();
	
	public OptomProducts getProduct(int id);
	
}
