package uz.savdo.ombor.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import uz.savdo.ombor.entity.Products;

@Repository
public class ProductsDaoImpl implements ProductsDao {

	private EntityManager entityManager;
	
	@Autowired
	public ProductsDaoImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}
	
	
	@Override
	public void addProduct(Products products) {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		currentSession.saveOrUpdate(products);

	}

	@Override
	public List<Products> getProducts() {
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query<Products> theQuery = currentSession.createQuery("from Products", Products.class);
		
		List<Products> products = theQuery.getResultList();
	
		
		return products;
	}

	@Override
	public void deleteProducts(int theId) {
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query theQuery = currentSession.createQuery("delete from Products where id=:Id");
		
		theQuery.setParameter("Id", theId);
		
		theQuery.executeUpdate();

	}

	@Override
	public Products getProductById(int theId) {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query<Products> theQuery = currentSession.createQuery("from Products where id=:Id",Products.class);
		
		theQuery.setParameter("Id", theId);
		
		Products products = theQuery.getSingleResult();
		
		return products;
	}

	@Override
	public Products getProductByBarcode(int theBarcode) {
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query<Products> theQuery = currentSession.createQuery("from Products where barcode=:theBarcode",Products.class);
		
		theQuery.setParameter("theBarcode", theBarcode);
		
		Products products = theQuery.getSingleResult();
		
		return products;
	}

}
