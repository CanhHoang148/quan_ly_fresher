package com.app.controll;

import com.app.model.response.ResponseObject;
import com.app.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@RestController
@RequestMapping("/quiz")
public class QuizController {
    @Autowired
    QuizService quizService;
    @GetMapping("/getFresher/{average}")
    public ResponseEntity<ResponseObject> getAllFresherOfQuiz (@PathVariable Double average){
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("Ok","Done",
                        Collections.singletonList(quizService.getAllFresherByQuiz(average)))
        );
    }
}
