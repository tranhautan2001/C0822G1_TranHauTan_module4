package com.example.case_study_m4.repository.facility;

import com.example.case_study_m4.model.RentType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRentTypeRepository extends JpaRepository<RentType, Integer> {
}
