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
    @Query(value = "select * from facility where name like concat('%' :name '%' ) and facility_type where id like concat('%' :type '%')" ,nativeQuery = true)
    Page<Facility> searchFacility  (@Param("name")String name , @Param("type")String Type , Pageable pageable);
}
