package uz.savdo.ombor.dao;

import java.util.List;
import javax.persistence.EntityManager;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import uz.savdo.ombor.entity.Agents;


@Repository
public class AgentsDaoImpl implements AgentsDao {
	
	private EntityManager entityManager;
	
	@Autowired
	public AgentsDaoImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}
	
	
	@Override
	public List<Agents> list() {
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query<Agents> theQuery = currentSession.createQuery("from Agents",Agents.class);
		
		List<Agents> res = theQuery.getResultList();
		
		return res;
	}

	@Override
	public void add(Agents client) {
		Session currentSession = entityManager.unwrap(Session.class);
		
		currentSession.saveOrUpdate(client);

	}

}
