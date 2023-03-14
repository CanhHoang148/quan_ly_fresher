package com.app.controll;

import com.app.model.dto.SubjectDTO;
import com.app.model.entity.Center;
import com.app.model.entity.Fresher;
import com.app.model.entity.Subject;
import com.app.model.response.ResponseObject;
import com.app.service.FresherService;
import com.app.service.SubjectService;
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

@ExtendWith(MockitoExtension.class)
class SubjectControllerTest {
    @Mock
    SubjectService subjectService;
    @InjectMocks
    SubjectController subjectController;
    private Subject subject;
    @BeforeEach
    void setUp() {
        subject = new Subject();
        subject.setSubjectId("1");
    }

    @Test
    void addSubject() {
        SubjectDTO subjectDTO = new SubjectDTO();
        subjectDTO.setSubjectId("1");
        subjectDTO.setLp("Java");

        ResponseEntity<ResponseObject> response = subjectController.addSubject(subjectDTO);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals("OK", response.getBody().getStatus());
        assertEquals("Done", response.getBody().getMsg());
        verify(subjectService, times(1)).addSubject(any(Subject.class));
    }

    @Test
    void getAllSubject() {
        List<Subject> subjectList = new ArrayList<>();
        subjectList.add(mock(Subject.class));
        subjectList.add(mock(Subject.class));

        Mockito.when(subjectService.getAllSubject()).thenReturn(subjectList);
        ResponseEntity<ResponseObject> response = subjectController.getAllSubject();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("OK", response.getBody().getStatus());
        assertEquals("Done", response.getBody().getMsg());

    }

    @Test
    void deleteSubject() {
        String subjectId = "valid_id";

        ResponseEntity<ResponseObject> response = subjectController.deleteSubject(subjectId);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals("OK", response.getBody().getStatus());
        assertEquals("Done", response.getBody().getMsg());
        assertEquals("", response.getBody().getData());
        verify(subjectService, times(1)).deleteSubject(subjectId);
    }

    @Test
    void editSubject() {
        SubjectDTO subjectDTO = new SubjectDTO();
        subjectDTO.setSubjectId("1");
        subjectDTO.setLp("Java");

        ResponseEntity<ResponseObject> response = subjectController.editSubject(subjectDTO);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals("Ok", response.getBody().getStatus());
        assertEquals("Change successfully", response.getBody().getMsg());
        verify(subjectService, times(1)).editSubject(any(Subject.class));
    }
}