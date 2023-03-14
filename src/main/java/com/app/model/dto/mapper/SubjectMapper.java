package com.app.model.dto.mapper;

import com.app.model.dto.SubjectDTO;
import com.app.model.entity.Subject;

public class SubjectMapper {
    public Subject toSubject(SubjectDTO subjectDTO){
        Subject subject = new Subject();
        subject.setSubjectId(subjectDTO.getSubjectId());
        subject.setLp(subjectDTO.getLp());
        return subject;
    }
}
