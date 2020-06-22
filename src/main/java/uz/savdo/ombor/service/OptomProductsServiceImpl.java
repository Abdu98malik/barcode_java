package uz.savdo.ombor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import uz.savdo.ombor.dao.OptomProductsDao;
import uz.savdo.ombor.entity.OptomProducts;

@Service
public class OptomProductsServiceImpl implements OptomProductsService {

	@Autowired
	private OptomProductsDao optomPro;
	
	@Override
	@Transactional
	public void addProduct(OptomProducts optom) {
		optomPro.addProduct(optom);

	}

	@Override
	@Transactional
	public List<OptomProducts> listProducts() {
		
		return optomPro.listProducts();
	}

	@Override
	@Transactional
	public OptomProducts getProduct(int id) {
		
		return optomPro.getProduct(id);
	}

}
