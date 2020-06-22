package uz.savdo.ombor.service;

import java.util.List;

import uz.savdo.ombor.entity.Clients;

public interface ClientsService {

	public List<Clients> list();
	
	public void add(Clients client);
}
