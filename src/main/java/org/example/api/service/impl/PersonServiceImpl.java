package org.example.api.service.impl;

import org.example.api.request.PersonRequest;
import org.example.api.response.PersonResponse;
import org.example.api.service.PersonService;
import org.example.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService {

    final PersonRepository personRepository;

    @Autowired
    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public PersonResponse getAllRecordsFilterByName(PersonRequest request) {
        var response = PersonResponse.createInstance();
        var result = request.getNombre().isBlank() ?
                personRepository.findAll() : personRepository.findAllByName(request.getNombre());
        response.calculateResult(result);

        return response;
    }

    @Override
    public PersonResponse getAllRecords() {
        var response = PersonResponse.createInstance();
        response.calculateResult(personRepository.findAll());

        return response;
    }


}
