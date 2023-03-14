package com.app.controll;

import com.app.model.dto.QuizDTO;
import com.app.model.dto.mapper.QuizMapper;
import com.app.model.entity.Quiz;
import com.app.model.response.ResponseObject;
import com.app.service.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/link") //http://localhost:8088/link
public class LinkController {
    @Autowired
    LinkService linkService;

    @PostMapping("/quiz")
    public @ResponseBody ResponseEntity<ResponseObject> addQuiz(@RequestBody QuizDTO quizDTO) {
        QuizMapper quizMapper = new QuizMapper();
        Quiz quiz = quizMapper.toquiz(quizDTO);
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("OK", "Add score successfully",
                        linkService.addScore(quiz, quizDTO.getFresherId(), quizDTO.getSubjectId()))
        );
    }

    @PostMapping("/freCen/{centerId}")
    public @ResponseBody ResponseEntity<ResponseObject> addFresherToCenter(@RequestParam String fresherId,
                                                                          @PathVariable String centerId) {
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("OK", "Add fresher to center successfully",
                        linkService.addFresherToCenter(fresherId,centerId))
        );
    }
}
