package uz.savdo.ombor.dao;

import java.util.List;

import uz.savdo.ombor.entity.Clients;

public interface ClientsDao {

	public List<Clients> list();
	
	public void add(Clients client);
}
