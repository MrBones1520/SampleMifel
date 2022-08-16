package org.example.api.controllers;

import org.example.api.request.PersonRequest;
import org.example.api.response.PersonResponse;
import org.example.api.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/person")
public class PersonController {

    final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping("/filter")
    public PersonResponse filterInfoPersonByName(@RequestBody @Validated PersonRequest request){
        return personService.getAllRecordsFilterByName(request);
    }

    @GetMapping("/all")
    public PersonResponse allPerson(){
        return personService.getAllRecords();
    }

}