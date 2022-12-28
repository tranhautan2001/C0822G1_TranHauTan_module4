package com.example.repository.facility;

import com.example.model.facility.Facility;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFacilityRepository extends JpaRepository<Facility ,Integer> {
}
