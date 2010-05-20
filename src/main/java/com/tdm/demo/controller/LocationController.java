package com.tdm.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tdm.demo.dao.AddressDAO;
import com.tdm.demo.domain.Address;
import com.tdm.demo.domain.Location;
import com.tdm.demo.service.LocationService;

@Controller
public class LocationController {

    @Autowired
    private LocationService locationService;
    
    @Autowired
    private AddressDAO addressDAO;
    
    @RequestMapping("/testLocation")
    public String testSave(){
        Address address = (Address) addressDAO.get(1);
        Location location = new Location();
        location.setName("xuanwu");
        location.setAddress(address);
        locationService.save(location);
        return "ok";
    }
}
