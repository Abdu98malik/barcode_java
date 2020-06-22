package uz.savdo.ombor.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import uz.savdo.ombor.entity.OptomProducts;


@Repository
public class OptomProductsDaoImpl implements OptomProductsDao {

	
	private EntityManager entityManager;
	
	@Autowired
	public OptomProductsDaoImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}
	
	@Override
	public void addProduct(OptomProducts optom) {
		Session currentSession = entityManager.unwrap(Session.class);
		
		currentSession.saveOrUpdate(optom);

	}

	@Override
	public List<OptomProducts> listProducts() {
		Session currentSession = entityManager.unwrap(Session.class);
		
		
		Query<OptomProducts> query = currentSession.createQuery("from OptomProducts",OptomProducts.class);
		
		List<OptomProducts> list = query.getResultList();
		
		
		return list;
	}

	@Override
	public OptomProducts getProduct(int id) {
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query<OptomProducts> theQuery = currentSession.createQuery("from OptomProducts where id=:Id",OptomProducts.class);
		
		theQuery.setParameter("Id", id);
		
		OptomProducts products = theQuery.getSingleResult();
		
		return products;

	}

}
