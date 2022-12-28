package com.example.service.impl.facility;

import com.example.model.facility.Facility;
import com.example.repository.facility.IFacilityRepository;
import com.example.service.interfaceFacility.IFacilityService;
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
    public Page<Facility> search(String name, String email, String type, Pageable pageable) {
        return null;
    }
}
