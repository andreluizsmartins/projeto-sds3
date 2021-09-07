package com.martins.dsvendas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	public ResponseEntity<List<Sale>> saleFindAll(){
		List<Sale> result = saleRepository.findAll();
		return ResponseEntity.ok(result);
		
	}
}
