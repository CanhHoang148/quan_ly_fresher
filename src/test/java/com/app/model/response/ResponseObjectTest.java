package com.app.model.response;

import com.app.model.entity.Fresher;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ResponseObjectTest {

    @Test
    void set_getStatus() {
        ResponseObject responseObject = new ResponseObject();
        responseObject.setStatus("OK");
        assertEquals("OK",responseObject.getStatus());
    }

    @Test
    void set_getMsg() {
        ResponseObject responseObject = new ResponseObject();
        responseObject.setMsg("OK?");
        assertEquals("OK?",responseObject.getMsg());
    }

    @Test
    void set_getData() {
        Fresher fresher = new Fresher("id1","name1",
                "address1","phone1","email1");
        ResponseObject responseObject = new ResponseObject();
        responseObject.setData(fresher);
        assertEquals(fresher,responseObject.getData());
    }

    @Test
    void testContructor() {
        ResponseObject responseObject = new ResponseObject("OK","OK?","string");
        assertEquals("OK",responseObject.getStatus());
        assertEquals("OK?",responseObject.getMsg());
        assertEquals("string",responseObject.getData());
    }
}