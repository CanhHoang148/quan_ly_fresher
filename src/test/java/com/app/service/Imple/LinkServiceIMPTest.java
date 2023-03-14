package com.app.service.Imple;

import com.app.model.entity.*;
import com.app.model.response.ErrorMessages;
import com.app.model.response.Transcript;
import com.app.repositories.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class LinkServiceIMPTest {
    @Mock
    FresherRepository fresherRepository;
    @Mock
    CenterRepository centerRepository;
    @Mock
    FreCenRepository freCenRepository;
    @Mock
    SubjectRepository subjectRepository;
    @Mock
    QuizRepository quizRepository;
    @InjectMocks
    LinkServiceIMP linkServiceIMP;

    @Test
    void addFresherToCenter() {
        String fresherId = "fresherId";
        String centerId  = "centerId";

        when(fresherRepository.findById(fresherId)).thenReturn(Optional.of(new Fresher()));
        when(centerRepository.findById(centerId)).thenReturn(Optional.of(new Center()));
        when(freCenRepository.getFC(fresherId, centerId)).thenReturn(Optional.empty());
        assertEquals("Configuration", linkServiceIMP.addFresherToCenter(fresherId, centerId));
        verify(freCenRepository, times(1)).save(any(FreCen.class));
    }

    @Test
    void addFresherToCenterButFresherNotFound(){

    }
    @Test
    void addFresherToCenterButCenterNotFound(){

    }
    @Test
    void addFresherToCenterButExit(){

    }

    @Test
    void addScore() {

    }
    @Test
    void addScoreFresherNotFound(){

    }
    @Test
    void addScoreSubjectNotFound(){

    }
    @Test
    void addScoreButExit(){

    }
}