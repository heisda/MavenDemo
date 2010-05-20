package com.tdm.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tdm.demo.dao.AddressDAO;
import com.tdm.demo.domain.Address;
import com.tdm.demo.service.AddressService;

@Service("addressService")
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressDAO addressDAO;
    
    public void save(Address address) {
        addressDAO.saveOrUpdate(address);
    }

}
