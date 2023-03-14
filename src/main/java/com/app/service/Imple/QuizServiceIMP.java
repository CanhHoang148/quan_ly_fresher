package com.app.service.Imple;

import com.app.exception.NotFoundException;
import com.app.model.entity.Fresher;
import com.app.model.response.ErrorMessages;
import com.app.repositories.QuizRepository;
import com.app.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizServiceIMP implements QuizService {
    @Autowired
    QuizRepository quizRepository;
    @Override
    public List<Fresher> getAllFresherByQuiz(Double average){
        List<Fresher> fresherList = quizRepository.findFresherByQuiz(average);
        if(fresherList.isEmpty()){
            throw new NotFoundException(ErrorMessages.FRESHER_NULL_ERROR);
        }
        return fresherList;
    }
}
