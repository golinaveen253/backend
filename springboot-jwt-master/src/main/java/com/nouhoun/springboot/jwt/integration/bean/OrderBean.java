package com.nouhoun.springboot.jwt.integration.bean;

public class OrderBean {

	private Long id;

	private String name;

	private String mobile;

	private Integer work;

	private Integer no_of_cards;

	private Integer total_amount;

	private Integer amount_collected;

	private String delivery_date;

	private String time;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Integer getWork() {
		return work;
	}

	public void setWork(Integer work) {
		this.work = work;
	}

	public Integer getNo_of_cards() {
		return no_of_cards;
	}

	public void setNo_of_cards(Integer no_of_cards) {
		this.no_of_cards = no_of_cards;
	}

	public Integer getTotal_amount() {
		return total_amount;
	}

	public void setTotal_amount(Integer total_amount) {
		this.total_amount = total_amount;
	}

	public Integer getAmount_collected() {
		return amount_collected;
	}

	public void setAmount_collected(Integer amount_collected) {
		this.amount_collected = amount_collected;
	}

	public String getDelivery_date() {
		return delivery_date;
	}

	public void setDelivery_date(String delivery_date) {
		this.delivery_date = delivery_date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

}
