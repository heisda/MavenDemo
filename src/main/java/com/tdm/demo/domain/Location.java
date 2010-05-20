package com.tdm.demo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;

@Entity
public class Location {

    @Id
    @GeneratedValue
    private Integer id;
    
    private String name;
    
    @OneToOne()
    @JoinTable(name="location_address", joinColumns = {@JoinColumn(name = "location_id")}, inverseJoinColumns = {@JoinColumn(name = "address_id")})
    private Address address;

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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
    
    
}
