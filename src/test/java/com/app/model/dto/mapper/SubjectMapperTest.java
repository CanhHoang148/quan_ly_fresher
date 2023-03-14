package com.app.model.dto.mapper;

import com.app.model.dto.SubjectDTO;
import com.app.model.entity.Subject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SubjectMapperTest {
    @Test
    void toSubject() {
        SubjectDTO subjectDTO = new SubjectDTO("1","Java");
        SubjectMapper subjectMapper = new SubjectMapper();
        Subject subject = subjectMapper.toSubject(subjectDTO);
        assertEquals("1",subject.getSubjectId());
        assertEquals("Java",subject.getLp());
    }
}
