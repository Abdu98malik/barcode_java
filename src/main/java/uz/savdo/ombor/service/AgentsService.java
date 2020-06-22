package uz.savdo.ombor.service;

import java.util.List;

import uz.savdo.ombor.entity.Agents;

public interface AgentsService {
	public List<Agents> list();
	
	public void add(Agents agent);
}
