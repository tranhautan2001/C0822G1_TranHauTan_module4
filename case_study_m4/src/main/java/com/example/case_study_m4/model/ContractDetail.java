package com.example.case_study_m4.model;

import javax.persistence.*;

@Entity
public class ContractDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String quantity;

    @ManyToOne(cascade = CascadeType.ALL)
    private AttachFacility attachFacility;

    @ManyToOne(cascade = CascadeType.ALL)
    private Contract contract;

    public ContractDetail() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public AttachFacility getAttachFacility() {
        return attachFacility;
    }

    public void setAttachFacility(AttachFacility attachFacility) {
        this.attachFacility = attachFacility;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }


}
