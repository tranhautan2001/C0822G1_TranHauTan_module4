package com.example.case_study_m4.repository.facility;

import com.example.case_study_m4.model.FacilityType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFacilityTypeRepository extends JpaRepository<FacilityType, Integer> {
}
