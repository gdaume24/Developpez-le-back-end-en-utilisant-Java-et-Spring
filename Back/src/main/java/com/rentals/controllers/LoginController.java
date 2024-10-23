package com.rentals.controllers;

import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rentals.dao.ProductDao;
import com.rentals.models.Product;
import com.rentals.services.JWTService;


@RestController
public class LoginController {

    private final ProductDao productDao;
    private JWTService jwtService;
    
    public LoginController(JWTService jwtService, ProductDao productDao) {
        this.jwtService = jwtService;
        this.productDao = productDao;
    }
    
    @PostMapping("/login")
    public String getToken(Authentication authentication) {
                String token = jwtService.generateToken(authentication);
                return token;
    }

    @PostMapping(value = "/Produits")
    public void ajouterProduit(@RequestBody Product product) {
    productDao.save(product);
    }

    @GetMapping("/Produits")
    public List<Product> listeProduits() {
        return productDao.findAll();
    }

    //Récupérer un produit par son Id
    @GetMapping(value = "/Produits/{id}")
    public Product afficherUnProduit(@PathVariable int id) {
        return productDao.findById(id);
    }
    
}
