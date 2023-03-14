package com.app.service;

import com.app.model.entity.Quiz;

public interface LinkService {
    String addFresherToCenter(String centerId, String fresherId);

    Quiz addScore(Quiz quiz, String fresherId, String subjectId);
}
