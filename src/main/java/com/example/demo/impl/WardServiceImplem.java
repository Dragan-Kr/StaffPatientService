package com.example.demo.impl;

import com.example.demo.dtos.PersonDTO;
import com.example.demo.dtos.WardDTO;
import com.example.demo.entities.Person;
import com.example.demo.entities.Ward;
import com.example.demo.repository.IWardRepository;
import com.example.demo.services.WardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WardServiceImplem implements WardService {

    @Autowired
    private IWardRepository wardRepository;
    private String baseUrl="http://localhost:8080/ward";

    @Override
    public Ward getWardById(Integer wardid) {
       RestTemplate wardRest = new RestTemplate();
        WardDTO ward = wardRest.getForObject(baseUrl + "/" +wardid,WardDTO.class);
        Ward mappedWard = new Ward();
        mappedWard.setCapacity(ward.getCapacity());
        mappedWard.setName(ward.getName());
        mappedWard.setId(ward.getId());
        return mappedWard;
    }
}


