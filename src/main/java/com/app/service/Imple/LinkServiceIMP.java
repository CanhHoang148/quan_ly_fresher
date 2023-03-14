package com.app.service.Imple;

import com.app.exception.NotFoundException;
import com.app.model.entity.*;
import com.app.model.response.ErrorMessages;

import com.app.model.response.Transcript;
import com.app.repositories.*;
import com.app.service.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LinkServiceIMP implements LinkService {
    @Autowired
    FresherRepository fresherRepository;
    @Autowired
    CenterRepository centerRepository;
    @Autowired
    FreCenRepository freCenRepository;
    @Autowired
    SubjectRepository subjectRepository;
    @Autowired
    QuizRepository quizRepository;

    @Override
    public String addFresherToCenter(String fresherId, String centerId) {
        Optional<Fresher> fresher = fresherRepository.findById(fresherId);
        Optional<Center> center = centerRepository.findById(centerId);
        FreCen freCen = new FreCen();
        if (fresher.isEmpty()) {
            throw new NotFoundException(ErrorMessages.FRESHER_NULL_ERROR);
        }else if(center.isEmpty()) {
            throw new NotFoundException(ErrorMessages.CENTER_NULL_ERROR);
        }else if (freCenRepository.getFC(fresherId,centerId).isPresent()){
            throw new NotFoundException(ErrorMessages.FRESHER_CENTER_EXISTS_ERROR);
        }
        fresherRepository.findById(fresherId).ifPresent(freCen::setFresher);
        centerRepository.findById(centerId).ifPresent(freCen::setCenter);
        freCenRepository.save(freCen);
        return "Configuration";
    }
    @Override
    public Transcript addScore(Quiz quiz, String fresherId, String subjectId) {
        Optional<Fresher> fresher = fresherRepository.findById(fresherId);
        Optional<Subject> subject = subjectRepository.findById(subjectId);
        if (fresher.isEmpty()) {
            throw new NotFoundException(ErrorMessages.FRESHER_NULL_ERROR);
        }else if(subject.isEmpty()) {
            throw new NotFoundException(ErrorMessages.SUBJECT_NULL_ERROR);
        }else if (quizRepository.getScore(fresherId,subjectId).isPresent()){
            throw new NotFoundException(ErrorMessages.SCORE_EXISTS_ERROR);
        }
        fresherRepository.findById(fresherId).ifPresent(quiz::setFresher);
        subjectRepository.findById(subjectId).ifPresent(quiz::setSubject);
        quizRepository.save(quiz);
        return new Transcript(quiz);
    }

}
