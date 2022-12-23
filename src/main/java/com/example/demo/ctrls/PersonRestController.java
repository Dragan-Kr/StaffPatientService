package com.example.demo.ctrls;

import com.example.demo.entities.Patient;
import com.example.demo.entities.Person;
import com.example.demo.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:8083")
@RestController
public class PersonRestController {

    @Autowired
   private PersonService personService;


//    @GetMapping("person/{id}")
//    public Person getByID(@PathVariable("id") Integer id) {
//        return personService.getOneObject(id);
//    }
}
