package uz.savdo.ombor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import uz.savdo.ombor.dao.ProductsDao;
import uz.savdo.ombor.entity.Products;

@Service
public class ProductsServiceImpl implements ProductsService {

	@Autowired
	private ProductsDao productsDao;
	
	
	@Override
	@Transactional
	public void addProduct(Products products) {
		productsDao.addProduct(products);

	}

	@Override
	@Transactional
	public List<Products> getProducts() {
		List<Products> products = productsDao.getProducts();
		return products;
	}

	@Override
	@Transactional
	public void deleteProducts(int theId) {
		productsDao.deleteProducts(theId);

	}

	@Override
	@Transactional
	public Products getProductById(int theId) {
		Products product = productsDao.getProductById(theId);
		return product;
	}

	@Override
	@Transactional
	public Products getProductByBarcode(int barcode) {
		Products product = productsDao.getProductByBarcode(barcode);
		return product;
	}

}
