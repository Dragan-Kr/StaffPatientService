package com.example.demo.impl;

import com.example.demo.dtos.PersonDTO;
import com.example.demo.entities.Person;
import com.example.demo.repository.IPersonRepository;
import com.example.demo.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PersonServiceImplem implements PersonService {

    @Autowired
    private IPersonRepository personRepository;

    private String baseUrl="http://localhost:8081/person";

    @Override
    public Integer getPersonById(Integer id) {
        RestTemplate personRest = new RestTemplate();
        PersonDTO person = personRest.getForObject(baseUrl + "/" + id,PersonDTO.class);
        Person mappedPerson = new Person();
        mappedPerson.setAddress(person.getAddress());
        mappedPerson.setBirthDate(person.getBirthDate());
        mappedPerson.setFirstName(person.getFirstName());
        mappedPerson.setGender(person.getGender());
        mappedPerson.setJmbg(person.getJmbg());
        mappedPerson.setLastName(person.getLastName());
        mappedPerson.setPhone(person.getPhone());
        mappedPerson.setId(person.getId());
        return  mappedPerson.getId();

    }
}

