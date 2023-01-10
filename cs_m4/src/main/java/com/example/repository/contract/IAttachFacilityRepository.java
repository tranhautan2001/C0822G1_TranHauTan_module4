package com.example.repository.contract;

import com.example.dto.IAttachFacilityDto;
import com.example.model.contract.AttachFacility;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IAttachFacilityRepository extends JpaRepository<AttachFacility, Integer> {
    @Query(value = "select attach_facility.id, attach_facility.name, attach_facility.cost, sum(ifnull(contract_detail.quantity, 0)) as totalQuantity , attach_facility.unit, attach_facility.status, ifnull(sum(contract_detail.quantity), 0) * ifnull(attach_facility.cost, 0) as total\n" +
            "            from attach_facility  join  contract_detail on contract_detail.attach_facility_id = attach_facility.id where contract_detail.contract_id = :id group by attach_facility.id", nativeQuery = true)
    List<IAttachFacilityDto> showList(@Param("id") Integer id);
}
