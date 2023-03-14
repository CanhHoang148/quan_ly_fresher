package com.app.repositories;

import com.app.model.entity.FreCen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FreCenRepository extends JpaRepository<FreCen, Long> {
    @Query("SELECT new com.app.model.entity.FreCen" +
            "(fc.fresherCenterId, fc.fresher, fc.center) FROM FreCen fc " +
            "WHERE fc.fresher.fresherId = :fresherId AND fc.center.centerId = :centerId")
    public Optional<FreCen> getFC(String fresherId, String centerId);
}