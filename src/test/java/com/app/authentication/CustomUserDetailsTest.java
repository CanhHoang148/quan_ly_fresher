package com.app.authentication;

import com.app.model.user.User;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class CustomUserDetailsTest {

    @Test
    void getAuthorities() {
    }

    @Test
    void getPassword() {
    }

    @Test
    void getUsername() {
    }

    @Test
    void isAccountNonExpired() {
    }

    @Test
    void isAccountNonLocked() {
    }

    @Test
    void isCredentialsNonExpired() {
    }

    @Test
    void isEnabled() {
    }
    @Test
    void testCustomUserDetailsContructor(){
        User user = new User(1L,"canh","123");
        CustomUserDetails customUserDetails = new CustomUserDetails(user);
        assertEquals("canh",customUserDetails.getUsername());
        assertEquals("123",customUserDetails.getPassword());
    }
}