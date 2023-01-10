package com.example.repository.facility;

import com.example.model.facility.Facility;
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


    @Query(value = "select * from `facility` where flag_delete = false " , nativeQuery = true)
    Page<Facility> showList(Pageable pageable);
}
