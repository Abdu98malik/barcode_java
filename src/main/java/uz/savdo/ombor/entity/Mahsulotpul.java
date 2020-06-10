package uz.savdo.ombor.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="mahsulotpul")
public class Mahsulotpul {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="date_time")
	private LocalDate date_time;
	
	@Column(name="money")
	private int money;

	public Mahsulotpul() {
		
	}
	public Mahsulotpul(LocalDate date_time, int money) {
		super();
		this.date_time = date_time;
		this.money = money;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getDate_time() {
		return date_time;
	}

	public void setDate_time(LocalDate date_time) {
		this.date_time = date_time;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}
	
	
	
	
	
}
