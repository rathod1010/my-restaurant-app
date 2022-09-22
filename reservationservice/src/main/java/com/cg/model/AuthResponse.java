package com.cg.model;

public class AuthResponse {
    private String name;
    
    private boolean isValid;
    public AuthResponse(String name, boolean isValid) {
        super();
        this.name = name;
        this.isValid = isValid;
    }
    public AuthResponse() {
        super();
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
   
    public boolean isValid() {
        return isValid;
    }
    public void setValid(boolean isValid) {
        this.isValid = isValid;
    }
}