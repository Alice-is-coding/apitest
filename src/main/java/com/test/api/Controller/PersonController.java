package com.test.api.Controller;

import Model.Person;
import com.test.api.Service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
public class PersonController {
    @Resource
    PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @RequestMapping("/")
    public String index() {
        return "Hello World !";
    }

    @PostMapping("/{name}")
    @NonNull
    public void addPerson(@PathVariable(value = "name") String name) {
        this.personService.insertPerson(name);
    }

    @GetMapping("/get-all-persons")
    public List<Optional<Person>> getAllPersons() {
        return null;
    }

    @PutMapping("/{id}")
    public void updatePersonById(@PathVariable(value = "id") UUID id) {

    }

    @DeleteMapping("/{id}")
    public void deletePersonById(@PathVariable(value = "id") UUID id) {

    }
}
