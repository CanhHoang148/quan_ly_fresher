package com.app.service;

import com.app.model.entity.Subject;

import java.util.List;

public interface SubjectService {
    Subject addSubject(Subject subject);

    List<Subject> getAllSubject();

    void deleteSubject(String id);

    Subject editSubject(Subject subject);
}
