package com.portail_location.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
	private String email;
	private String password;
	private String name;

    public String getEmail() {
        return this.email;
    }
    public String getPassword() {
        return this.password;
    }
    public String getUsername() {
        return this.name;
    }
    
}
