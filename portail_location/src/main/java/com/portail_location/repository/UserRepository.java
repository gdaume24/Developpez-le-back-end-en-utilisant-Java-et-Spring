package com.portail_location.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.portail_location.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
    
    public User findByEmail(String email);
    
}
