package com.app.controll;

import com.app.model.entity.Fresher;
import com.app.model.response.ResponseObject;
import com.app.service.CenterService;
import com.app.service.QuizService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class QuizControllerTest {
    @Mock
    QuizService quizService;
    @InjectMocks
    QuizController quizController;
    @Test
    void getAllFresherOfQuiz() {
        Double average = 8.5;
        List<Fresher> fresherList = Arrays.asList(new Fresher(), new Fresher(), new Fresher());

        when(quizService.getAllFresherByQuiz(average)).thenReturn(fresherList);

        ResponseEntity<ResponseObject> response = quizController.getAllFresherOfQuiz(average);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals("Ok", response.getBody().getStatus());
        assertEquals("Done" , response.getBody().getMsg());
    }
}