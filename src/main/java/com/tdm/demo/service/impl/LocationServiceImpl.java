package com.tdm.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tdm.demo.dao.LocationDAO;
import com.tdm.demo.domain.Location;
import com.tdm.demo.service.LocationService;

@Service("locationService")
public class LocationServiceImpl implements LocationService {
    
    @Autowired
    private LocationDAO locationDAO;

    public Location save(Location location) {
        locationDAO.saveOrUpdate(location);
        return location;
    }

}
