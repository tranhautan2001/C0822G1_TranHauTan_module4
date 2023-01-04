package com.example.service.impl.contract;

import com.example.model.contract.Contract;
import com.example.repository.contract.IContractRepository;
import com.example.service.interfaceContract.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractService implements IContractService {

    @Autowired
    private IContractRepository contractRepository;

    @Override
    public List<Contract> findAll() {
        return contractRepository.findAll();
    }

    @Override
    public void add(Contract contract) {
        contractRepository.save(contract);
    }

}
