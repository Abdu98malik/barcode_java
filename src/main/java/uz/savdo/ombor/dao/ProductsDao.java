package uz.savdo.ombor.dao;

import java.util.List;

import uz.savdo.ombor.entity.Products;

public interface ProductsDao {

	public void addProduct(Products products);
	
	public List<Products> getProducts();
	
	public void deleteProducts(int theId);
	
	public Products getProductById(int theId);
	
	public Products getProductByBarcode(String barcode);
	
	
	
	
}
