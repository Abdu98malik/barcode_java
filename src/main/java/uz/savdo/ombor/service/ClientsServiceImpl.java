package uz.savdo.ombor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import uz.savdo.ombor.dao.ClientsDao;
import uz.savdo.ombor.entity.Clients;

@Service
public class ClientsServiceImpl implements ClientsService {

	@Autowired
	private ClientsDao clientsDao;
	
	
	@Override
	@Transactional
	public List<Clients> list() {
		
		return clientsDao.list();
	}

	@Override
	@Transactional
	public void add(Clients client) {
		clientsDao.add(client);

	}

}
