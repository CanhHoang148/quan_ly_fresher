package com.app.service;

import com.app.model.entity.Fresher;

import java.util.List;

public interface QuizService {
    List<Fresher> getAllFresherByQuiz(Double average);
}
