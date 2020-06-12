package uz.savdo.ombor.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import uz.savdo.ombor.dao.MahsulotPulDao;
import uz.savdo.ombor.entity.Mahsulotpul;

@Service
public class MahsulotPulServiceImpl implements MahsulotPulService {

	@Autowired
	private MahsulotPulDao mahsulotPulDao;
	
	@Override
	@Transactional
	public void addMahsulot(Mahsulotpul mahsulot) {
		mahsulotPulDao.addMahsulot(mahsulot);

	}

	@Override
	@Transactional
	public List<Mahsulotpul> getMahsulot() {
		List<Mahsulotpul> list = mahsulotPulDao.getMahsulot();
		
		return list;
	}

	@Override
	@Transactional
	public Mahsulotpul getMahsulotByDate(LocalDate datetime) {
		
		Mahsulotpul mp = mahsulotPulDao.getMahsulotByDate(datetime);
		
		return mp;
	}
	@Override
	@Transactional
	public List<Mahsulotpul> getMahsulotDaily(){
		 
		return mahsulotPulDao.getMahsulotDaily();
		
	}
}
