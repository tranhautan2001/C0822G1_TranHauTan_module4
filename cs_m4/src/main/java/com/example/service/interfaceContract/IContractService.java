package com.example.service.interfaceContract;

import com.example.model.contract.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.util.List;

public interface IContractService {

    Page<Contract> findAll(Pageable pageable);
    void add (Contract contract);
}
