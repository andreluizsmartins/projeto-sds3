package com.martins.dsvendas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.martins.dsvendas.entities.Sale;


public interface SaleRepository extends JpaRepository<Sale, Long> {

}

