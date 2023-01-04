package com.example.case_study_m4.service.interfaceFacility;

import com.example.case_study_m4.model.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IFacilityService {
    Page<Facility> finAll(Pageable pageable);
    boolean save(Facility facility );
    void delete(int id);
    boolean update(Facility facility);
    Facility findById(int id);
    Page<Facility> search(String name ,Integer FacilityTypeId, Pageable pageable);
}
