package com.example.service.interfaceContract;

import com.example.model.contract.ContractDetail;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface IContractDetailService {

    List<ContractDetail> findAll();
}
