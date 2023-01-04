package com.example.service.interfaceContract;

import com.example.model.contract.Contract;



import java.util.List;

public interface IContractService {

    List<Contract> findAll();
    void add (Contract contract);
}
