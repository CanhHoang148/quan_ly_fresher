package com.app.model.response;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import static org.junit.jupiter.api.Assertions.*;

class ErrorResponseTest {

    @Test
    void set_getStatus() {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setStatus(HttpStatus.OK);
        assertEquals(HttpStatus.OK,errorResponse.getStatus());
    }

    @Test
    void set_getMsg() {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setMsg("A");
        assertEquals("A",errorResponse.getMsg());
    }

    @Test
    void testContructor() {
        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.OK,"A");
        assertEquals(HttpStatus.OK,errorResponse.getStatus());
        assertEquals("A",errorResponse.getMsg());
    }
}