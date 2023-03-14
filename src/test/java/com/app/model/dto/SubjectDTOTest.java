package com.app.model.dto;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class SubjectDTOTest {
    @Test
    void getSubjectId() {
        SubjectDTO subjectDTO = new SubjectDTO();
        subjectDTO.setSubjectId("1");
        assertEquals("1",subjectDTO.getSubjectId());
    }

    @Test
    void getLp() {
        SubjectDTO subjectDTO = new SubjectDTO();
        subjectDTO.setLp("Java");
        assertEquals("Java",subjectDTO.getLp());
    }
    @Test
    void testSubjectDTOConstructor() {
        SubjectDTO subjectDTO = new SubjectDTO("1","Java");
        assertEquals("1",subjectDTO.getSubjectId());
        assertEquals("Java",subjectDTO.getLp());

    }
}
