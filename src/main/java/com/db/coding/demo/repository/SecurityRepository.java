package com.db.coding.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.db.coding.demo.model.Security;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface SecurityRepository extends JpaRepository<Security, String> {

	Security findByIsin(String isin);

	List<Security> findByIssuerNameContainingIgnoreCase(String issuerNamePart);

	List<Security> findByMaturityDateBetween(LocalDate startDate, LocalDate endDate);

	@Query("SELECT s FROM Security s WHERE s.maturityDate < CURRENT_DATE")
	List<Security> findMaturedSecurities();

	List<Security> findByStatus(String status);

	@Query("SELECT DISTINCT s FROM Security s JOIN s.trades t")
	List<Security> findSecuritiesWithTrades();
}