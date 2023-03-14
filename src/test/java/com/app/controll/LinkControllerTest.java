package com.app.controll;

import com.app.model.dto.QuizDTO;
import com.app.model.entity.Center;
import com.app.model.entity.Quiz;
import com.app.model.response.ResponseObject;
import com.app.service.CenterService;
import com.app.service.LinkService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class LinkControllerTest {
    @Mock
    LinkService linkService;
    @InjectMocks
    LinkController linkController;
    private Quiz quiz;
    @BeforeEach
    void setUp(){
        quiz = new Quiz();

    }
    @Test
    void addQuiz() {
//        QuizDTO quizDTO = new QuizDTO();
//
//        ResponseEntity<ResponseObject> response = linkController.addQuiz(quizDTO);
//
//        assertEquals(HttpStatus.OK, response.getStatusCode());
//        assertNotNull(response.getBody());
//        assertEquals("OK", response.getBody().getStatus());
//        assertEquals("Add score successfully", response.getBody().getMsg());
//        assertTrue((Boolean)response.getBody().getData());
//        verify(linkService).addScore(quiz, quizDTO.getFresherId(), quizDTO.getSubjectId());
    }

    @Test
    void addFresherToCenter() {
//        String fresherId = "fresher1";
//        String centerId = "center1";
//
//        ResponseEntity<ResponseObject> response = linkController.addFresherToCenter(fresherId, centerId);
//
//        assertEquals(HttpStatus.OK, response.getStatusCode());
//        assertNotNull(response.getBody());
//        assertEquals("OK", response.getBody().getStatus());
//        assertEquals("Add fresher to center successfully", response.getBody().getMsg());
//        assertTrue((Boolean)response.getBody().getData());
//        verify(linkService).addFresherToCenter(fresherId, centerId);
    }

}