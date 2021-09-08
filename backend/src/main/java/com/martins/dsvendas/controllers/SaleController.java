package com.martins.dsvendas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.martins.dsvendas.dto.SaleDTO;
import com.martins.dsvendas.services.SaleService;

@RestController
@RequestMapping(value = "/sale")
public class SaleController {

	@Autowired(required=true)
	private SaleService service;
	
	@GetMapping
	public ResponseEntity<List<SaleDTO>> FindAll(){
		List<SaleDTO> result = service.FindAll();
		return ResponseEntity.ok(result);
		
	}
	
	  @GetMapping(value = "/page") public ResponseEntity<Page<SaleDTO>>
	  FindAll(Pageable pageable){ Page<SaleDTO> result = service.FindAll(pageable);
	  return ResponseEntity.ok(result);
	  
	  }
	 
	
	@GetMapping(value = "/totalSales")
	public ResponseEntity<List<Object[]>> totalSales(){
		List<Object[]> result = service.totalSales();
		return ResponseEntity.ok(result);
		
	}
	@GetMapping(value = "/taxSales")
	public ResponseEntity<List<Object[]>> taxSales(){
		List<Object[]> result = service.taxSales();
		return ResponseEntity.ok(result);
		
	}
}
