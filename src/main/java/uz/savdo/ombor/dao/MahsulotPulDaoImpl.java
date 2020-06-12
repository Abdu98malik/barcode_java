package uz.savdo.ombor.dao;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import uz.savdo.ombor.entity.Mahsulotpul;
import uz.savdo.ombor.entity.Products;

@Repository
public class MahsulotPulDaoImpl implements MahsulotPulDao {

	private EntityManager entityManager;
	
	@Autowired
	public MahsulotPulDaoImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	@Override
	public void addMahsulot(Mahsulotpul mahsulot) {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		currentSession.saveOrUpdate(mahsulot);
	}

	@Override
	public List<Mahsulotpul> getMahsulot() {
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query<Mahsulotpul> theQuery = currentSession.createQuery("from Mahsulotpul", Mahsulotpul.class);
		
		List<Mahsulotpul> list = theQuery.getResultList();
		
		
		return list;
	}
	
	@Override
	public List<Mahsulotpul> getMahsulotDaily() {
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query<Object[]> theQuery = currentSession.createQuery("Select date_time, sum(money) as sum_money from Mahsulotpul group by date_time", Object[].class);
		
		List<Object[]> list = theQuery.getResultList();
		
		List<Mahsulotpul> mahs = new ArrayList<>();
		
		
		for (Object[] temp: list) {
			
			Mahsulotpul here = new Mahsulotpul(LocalDate.parse(temp[0].toString()),
					Integer.parseInt(temp[1].toString()));
			
			mahs.add(here);
		}
		return mahs;
	}


	@Override
	public Mahsulotpul getMahsulotByDate(LocalDate datetime) {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
	
		Query<Object[]> theQuery = currentSession.createQuery(
				"Select date_time, sum(money) as sum_money from Mahsulotpul where date_time=:theDate group by date_time",
				Object[].class);
		
	
		theQuery.setParameter("theDate", datetime);
		
		Object[] list = theQuery.getSingleResult();
		
		Mahsulotpul mahsa = new Mahsulotpul();
		
		LocalDate cur = LocalDate.parse(list[0].toString());
		int pr = Integer.parseInt(list[1].toString());

		mahsa.setDate_time(cur);
		mahsa.setMoney(pr);
		
		return mahsa;
	}

}
