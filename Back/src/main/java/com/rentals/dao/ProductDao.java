package com.rentals.dao;

import org.springframework.stereotype.Repository;

import com.rentals.models.Product;

import java.util.List;


public interface ProductDao {
  List<Product> findAll();
  Product findById(int id);
  Product save(Product product);
}
