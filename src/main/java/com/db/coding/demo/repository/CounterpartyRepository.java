package com.db.coding.demo.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.db.coding.demo.model.Counterparty;

import java.util.List;

@Repository
public interface CounterpartyRepository extends JpaRepository<Counterparty, String> {
    
    Counterparty findByName(String name);
    
    List<Counterparty> findByNameContainingIgnoreCase(String namePart);
    
    @Query("SELECT c FROM Counterparty c JOIN c.trades t")
    List<Counterparty> findCounterpartiesWithTrades();
    
    @Query("SELECT c.name, COUNT(t) FROM Counterparty c LEFT JOIN c.trades t GROUP BY c.name")
    List<Object[]> countTradesByCounterparty();
}