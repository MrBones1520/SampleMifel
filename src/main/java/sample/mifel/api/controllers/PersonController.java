package sample.mifel.api.controllers;

import sample.mifel.api.request.PersonRequest;
import sample.mifel.api.response.PersonResponse;
import sample.mifel.api.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(
    origins = "*",
    maxAge = 3600
)
@RestController
@RequestMapping("/api/person")
public class PersonController {

    final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/test")
    public String test(){
        return "Data Access Public";
    }

    @PostMapping("/filter")
    @PreAuthorize("hasRole('MODERATOR')")
    public PersonResponse filterInfoPersonByName(@RequestBody @RequestHeader @Validated PersonRequest request){
        return personService.getAllRecordsFilterByName(request);
    }

    @GetMapping("/all")
    @PreAuthorize("hasRole('ADMIN')")
    public PersonResponse allPerson(){
        return personService.getAllRecords();
    }

}