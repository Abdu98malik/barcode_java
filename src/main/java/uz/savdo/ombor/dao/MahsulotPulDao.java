package uz.savdo.ombor.dao;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import uz.savdo.ombor.entity.Mahsulotpul;

public interface MahsulotPulDao {

	public void addMahsulot(Mahsulotpul mahsulot);
	
	public List<Mahsulotpul> getMahsulot();
	
	public Mahsulotpul getMahsulotByDate(LocalDate datetime);
}
