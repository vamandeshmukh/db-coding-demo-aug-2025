package com.db.coding.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.db.coding.demo.model.Trade;
import com.db.coding.demo.service.TradeService;

import java.util.List;

//Access the APIs here - 
//http://localhost:8090/api/v1/swagger-ui/index.html

@RestController
@RequestMapping("/trades")
public class TradeController {

	@Autowired
	private TradeService tradeService;

	@GetMapping("/active")
	public ResponseEntity<List<Trade>> getAllActiveBonds() {
		return ResponseEntity.ok(tradeService.getAllActiveBonds());
	}

	@GetMapping("/maturing/next-5-days")
	public ResponseEntity<List<Trade>> getBondsMaturingInNext5Days() {
		return ResponseEntity.ok(tradeService.getBondsMaturingInNext5Days());
	}

	@GetMapping("/maturing/around-current")
	public ResponseEntity<List<Trade>> getBondsMaturingAroundCurrentDate() {
		return ResponseEntity.ok(tradeService.getBondsMaturingAroundCurrentDate());
	}

	@GetMapping("/search/security")
	public ResponseEntity<List<Trade>> searchTradesBySecurityIdentifier(@RequestParam String identifier) {
		return ResponseEntity.ok(tradeService.searchTradesBySecurityIdentifier(identifier));
	}

	@GetMapping("/search/issuer")
	public ResponseEntity<List<Trade>> searchTradesByIssuer(@RequestParam String issuerName) {
		return ResponseEntity.ok(tradeService.searchTradesByIssuer(issuerName));
	}

	@GetMapping("/search/counterparty")
	public ResponseEntity<List<Trade>> searchTradesByCounterparty(@RequestParam String counterpartyName) {
		return ResponseEntity.ok(tradeService.searchTradesByCounterparty(counterpartyName));
	}

	@GetMapping("/user/{userId}")
	public ResponseEntity<List<Trade>> getBondsForUserBooks(@PathVariable String userId) {
		return ResponseEntity.ok(tradeService.getBondsForUserBooks(userId));
	}

	@GetMapping("/{tradeId}")
	public ResponseEntity<Trade> getTradeDetails(@PathVariable String tradeId) {
		return ResponseEntity.ok(tradeService.getTradeDetails(tradeId));
	}
}