package com.app.service.Imple;

import com.app.exception.NotFoundException;
import com.app.exception.NotImplementedException;
import com.app.model.entity.Subject;
import com.app.repositories.SubjectRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class SubjectServiceIMPTest {
    @Mock
    SubjectRepository subjectRepository;
    @InjectMocks
    SubjectServiceIMP subjectServiceIMP;
    private Subject subject;
    @BeforeEach
    void setUp() {
        subject = new Subject();
        subject.setSubjectId("1");
    }

    @Test
    void addSubject() {
        when(subjectRepository.findById(subject.getSubjectId()))
                .thenReturn(Optional.empty());
        when(subjectRepository.save(subject)).thenReturn(subject);
        Subject subject1 = subjectServiceIMP.addSubject(subject);
        assertThat(subject1).isNotNull();
    }

    @Test
    void addSubjectButException(){
        when(subjectRepository.findById(subject.getSubjectId()))
                .thenReturn(Optional.of(subject));
        assertThrows(NotImplementedException.class,()->{
            subjectServiceIMP.addSubject(subject);
        });
        verify(subjectRepository,times(1)).findById(subject.getSubjectId());
        verify(subjectRepository, never()).save(subject);
    }

    @Test
    void getAllSubject() {
        List<Subject> subjectList = new ArrayList<>();
        subjectList.add(mock(Subject.class));
        subjectList.add(mock(Subject.class));

        when(subjectRepository.findAll()).thenReturn(subjectList);

        List<Subject> subjects = subjectServiceIMP.getAllSubject();
        int num = subjects.size();
        assertThat(num).isEqualTo(subjectList.size());
        verify(subjectRepository).findAll();
    }

    @Test
    void deleteSubject() {
        when(subjectRepository.existsById(subject.getSubjectId()))
                .thenReturn(Boolean.TRUE);
        subjectServiceIMP.deleteSubject(subject.getSubjectId());
        verify(subjectRepository).deleteById(subject.getSubjectId());
    }
    @Test
    void deleteSubjectButException(){
        String id = "1";
        when(subjectRepository.existsById(subject.getSubjectId()))
                .thenReturn(Boolean.FALSE);
        assertThrows(NotFoundException.class,()->{
            subjectServiceIMP.deleteSubject(id);
        });
        verify(subjectRepository,never()).deleteById(id);
    }

    @Test
    void editSubject() {
        when(subjectRepository.findById(subject.getSubjectId())).thenReturn(Optional.of(subject));
        when(subjectRepository.save(subject)).thenReturn(subject);
        Subject upSubject = subjectRepository.findById(subject.getSubjectId())
                .map(subject1 ->  {
                    subject1.setSubjectId(subject1.getSubjectId());
                    subject1.setLp(subject1.getLp());
                    return subjectRepository.save(subject1);
                }).orElseGet(()-> subjectRepository.save(subject));
        Subject newSubject = subjectServiceIMP.editSubject(subject);
        assertEquals(newSubject, upSubject);
    }
    @Test
    void editSubjectButException(){
        when(subjectRepository.findById(subject.getSubjectId())).thenReturn(Optional.empty());
        when(subjectRepository.save(subject)).thenReturn(subject);
        Subject upSubject = subjectRepository.findById(subject.getSubjectId())
                .map(subject1 ->  {
                    subject1.setSubjectId(subject1.getSubjectId());
                    subject1.setLp(subject1.getLp());
                    return subjectRepository.save(subject1);
                }).orElseGet(()-> subjectRepository.save(subject));
        Subject newSubject = subjectServiceIMP.editSubject(subject);
        assertEquals(newSubject, upSubject);
    }

}