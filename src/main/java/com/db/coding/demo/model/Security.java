package com.db.coding.demo.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "securities")
public class Security {
	@Id
	@Column(name = "security_id", length = 20)
	private String securityId;

	@Column(name = "isin", length = 20, nullable = false, unique = true)
	private String isin;

	@Column(name = "cusip", length = 20)
	private String cusip;

	@Column(name = "issuer_name", length = 100, nullable = false)
	private String issuerName;

	@Column(name = "maturity_date", nullable = false)
	private LocalDate maturityDate;

	@Column(name = "coupon", precision = 5, scale = 2)
	private BigDecimal coupon;

	@Column(name = "type", length = 30)
	private String type;

	@Column(name = "face_value", precision = 15, scale = 2)
	private BigDecimal faceValue;

	@Column(name = "currency", length = 10)
	private String currency;

	@Column(name = "status", length = 20, nullable = false)
	private String status;

	@OneToMany(mappedBy = "security")
	private Set<Trade> trades = new HashSet<>();

	public Security() {
	}

	public Security(String securityId, String isin, String issuerName, LocalDate maturityDate, String status) {
		this.securityId = securityId;
		this.isin = isin;
		this.issuerName = issuerName;
		this.maturityDate = maturityDate;
		this.status = status;
	}

	public String getSecurityId() {
		return securityId;
	}

	public void setSecurityId(String securityId) {
		this.securityId = securityId;
	}

	public String getIsin() {
		return isin;
	}

	public void setIsin(String isin) {
		this.isin = isin;
	}

	public String getCusip() {
		return cusip;
	}

	public void setCusip(String cusip) {
		this.cusip = cusip;
	}

	public String getIssuerName() {
		return issuerName;
	}

	public void setIssuerName(String issuerName) {
		this.issuerName = issuerName;
	}

	public LocalDate getMaturityDate() {
		return maturityDate;
	}

	public void setMaturityDate(LocalDate maturityDate) {
		this.maturityDate = maturityDate;
	}

	public BigDecimal getCoupon() {
		return coupon;
	}

	public void setCoupon(BigDecimal coupon) {
		this.coupon = coupon;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public BigDecimal getFaceValue() {
		return faceValue;
	}

	public void setFaceValue(BigDecimal faceValue) {
		this.faceValue = faceValue;
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

	public Set<Trade> getTrades() {
		return trades;
	}

	public void setTrades(Set<Trade> trades) {
		this.trades = trades;
	}

	@Override
	public String toString() {
		return "Security [securityId=" + securityId + ", isin=" + isin + ", cusip=" + cusip + ", issuerName="
				+ issuerName + ", maturityDate=" + maturityDate + ", coupon=" + coupon + ", type=" + type
				+ ", faceValue=" + faceValue + ", currency=" + currency + ", status=" + status + ", trades=" + trades
				+ "]";
	}

}