package com.chatop.dtos;

public class RegisterUserDto {
    private String email;
    
    private String password;
    
    private String fullName;

    public String getEmail() {
        return this.email;
    }

    public String getPassword() {
        return this.password;
    }

    public String getFullName() {
        return this.fullName;
    }
    
    // getters and setters here...
}
