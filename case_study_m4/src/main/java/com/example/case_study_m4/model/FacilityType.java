package com.example.case_study_m4.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class FacilityType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    @OneToMany(mappedBy = "facilityType")
    private Set<Facility> facilities;

    public FacilityType() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}