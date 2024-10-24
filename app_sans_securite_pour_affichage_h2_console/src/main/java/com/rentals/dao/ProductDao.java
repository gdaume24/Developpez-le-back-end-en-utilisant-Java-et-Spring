package com.rentals.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rentals.models.Product;


@Repository
public interface ProductDao extends JpaRepository<Product, Integer> {
  Product findById(int id);
  List<Product> findByPrixGreaterThan(int prixLimit);
}
