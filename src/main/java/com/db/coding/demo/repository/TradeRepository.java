package com.db.coding.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.db.coding.demo.model.Trade;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TradeRepository extends JpaRepository<Trade, String> {

	List<Trade> findByStatus(String status);

	List<Trade> findByBuySellIndicator(String indicator);

	List<Trade> findByTradeDateBetween(LocalDate startDate, LocalDate endDate);

	List<Trade> findByStatusOrderBySettlementDateAsc(String status);

	@Query("SELECT t FROM Trade t JOIN t.security s "
			+ "WHERE s.maturityDate BETWEEN CURRENT_DATE AND CURRENT_DATE + :days DAY")
	List<Trade> findTradesMaturingInDays(int days);

	@Query("SELECT t FROM Trade t JOIN t.book b JOIN b.users u WHERE u.userId = :userId")
	List<Trade> findTradesByUserId(String userId);

	@Query("SELECT t FROM Trade t JOIN t.book b JOIN b.users u "
			+ "WHERE u.userId = :userId AND t.buySellIndicator = 'BUY'")
	List<Trade> findBuyTradesByUserId(String userId);

	@Query("SELECT t FROM Trade t ORDER BY (t.unitPrice * t.quantity) DESC LIMIT 1")
	Trade findTradeWithHighestValue();

	@Query("SELECT t.security, COUNT(t) FROM Trade t GROUP BY t.security HAVING COUNT(t) > 1")
	List<Object[]> findSecuritiesWithMultipleTrades();
}