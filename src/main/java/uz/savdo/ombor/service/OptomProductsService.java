package uz.savdo.ombor.service;

import java.util.List;

import uz.savdo.ombor.entity.OptomProducts;

public interface OptomProductsService {

	public void addProduct(OptomProducts optom);
	
	public List<OptomProducts> listProducts();
	
	public OptomProducts getProduct(int id);
}
