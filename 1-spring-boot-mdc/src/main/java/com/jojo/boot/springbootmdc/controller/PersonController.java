package com.jojo.boot.springbootmdc.controller;

import com.jojo.boot.springbootmdc.entity.Person;
import com.jojo.boot.springbootmdc.service.PersonService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("persons")
public class PersonController {

    private final PersonService personService ;
    public PersonController(PersonService personService) {
        this.personService = personService ;
    }

    @GetMapping("{id}")
    public Person queryPerson(@PathVariable Integer id) {
        return this.personService.findById(id) ;
    }

    @GetMapping("task")public String task() {
        this.personService.task();
        return "success";
    }

}
