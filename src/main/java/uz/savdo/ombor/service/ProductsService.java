package uz.savdo.ombor.service;

import java.util.List;

import uz.savdo.ombor.entity.Products;

public interface ProductsService {

	public void addProduct(Products products);
	
	public List<Products> getProducts();
	
	public void deleteProducts(int theId);
	
	public Products getProductById(int theId);
	
	public Products getProductByBarcode(int barcode);
}
