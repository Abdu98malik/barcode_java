package uz.savdo.ombor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import uz.savdo.ombor.dao.AgentsDao;
import uz.savdo.ombor.entity.Agents;

@Service
public class AgentsServiceImpl implements AgentsService{

	@Autowired
	private AgentsDao agentsDao;
	
	@Override
	@Transactional
	public List<Agents> list() {
		
		return agentsDao.list();
	}

	@Override
	@Transactional
	public void add(Agents agent) {
		agentsDao.add(agent);
		
	}

}
