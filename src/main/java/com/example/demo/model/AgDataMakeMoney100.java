package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AgDataMakeMoney100  {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id ;//int(4) //NOT NULL AUTO_INCREMENT,
	private String agtime;
	private Integer open_price ;//int(4) DEFAULT NULL,
	private Integer  max_price ;//int(4) DEFAULT NULL,
	private Integer  min_price ;//int(4) DEFAULT NULL,
	private Integer  close_price ;//int(4) DEFAULT NULL,
	private Integer  change_amount =0;//int(5) DEFAULT NULL,
	private String change_type;
	private Double  change_range =0d;//double(10,0) DEFAULT NULL COMMENT '涨跌幅度，百分比',
	private Integer   average_price=0 ;//double(10,0) DEFAULT NULL COMMENT '加权平均价',
	private Integer   turnover;// int(11) DEFAULT NULL COMMENT '成交量（公斤）手',
	private Long  turnover_premium;// bigint(20) DEFAULT NULL COMMENT '成交额',
	private Integer addProfitThisModel;
	private Integer addMoneyProfit;
	private Integer dayAll;
	private Integer profitAll;
	private Integer lossAll;
	private Integer havaNumber;

	public AgDataMakeMoney100() {
		super();
	}

	public AgDataMakeMoney100(AgData agData) {
		super();
		this.agtime = agData.time;
		this.open_price = agData.open_price;
		this.max_price = agData.max_price;
		this.min_price = agData.min_price;
		this.close_price = agData.close_price;
		this.change_amount = agData.change_amount;
		this.change_type = agData.change_type;
		this.change_range = agData.change_range;
		this.average_price = agData.average_price;
		this.turnover = agData.turnover;
		this.turnover_premium = agData.turnover_premium;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAgTime() {
		return agtime;
	}

	public void setAgTime(String agtime) {
		this.agtime = agtime;
	}

	public Integer getOpen_price() {
		return open_price;
	}

	public void setOpen_price(Integer open_price) {
		this.open_price = open_price;
	}

	public Integer getMax_price() {
		return max_price;
	}

	public void setMax_price(Integer max_price) {
		this.max_price = max_price;
	}

	public Integer getMin_price() {
		return min_price;
	}

	public void setMin_price(Integer min_price) {
		this.min_price = min_price;
	}

	public Integer getClose_price() {
		return close_price;
	}

	public void setClose_price(Integer close_price) {
		this.close_price = close_price;
	}

	public Integer getChange_amount() {
		return change_amount;
	}

	public void setChange_amount(Integer change_amount) {
		this.change_amount = change_amount;
	}

	public String getChange_type() {
		return change_type;
	}

	public void setChange_type(String change_type) {
		this.change_type = change_type;
	}

	public Double getChange_range() {
		return change_range;
	}

	public void setChange_range(Double change_range) {
		this.change_range = change_range;
	}

	public Integer getAverage_price() {
		return average_price;
	}

	public void setAverage_price(Integer average_price) {
		this.average_price = average_price;
	}

	public Integer getTurnover() {
		return turnover;
	}

	public void setTurnover(Integer turnover) {
		this.turnover = turnover;
	}

	public Long getTurnover_premium() {
		return turnover_premium;
	}

	public void setTurnover_premium(Long turnover_premium) {
		this.turnover_premium = turnover_premium;
	}

	public Integer getHavaNumber() {
		return havaNumber;
	}

	public void setHavaNumber(Integer havaNumber) {
		this.havaNumber = havaNumber;
	}

	public Integer getAddProfitThisModel() {
		return addProfitThisModel;
	}

	public void setAddProfitThisModel(Integer addProfitThisModel) {
		this.addProfitThisModel = addProfitThisModel;
	}

	public Integer getAddMoneyProfit() {
		return addMoneyProfit;
	}

	public void setAddMoneyProfit(Integer addMoneyProfit) {
		this.addMoneyProfit = addMoneyProfit;
	}

	public Integer getDayAll() {
		return dayAll;
	}

	public void setDayAll(Integer dayAll) {
		this.dayAll = dayAll;
	}

	public Integer getProfitAll() {
		return profitAll;
	}

	public void setProfitAll(Integer profitAll) {
		this.profitAll = profitAll;
	}

	public Integer getLossAll() {
		return lossAll;
	}

	public void setLossAll(Integer lossAll) {
		this.lossAll = lossAll;
	}

	@Override
	public String toString() {
		return "AgDataMakeMoney50{" +
				"id=" + id +
				", agtime='" + agtime + '\'' +
				", open_price=" + open_price +
				", max_price=" + max_price +
				", min_price=" + min_price +
				", close_price=" + close_price +
				", change_amount=" + change_amount +
				", change_type='" + change_type + '\'' +
				", change_range=" + change_range +
				", average_price=" + average_price +
				", turnover=" + turnover +
				", turnover_premium=" + turnover_premium +
				", addProfitThisModel=" + addProfitThisModel +
				", addMoneyProfit=" + addMoneyProfit +
				", dayAll=" + dayAll +
				", profitAll=" + profitAll +
				", lossAll=" + lossAll +
				", havaNumber=" + havaNumber +
				'}';
	}
}
