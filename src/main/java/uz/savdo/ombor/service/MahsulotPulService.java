package uz.savdo.ombor.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import uz.savdo.ombor.entity.Mahsulotpul;

public interface MahsulotPulService {

	public void addMahsulot(Mahsulotpul mahsulot);
	
	public List<Mahsulotpul> getMahsulot();
	
	public Mahsulotpul getMahsulotByDate(LocalDate datetime);
	
	public List<Mahsulotpul> getMahsulotDaily();
}
