package com.app.controll;

import com.app.model.dto.FresherDTO;
import com.app.model.entity.Center;
import com.app.model.entity.Fresher;
import com.app.model.response.ResponseObject;
import com.app.service.FresherService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class FresherControllerTest {
    @Mock
    FresherService fresherService;
    @InjectMocks
    FresherController fresherController;
    private Center center;
    private Fresher fresher;
    @BeforeEach
    void setUp() {
        fresher = new Fresher();
        fresher.setFresherId("1");
        fresher.setFresherEmail("email1");
    }

    @Test
    void getAll() {
        List<Fresher> fresherList = new ArrayList<>();
        fresherList.add(mock(Fresher.class));
        fresherList.add(mock(Fresher.class));

        Mockito.when(fresherService.getAllFresher()).thenReturn(fresherList);
        ResponseEntity<ResponseObject> response = fresherController.getAll();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("OK", response.getBody().getStatus());
        assertEquals("Get all fresher successfully", response.getBody().getMsg());

    }

    @Test
    void addFresher() {
        FresherDTO fresherDTO = new FresherDTO();
        fresherDTO.setFresherId("1");
        fresherDTO.setFresherName("name1");
        fresherDTO.setFresherAddress("address1");
        fresherDTO.setFresherEmail("email1");
        fresherDTO.setFresherPhone("123");

        ResponseEntity<ResponseObject> response = fresherController.addFresher(fresherDTO);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals("OK", response.getBody().getStatus());
        assertEquals("Insert fresher successfully", response.getBody().getMsg());
        verify(fresherService, times(1)).addFresher(any(Fresher.class));
    }

    @Test
    void editFresher() {
        FresherDTO fresherDTO = new FresherDTO();
        fresherDTO.setFresherId("1");
        fresherDTO.setFresherName("name1");
        fresherDTO.setFresherAddress("address1");
        fresherDTO.setFresherEmail("email1");
        fresherDTO.setFresherPhone("123");

        ResponseEntity<ResponseObject> response = fresherController.editFresher(fresherDTO);

        assertEquals(HttpStatus.OK,response.getStatusCode());assertNotNull(response.getBody());
        assertEquals("Ok", response.getBody().getStatus());
        assertEquals("Change or insert fresher successfully", response.getBody().getMsg());
        verify(fresherService, times(1)).editFresher(any(Fresher.class));
    }

    @Test
    void delete() {
        String fresherId = "valid_id";

        ResponseEntity<ResponseObject> response = fresherController.delete(fresherId);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals("OK", response.getBody().getStatus());
        assertEquals("Done", response.getBody().getMsg());
        assertEquals("", response.getBody().getData());
        verify(fresherService, times(1)).deleteFresher(fresherId);
    }

    @Test
    void searchFresherWithFresherName() {
        String fresherName = "name1";
        List<Fresher> searchResults = Collections.singletonList(new Fresher());
        when(fresherService.searchFresherWithFresherName(fresherName)).thenReturn(searchResults);

        ResponseEntity<ResponseObject> response = fresherController.searchFresherWithFresherName(fresherName);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("OK", response.getBody().getStatus());
        assertEquals("Done", response.getBody().getMsg());
        verify(fresherService).searchFresherWithFresherName(fresherName);
    }

    @Test
    void searchFresherWithFresherEmail() {

    }

    @Test
    void searchFresherWithLP() {
        String lp = "LP1";
        List<Fresher> searchResults = Collections.singletonList(new Fresher());
        when(fresherService.searchFresherWithLP(lp)).thenReturn(searchResults);

        ResponseEntity<ResponseObject> response = fresherController.searchFresherWithLP(lp);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("OK", response.getBody().getStatus());
        assertEquals("Done", response.getBody().getMsg());
        verify(fresherService).searchFresherWithLP(lp);
    }

    @Test
    void getTranscript() {

    }
}