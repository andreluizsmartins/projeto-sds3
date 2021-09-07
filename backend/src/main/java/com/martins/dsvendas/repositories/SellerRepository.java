package com.martins.dsvendas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.martins.dsvendas.entities.Seller;

public interface SellerRepository extends JpaRepository<Seller, Long> {

}
