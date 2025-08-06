package com.db.coding.demo.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "trades")
public class Trade {
	@Id
	@Column(name = "trade_id", length = 30)
	private String tradeId;

	@ManyToOne
	@JoinColumn(name = "book_id", nullable = false)
	private Book book;

	@ManyToOne
	@JoinColumn(name = "security_id", nullable = false)
	private Security security;

	@ManyToOne
	@JoinColumn(name = "counterparty_id", nullable = false)
	private Counterparty counterparty;

	@Column(name = "currency", length = 10, nullable = false)
	private String currency;

	@Column(name = "status", length = 20, nullable = false)
	private String status;

	@Column(name = "quantity", nullable = false)
	private Integer quantity;

	@Column(name = "unit_price", precision = 15, scale = 4)
	private BigDecimal unitPrice;

	@Column(name = "buy_sell_indicator", length = 4)
	private String buySellIndicator;

	@Column(name = "trade_date", nullable = false)
	private LocalDate tradeDate;

	@Column(name = "settlement_date", nullable = false)
	private LocalDate settlementDate;

	public Trade() {
	}

	public Trade(String tradeId, Book book, Security security, Counterparty counterparty, String currency,
			String status, Integer quantity, BigDecimal unitPrice, String buySellIndicator, LocalDate tradeDate,
			LocalDate settlementDate) {
		this.tradeId = tradeId;
		this.book = book;
		this.security = security;
		this.counterparty = counterparty;
		this.currency = currency;
		this.status = status;
		this.quantity = quantity;
		this.unitPrice = unitPrice;
		this.buySellIndicator = buySellIndicator;
		this.tradeDate = tradeDate;
		this.settlementDate = settlementDate;
	}

	public String getTradeId() {
		return tradeId;
	}

	public void setTradeId(String tradeId) {
		this.tradeId = tradeId;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Security getSecurity() {
		return security;
	}

	public void setSecurity(Security security) {
		this.security = security;
	}

	public Counterparty getCounterparty() {
		return counterparty;
	}

	public void setCounterparty(Counterparty counterparty) {
		this.counterparty = counterparty;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}

	public String getBuySellIndicator() {
		return buySellIndicator;
	}

	public void setBuySellIndicator(String buySellIndicator) {
		this.buySellIndicator = buySellIndicator;
	}

	public LocalDate getTradeDate() {
		return tradeDate;
	}

	public void setTradeDate(LocalDate tradeDate) {
		this.tradeDate = tradeDate;
	}

	public LocalDate getSettlementDate() {
		return settlementDate;
	}

	public void setSettlementDate(LocalDate settlementDate) {
		this.settlementDate = settlementDate;
	}

	@Override
	public String toString() {
		return "Trade [tradeId=" + tradeId + ", book=" + book + ", security=" + security + ", counterparty="
				+ counterparty + ", currency=" + currency + ", status=" + status + ", quantity=" + quantity
				+ ", unitPrice=" + unitPrice + ", buySellIndicator=" + buySellIndicator + ", tradeDate=" + tradeDate
				+ ", settlementDate=" + settlementDate + "]";
	}

}