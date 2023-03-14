package com.app.model.user;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LoginRequestTest {

    @Test
    void getUsername() {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername("A");
        assertEquals("A",loginRequest.getUsername());
    }

    @Test
    void getPassword() {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setPassword("123");
        assertEquals("123",loginRequest.getPassword());
    }

    @Test
    void setUsername() {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername("A");
        assertEquals("A",loginRequest.getUsername());
    }

    @Test
    void setPassword() {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setPassword("123");
        assertEquals("123",loginRequest.getPassword());
    }
    @Test
    void testContructor(){
        LoginRequest loginRequest = new LoginRequest("A","123");
        assertEquals("A",loginRequest.getUsername());
        assertEquals("123",loginRequest.getPassword());
    }
}