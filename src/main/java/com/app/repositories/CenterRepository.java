package com.app.repositories;

import com.app.model.entity.Center;
import com.app.model.entity.Fresher;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CenterRepository extends JpaRepository<Center,String> {
    @Query("SELECT new com.app.model.entity.Fresher" +
            "(f.fresherId ,f.fresherName, f.fresherAddress, f.fresherPhone, f.fresherEmail) " +
            "From Fresher f INNER JOIN FreCen fc ON fc.fresher.fresherId = f.fresherId INNER JOIN " +
            "Center ce ON ce.centerId = fc.center.centerId " +
            "WHERE ce.centerId = :centerId")
    public List<Fresher> getFresherOfCenter(String centerId);
}