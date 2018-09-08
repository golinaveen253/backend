package com.nouhoun.springboot.jwt.integration.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author Naveen
 *
 */
@Entity
@Table(name = "order")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "mobile")
	private String mobile;
	
	@Column(name = "work")
	private Integer work;
	
	@Column(name = "no_of_cards")
	private Integer noOfCards;
	
	@Column(name = "total_amount")
	private Integer totalAmount;
	
	@Column(name = "amount_collected")
	private Integer amountCollected;
	
	@Column(name = "delivery_date")
	private Date deliveryDate;
	
	@Column(name = "time")
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

	public Integer getNoOfCards() {
		return noOfCards;
	}

	public void setNoOfCards(Integer noOfCards) {
		this.noOfCards = noOfCards;
	}

	public Integer getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Integer totalAmount) {
		this.totalAmount = totalAmount;
	}

	public Integer getAmountCollected() {
		return amountCollected;
	}

	public void setAmountCollected(Integer amountCollected) {
		this.amountCollected = amountCollected;
	}

	public Date getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
	
}