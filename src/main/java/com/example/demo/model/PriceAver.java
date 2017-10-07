package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PriceAver {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id ;
	private String agtime;
	private Integer price;
	private Integer price5;
	private Integer price10;
	private Integer price50;

	public String getAgTime() {
		return agtime;
	}

	public void setAgTime(String time) {
		this.agtime = agtime;
	}

	public Integer getPrice5() {
		return price5;
	}

	public void setPrice5(Integer price5) {
		this.price5 = price5;
	}

	public Integer getPrice10() {
		return price10;
	}

	public void setPrice10(Integer price10) {
		this.price10 = price10;
	}

	public Integer getPrice50() {
		return price50;
	}

	public void setPrice50(Integer price50) {
		this.price50 = price50;
	}

	public PriceAver() {
		super();

	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public PriceAver(String agtime, Integer price, Integer price5, Integer price10, Integer price50) {
		super();
		this.agtime = agtime;
		this.price5 = price5;
		this.price = price;
		this.price10 = price10;
		this.price50 = price50;
	}

	@Override
	public String toString() {
		return "PriceAver [agtime=" + agtime + ", price5=" + price5 + ", price10=" + price10 + ", price50=" + price50 + "]";
	}

}
