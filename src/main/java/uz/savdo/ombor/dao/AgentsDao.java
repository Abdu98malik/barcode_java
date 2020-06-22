package uz.savdo.ombor.dao;

import java.util.List;

import uz.savdo.ombor.entity.Agents;

public interface AgentsDao {
	public List<Agents> list();
	
	public void add(Agents client);
}
