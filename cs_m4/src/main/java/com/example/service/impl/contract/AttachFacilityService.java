package com.example.service.impl.contract;

import com.example.model.contract.AttachFacility;
import com.example.repository.contract.IAttachFacilityRepository;
import com.example.service.interfaceContract.IAttachFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttachFacilityService implements IAttachFacilityService {

    @Autowired
    private IAttachFacilityRepository attachFacilityRepository;
    @Override
    public List<AttachFacility> findAll() {
        return attachFacilityRepository.findAll();
    }

    @Override
    public AttachFacility finByID(Integer id) {
        return attachFacilityRepository.findById(id).get();
    }
}
