package com.example.service.interfaceFacility;

import com.example.model.facility.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IFacilityService {
    Page<Facility> finAll(Pageable pageable);
    boolean save(Facility facility );
    void delete(int id);
    boolean update(Facility facility);
    Facility findById(int id);
    Page<Facility> search(String name, String email, String type, Pageable pageable);
}
