package com.db.coding.demo.model;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "counterparties")
public class Counterparty {
	@Id
	@Column(name = "counterparty_id", length = 20)
	private String counterpartyId;

	@Column(name = "name", length = 100, nullable = false)
	private String name;

	@OneToMany(mappedBy = "counterparty")
	private Set<Trade> trades = new HashSet<>();

	public Counterparty() {
	}

	public Counterparty(String counterpartyId, String name) {
		this.counterpartyId = counterpartyId;
		this.name = name;
	}

	public String getCounterpartyId() {
		return counterpartyId;
	}

	public void setCounterpartyId(String counterpartyId) {
		this.counterpartyId = counterpartyId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Trade> getTrades() {
		return trades;
	}

	public void setTrades(Set<Trade> trades) {
		this.trades = trades;
	}

	@Override
	public String toString() {
		return "Counterparty [counterpartyId=" + counterpartyId + ", name=" + name + ", trades=" + trades + "]";
	}

}