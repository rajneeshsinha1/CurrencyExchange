package com.microservices.currencyexchangeservice;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="EXCHANGE_VALUE")
public class CurrencyExchange {

	
	@Id
	private long id;
	
	@Column(name="currency_from")
	private String from;
	
	@Column(name="currency_to")
	private String to;
	
	private BigDecimal multipleValues;
	
	private BigDecimal quantity;
	
	private BigDecimal totalCalculatedAmount;
	
	private int port;//port on which application is running

	public CurrencyExchange() {
	}

	public CurrencyExchange(long id, String from, String to, BigDecimal multipleValues) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.multipleValues = multipleValues;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public BigDecimal getMultipleValues() {
		return multipleValues;
	}

	public void setMultipleValues(BigDecimal multipleValues) {
		this.multipleValues = multipleValues;
	}
	

	public BigDecimal getQuantity() {
		return quantity;
	}

	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getTotalCalculatedAmount() {
		return totalCalculatedAmount;
	}

	public void setTotalCalculatedAmount(BigDecimal totalCalculatedAmount) {
		this.totalCalculatedAmount = totalCalculatedAmount;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}
	
	
	
}
