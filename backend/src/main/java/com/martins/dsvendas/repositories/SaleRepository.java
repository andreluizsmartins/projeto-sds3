package com.martins.dsvendas.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.martins.dsvendas.entities.Sale;


public interface SaleRepository extends JpaRepository<Sale, Long> {

	@Query(value ="SELECT sel.name as name, sum(sal.amount) * 100.0 / SUM(SUM(sal.amount)) OVER () as percentage FROM TB_SALES sal, TB_SELLERS sel where sel.id=sal.seller_id group by sel.name ", nativeQuery = true)
	List<Object[]> totalSales();
	
	@Query(value ="SELECT sel.name as name, (sum(sal.deals) *100.0 /sum(sal.visited)) as percentage FROM TB_SALES sal, TB_SELLERS sel where sel.id=sal.seller_id group by sel.name ", nativeQuery = true)
	List<Object[]> taxSales();
}

