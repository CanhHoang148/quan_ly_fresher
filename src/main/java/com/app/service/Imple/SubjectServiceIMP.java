package com.app.service.Imple;

import com.app.exception.NotFoundException;
import com.app.exception.NotImplementedException;
import com.app.model.entity.Subject;
import com.app.model.response.ErrorMessages;
import com.app.repositories.SubjectRepository;
import com.app.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubjectServiceIMP implements SubjectService {
    @Autowired
    SubjectRepository subjectRepository;
    @Override
    public Subject addSubject (Subject subject){
        Optional<Subject> subject1 = subjectRepository.findById(subject.getSubjectId());
        if(subject1.isPresent()) {
            throw new NotImplementedException(ErrorMessages.SUBJECT_EXIT_ERROR);
        }
        return subjectRepository.save(subject);
    }
    @Override
    public List<Subject> getAllSubject(){
        return subjectRepository.findAll();
    }
    @Override
    public void deleteSubject(String id){
        boolean exit = subjectRepository.existsById(id);
        if(!exit){
            throw new NotFoundException(ErrorMessages.SUBJECT_NULL_ERROR);
        }
        subjectRepository.deleteById(id);
    }

    @Override
    public Subject editSubject(Subject subject){
        return subjectRepository.findById(subject.getSubjectId())
                .map(f -> {
                    f.setSubjectId(subject.getSubjectId());
                    f.setLp(subject.getLp());
                    return subjectRepository.save(f);
                }).orElseGet(()-> subjectRepository.save(subject));
    }
}
