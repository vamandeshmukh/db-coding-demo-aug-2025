package com.db.coding.demo.service;


import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.db.coding.demo.model.Security;
import com.db.coding.demo.model.Trade;
import com.db.coding.demo.repository.TradeRepository;
import com.db.coding.demo.repository.UserRepository;

@Service
public class TradeService {

	@Autowired
    private TradeRepository tradeRepository;
	@Autowired
    private UserRepository userRepository;

    // Get all active bonds (open trades)
    @Transactional(readOnly = true)
    public List<Trade> getAllActiveBonds() {
        return tradeRepository.findByStatus("open");
    }

    // Get bonds maturing in next 5 business days
    @Transactional(readOnly = true)
    public List<Trade> getBondsMaturingInNext5Days() {
        LocalDate today = LocalDate.now();
        LocalDate endDate = today.plusDays(5);
        return tradeRepository.findByStatus("open").stream()
                .filter(trade -> {
                    LocalDate maturityDate = trade.getSecurity().getMaturityDate();
                    return !maturityDate.isBefore(today) && !maturityDate.isAfter(endDate);
                })
                .collect(Collectors.toList());
    }

    // Get bonds maturing in last and next 5 business days
    @Transactional(readOnly = true)
    public List<Trade> getBondsMaturingAroundCurrentDate() {
        LocalDate today = LocalDate.now();
        LocalDate startDate = today.minusDays(5);
        LocalDate endDate = today.plusDays(5);
        return tradeRepository.findByStatus("open").stream()
                .filter(trade -> {
                    LocalDate maturityDate = trade.getSecurity().getMaturityDate();
                    return !maturityDate.isBefore(startDate) && !maturityDate.isAfter(endDate);
                })
                .collect(Collectors.toList());
    }

    // Search trades by ISIN or CUSIP
    @Transactional(readOnly = true)
    public List<Trade> searchTradesBySecurityIdentifier(String identifier) {
        return tradeRepository.findAll().stream()
                .filter(trade -> {
                    Security security = trade.getSecurity();
                    return security.getIsin().equalsIgnoreCase(identifier) || 
                           (security.getCusip() != null && security.getCusip().equalsIgnoreCase(identifier));
                })
                .collect(Collectors.toList());
    }

    // Search trades by issuer name
    @Transactional(readOnly = true)
    public List<Trade> searchTradesByIssuer(String issuerName) {
        return tradeRepository.findAll().stream()
                .filter(trade -> trade.getSecurity().getIssuerName().toLowerCase()
                        .contains(issuerName.toLowerCase()))
                .collect(Collectors.toList());
    }

    // Search trades by counterparty name
    @Transactional(readOnly = true)
    public List<Trade> searchTradesByCounterparty(String counterpartyName) {
        return tradeRepository.findAll().stream()
                .filter(trade -> trade.getCounterparty().getName().toLowerCase()
                        .contains(counterpartyName.toLowerCase()))
                .collect(Collectors.toList());
    }

    // Get bonds in books assigned to a specific user
    @Transactional(readOnly = true)
    public List<Trade> getBondsForUserBooks(String userId) {
        if (!userRepository.existsById(userId)) {
            throw new IllegalArgumentException("User not found with ID: " + userId);
        }
        
        return tradeRepository.findTradesByUserId(userId).stream()
                .filter(trade -> "open".equals(trade.getStatus()))
                .collect(Collectors.toList());
    }

    // Get trade details by trade ID
    @Transactional(readOnly = true)
    public Trade getTradeDetails(String tradeId) {
        return tradeRepository.findById(tradeId)
				.orElseThrow(() -> new IllegalArgumentException("Trade not found with ID: " + tradeId));
	}
}