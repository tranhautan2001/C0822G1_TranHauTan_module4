package com.example.case_study_m4.service.impl.facility;

import com.example.case_study_m4.model.FacilityType;
import com.example.case_study_m4.repository.facility.IFacilityTypeRepository;
import com.example.case_study_m4.service.interfaceFacility.IFacilityTypeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacilityTypeService implements IFacilityTypeService {
    @Autowired
    private IFacilityTypeRepository facilityTypeRepository;
    @Override
    public List<FacilityType> findAll() {
        return facilityTypeRepository.findAll();
    }
}
