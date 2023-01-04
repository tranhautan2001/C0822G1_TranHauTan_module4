package com.example.case_study_m4.service.impl.facility;

import com.example.case_study_m4.model.Facility;
import com.example.case_study_m4.repository.facility.IFacilityRepository;
import com.example.case_study_m4.service.interfaceFacility.IFacilityService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class FacilityService implements IFacilityService {

    @Autowired
    private IFacilityRepository facilityRepository;

    @Override
    public Page<Facility> finAll(Pageable pageable) {
        return facilityRepository.findAll(pageable);
    }

    @Override
    public boolean save(Facility facility) {
        try {
            facilityRepository.save(facility);
        } catch (
                IllegalArgumentException | OptimisticLockingFailureException e) {
            return false;
        }
        return true;
    }

    @Override
    public void delete(int id) {
      facilityRepository.deleteById(id);
    }

    @Override
    public boolean update(Facility facility) {
        try {
            facilityRepository.save(facility);
        } catch (
                IllegalArgumentException | OptimisticLockingFailureException e) {
            return false;
        }
        return true;
    }

    @Override
    public Facility findById(int id) {
        return facilityRepository.findById(id).get();
    }

    @Override
    public Page<Facility> search(String name,Integer facilityTypeId, Pageable pageable) {
        return facilityRepository.searchFacility(name ,facilityTypeId,pageable);
    }
}
