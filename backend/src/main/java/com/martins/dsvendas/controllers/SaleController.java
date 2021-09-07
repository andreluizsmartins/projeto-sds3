package com.martins.dsvendas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.martins.dsvendas.entities.Sale;
import com.martins.dsvendas.repositories.SaleRepository;

@RestController
@RequestMapping(value = "/sale")
public class SaleController {

	@Autowired
	private SaleRepository saleRepository;
	
	@GetMapping
	public ResponseEntity<List<Sale>> FindAll(){
		List<Sale> result = saleRepository.findAll();
		return ResponseEntity.ok(result);
		
	}
	@GetMapping(value = "/page")
	public ResponseEntity<Page<Sale>> FindAll(Pageable pageable){
		Page<Sale> result = saleRepository.findAll(pageable);
		return ResponseEntity.ok(result);
		
	}
	
	@GetMapping(value = "/totalSales")
	public ResponseEntity<List<Object[]>> totalSales(){
		List<Object[]> result = saleRepository.totalSales();
		return ResponseEntity.ok(result);
		
	}
	@GetMapping(value = "/taxSales")
	public ResponseEntity<List<Object[]>> taxSales(){
		List<Object[]> result = saleRepository.taxSales();
		return ResponseEntity.ok(result);
		
	}
}
