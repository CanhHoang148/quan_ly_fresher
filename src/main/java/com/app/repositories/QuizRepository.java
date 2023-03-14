package com.app.repositories;

import com.app.model.entity.Fresher;
import com.app.model.entity.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.List;
import java.util.Optional;

public interface QuizRepository extends JpaRepository<Quiz, Long> {
    @Query("SELECT new com.app.model.entity.Quiz" +
            "(sc.quizId, sc.score1, sc.score2, sc.score3, sc.fresher, sc.subject) " +
            "FROM Quiz sc WHERE sc.fresher.fresherId = :fresherId AND sc.subject.subjectId = :subjectId")
    public Optional<Quiz> getScore(String fresherId, String subjectId);
    @Query("SELECT new com.app.model.entity.Fresher" +
            "(f.fresherId, f.fresherName, f.fresherAddress, f.fresherPhone, f.fresherEmail) " +
            "FROM Fresher f INNER JOIN Quiz q ON q.fresher.fresherId = f.fresherId " +
            "GROUP BY f.fresherId, q.score1, q.score2, q.score3 " +
            "HAVING (q.score1+ q.score2+ q.score3)/3.0 = :average")
    public List<Fresher> findFresherByQuiz(Double average);

}