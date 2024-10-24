package com.rentals.controllers;

import java.net.URI;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.rentals.dao.ProductDao;
import com.rentals.exceptions.ProduitIntrouvableException;
import com.rentals.models.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController

public class ProductController {

  @Autowired

private ProductDao productDao;

  //Récupérer la liste des produits
  @RequestMapping(value = "/Produits", method = RequestMethod.GET)

  public MappingJacksonValue listeProduits() {

   Iterable<Product> produits = productDao.findAll();

    SimpleBeanPropertyFilter monFiltre = SimpleBeanPropertyFilter.serializeAllExcept("prixAchat");

    FilterProvider listDeNosFiltres = new SimpleFilterProvider().addFilter("monFiltreDynamique", monFiltre);

    MappingJacksonValue produitsFiltres = new MappingJacksonValue(produits);

   produitsFiltres.setFilters(listDeNosFiltres);

   return produitsFiltres;
  }

  //Récupérer un produit par son Id
  @GetMapping(value = "/Produits/{id}")
  public Product afficherUnProduit(@PathVariable int id) {
    Product produit = productDao.findById(id);
      if(produit==null) throw new ProduitIntrouvableException("Le produit avec l'id " + id + " est INTROUVABLE. Écran Bleu si je pouvais.");
    return produit;
  }

  @GetMapping(value = "test/produits/{prixLimit}")
  public List<Product> testeDeRequetes(@PathVariable int prixLimit) 
  {
    return productDao.findByPrixGreaterThan(prixLimit);
  }

  //ajouter un produit
  @PostMapping(value = "/Produits")
  public ResponseEntity<Void> ajouterProduit(@RequestBody Product product) {
    Product productAdded =  productDao.save(product);

    if (productAdded == null)
      return ResponseEntity.noContent().build();

    URI location = ServletUriComponentsBuilder
          .fromCurrentRequest()
          .path("/{id}")
          .buildAndExpand(productAdded.getId())
          .toUri();
    return ResponseEntity.created(location).build();
  }

  @PutMapping (value = "/Produits")
 public void updateProduit(@RequestBody Product product)
 {
    productDao.save(product);
 }

  @DeleteMapping (value = "/Produits/{id}")
  public void supprimerProduit(@PathVariable int id) {
    productDao.deleteById(id);
  }
}