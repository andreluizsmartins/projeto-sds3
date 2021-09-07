package com.martins.dsvendas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.martins.dsvendas.entities.Sale;
import com.martins.dsvendas.entities.Seller;
import com.martins.dsvendas.repositories.SaleRepository;
import com.martins.dsvendas.repositories.SellerRepository;

@RestController
@RequestMapping(value = "/seller")
public class SellerController {
	@Autowired
	private SellerRepository sellerRepository;
	
	@GetMapping
	public ResponseEntity<List<Seller>> FindAll(){
		List<Seller> result = sellerRepository.findAll();
		return ResponseEntity.ok(result);
		
	}
	
}
