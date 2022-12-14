package com.example.case_study_m4.repository.facility;
import com.example.case_study_m4.model.Facility;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IFacilityRepository extends JpaRepository<Facility ,Integer> {
    @Query(value = "select * from facility where name like concat('%', :name, '%') and facility_type_id like concat('%', :facilityTypeId, '%')", nativeQuery = true)
    Page<Facility> searchFacility(@Param("name") String name, @Param("facilityTypeId") Integer facilityTypeId, Pageable pageable);


}
