package com.app.model.dto.mapper;

import com.app.model.dto.QuizDTO;
import com.app.model.entity.Quiz;

public class QuizMapper {
    public Quiz toquiz(QuizDTO quizDTO){
        Quiz quiz = new Quiz();
        quiz.setScore1(quizDTO.getScore1());
        quiz.setScore2(quizDTO.getScore2());
        quiz.setScore3(quizDTO.getScore3());
        return quiz;
    }
}
