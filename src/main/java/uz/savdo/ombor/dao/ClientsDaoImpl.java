package uz.savdo.ombor.dao;

import java.util.List;
import javax.persistence.EntityManager;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import uz.savdo.ombor.entity.Clients;

@Repository
public class ClientsDaoImpl implements ClientsDao {

	private EntityManager entityManager;
	
	@Autowired
	public ClientsDaoImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}
	
	
	@Override
	public List<Clients> list() {
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query<Clients> theQuery = currentSession.createQuery("from Clients",Clients.class);
		
		List<Clients> res = theQuery.getResultList();
		
		return res;
		
	}

	@Override
	public void add(Clients client) {
		Session currentSession = entityManager.unwrap(Session.class);
		
		currentSession.saveOrUpdate(client);
		
	}

}
