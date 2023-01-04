package com.example.case_study_m4.service.impl.facility;

import com.example.case_study_m4.model.RentType;
import com.example.case_study_m4.repository.facility.IRentTypeRepository;
import com.example.case_study_m4.service.interfaceFacility.IRentTypeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentTypeService implements IRentTypeService {
    @Autowired
    private IRentTypeRepository rentTypeRepository;

    @Override
    public List<RentType> findAll() {
        return rentTypeRepository.findAll();
    }
}
