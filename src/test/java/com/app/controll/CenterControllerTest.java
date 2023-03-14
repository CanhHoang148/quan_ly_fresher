package com.app.controll;

import com.app.model.dto.CenterDTO;
import com.app.model.entity.Center;
import com.app.model.entity.Fresher;
import com.app.model.response.ResponseObject;
import com.app.service.CenterService;
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
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.mock;

@ExtendWith(MockitoExtension.class)
class CenterControllerTest {
    @Mock
    CenterService centerService;
    @InjectMocks
    CenterController centerController;
    private Center center;
    private Fresher fresher;
    @BeforeEach
    void setUp(){
        center = new Center();
        center.setCenterId("1");

        fresher = new Fresher();
        fresher.setFresherName("name1");
        fresher.setFresherEmail("email1");
    }
    @Test
    void getAllCenter() {
        List<Center> centerList = new ArrayList<>();
        centerList.add(mock(Center.class));
        centerList.add(mock(Center.class));

        Mockito.when(centerService.getAllCenter()).thenReturn(centerList);
        ResponseEntity<ResponseObject> response = centerController.getAllCenter();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("OK", response.getBody().getStatus());
        assertEquals("Successfully", response.getBody().getMsg());

    }

    @Test
    void addCenter() {
        CenterDTO centerDTO = new CenterDTO();
        centerDTO.setCenterName("A");
        centerDTO.setCenterId("1");
        centerDTO.setCenterAddress("address1");
        centerDTO.setCenterPhone("123");

        ResponseEntity<ResponseObject> response = centerController.addCenter(centerDTO);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals("OK", response.getBody().getStatus());
        assertEquals("Successfully", response.getBody().getMsg());
        verify(centerService, times(1)).addCenter(any(Center.class));

    }

    @Test
    void editCenter() {
        CenterDTO centerDTO = new CenterDTO();
        centerDTO.setCenterName("A");
        centerDTO.setCenterId("1");
        centerDTO.setCenterAddress("address1");
        centerDTO.setCenterPhone("123");

        ResponseEntity<ResponseObject> response = centerController.editCenter(centerDTO);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals("Ok", response.getBody().getStatus());
        assertEquals("Successfully", response.getBody().getMsg());
        verify(centerService, times(1)).editCenter(any(Center.class));
    }

    @Test
    void delete() {
        String centerId = "1";

        ResponseEntity<ResponseObject> response = centerController.delete(centerId);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals("OK", response.getBody().getStatus());
        assertEquals("Successfully", response.getBody().getMsg());
        assertEquals("", response.getBody().getData());
        verify(centerService, times(1)).deleteCenter(centerId);
    }

    @Test
    void getAllFresherOfCenter() {
        String centerId = "1";
        List<Fresher> fresherList = new ArrayList<>();
        fresherList.add(mock(Fresher.class));
        fresherList.add(mock(Fresher.class));

        when(centerService.getListFresherOfCenter(centerId)).thenReturn(fresherList);
        ResponseEntity<ResponseObject> response = centerController.getAllFresherOfCenter(centerId);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals("Ok", response.getBody().getStatus());
        assertEquals("Done " + centerId, response.getBody().getMsg());

    }

}