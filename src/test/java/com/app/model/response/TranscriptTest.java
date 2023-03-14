package com.app.model.response;

import com.app.model.entity.Center;
import com.app.model.entity.Fresher;
import com.app.model.entity.Quiz;
import com.app.model.entity.Subject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TranscriptTest {

    @Test
    void set_getFresherName() {
        Transcript transcript = new Transcript();
        transcript.setFresherName("name1");
        assertEquals("name1",transcript.getFresherName());
    }

    @Test
    void set_getId() {
        Transcript transcript = new Transcript();
        transcript.setId("1");
        assertEquals("1",transcript.getId());
    }

    @Test
    void set_getScore1() {
        Transcript transcript = new Transcript();
        transcript.setScore1(8.5);
        assertEquals(8.5,transcript.getScore1());
    }

    @Test
    void set_getScore2() {
        Transcript transcript = new Transcript();
        transcript.setScore2(9.0);
        assertEquals(9.0,transcript.getScore2());
    }

    @Test
    void set_getScore3() {
        Transcript transcript = new Transcript();
        transcript.setScore3(8.0);
        assertEquals(8.0,transcript.getScore3());
    }

    @Test
    void set_getAverage() {
        Transcript transcript = new Transcript();
        transcript.setAverage(8.5);
        assertEquals(8.5,transcript.getAverage());
    }

    @Test
    void testTranscriptConstruction(){
        String fresherName = "John Doe";
        String id = "1";
        Double score1 = 8.5;
        Double score2 = 9.0;
        Double score3 = 8.0;
        Double average = (score1 + score2 + score3) / 3;
        Transcript transcript = new Transcript(fresherName, id, score1, score2, score3, average);

        assertEquals(fresherName, transcript.getFresherName());
        assertEquals(id, transcript.getId());
        assertEquals(score1, transcript.getScore1());
        assertEquals(score2, transcript.getScore2());
        assertEquals(score3, transcript.getScore3());
        assertEquals(average, transcript.getAverage());
    }
    @Test
    void testTranscriptQuizConstructor(){
        Fresher fresher = new Fresher("","John Doe","","","");
        Subject subject = new Subject("","Java", null);
        Quiz quiz = new Quiz(1L,8.5, 9.0, 8.0, fresher, subject);
        Transcript transcript = new Transcript(quiz);

        assertEquals(fresher.getFresherName(), transcript.getFresherName());
        assertEquals(8.5, transcript.getScore1());
        assertEquals(9.0, transcript.getScore2());
        assertEquals(8.0, transcript.getScore3());
        assertEquals("John Doe",transcript.getFresherName());
        assertEquals("Java",transcript.getId());
    }
}