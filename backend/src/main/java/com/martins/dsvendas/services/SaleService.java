package com.martins.dsvendas.services;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.martins.dsvendas.dto.SaleDTO;
import com.martins.dsvendas.entities.Sale;
import com.martins.dsvendas.repositories.SaleRepository;
import com.martins.dsvendas.repositories.SellerRepository;
@Service
public class SaleService {

	@Autowired
	private SaleRepository saleRepository;
	@Autowired
	private SellerRepository sellerRepository;
	@Transactional(readOnly = true)
	public List<SaleDTO> FindAll(){
		sellerRepository.findAll();
		List<Sale> result = saleRepository.findAll();
		return result.stream().map(x -> new SaleDTO(x)).collect(Collectors.toList());
		
	}
	
	@Transactional(readOnly = true)
	public Page<SaleDTO> FindAll(Pageable pageable) {
		sellerRepository.findAll();
		Page<Sale> result = saleRepository.findAll(pageable);
		return result.map(x -> new SaleDTO(x));

	}
	 
	public List<Object[]> totalSales(){
		List<Object[]> result = saleRepository.totalSales();
		return result;
		
	}
	
	public List<Object[]> taxSales(){
		List<Object[]> result = saleRepository.taxSales();
		return result;
		
	}
}
