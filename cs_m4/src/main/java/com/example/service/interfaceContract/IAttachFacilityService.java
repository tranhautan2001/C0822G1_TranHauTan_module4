package com.example.service.interfaceContract;

import com.example.dto.IAttachFacilityDto;
import com.example.model.contract.AttachFacility;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IAttachFacilityService {

    List<AttachFacility> findAll();

    AttachFacility finByID(Integer id);

    List<IAttachFacilityDto> showList(Integer id);
}
