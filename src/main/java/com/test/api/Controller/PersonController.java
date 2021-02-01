package com.test.api.Controller;

import Model.Person;
import com.test.api.Service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

/**
 * PersonController.
 * Manages requests to handle Person objects.
 *
 * @author Alice B.
 * @version 28/01/2021
 */
@RestController
public class PersonController {
    /** The service competent to manage the Person objects. */
    @Resource
    PersonService personService;

    /**
     * Constructor.
     *
     * @param personService The service we use to make operations and respond to the client side.
     */
    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    /**
     * By default, we display a simple message.
     * (Generally used to make sure requests work).
     *
     * @return A simple message displayed on the client side.
     */
    @RequestMapping("/")
    public String index() {
        return "Hello World !";
    }

    /**
     * To add a new Person object.
     *
     * @param person The Person to add.
     */
    @PostMapping("/insert")
    @NonNull
    public void addPerson(@RequestBody Person person) {
        this.personService.insertPerson(person);
    }

    /**
     * To display a Person depending on the ID.
     * (Similar as a "SELECT").
     *
     * @param person The Person requested.
     * @return The Person corresponding to the ID previously communicated.
     */
    @GetMapping("/get-person-by-id")
    public Optional<Person> getPersonById(@RequestBody Person person) {
        return this.personService.selectPersonById(person.getId());
    }

    /**
     * To display all the Person objects.
     *
     * @return All the Person objects.
     */
    @GetMapping("/get-all-persons")
    public List<Person> getAllPersons() {
        return this.personService.getAllPersons();
    }

    /**
     * To update a Person.
     *
     * @param person The new Person informations to update.
     */
    @PutMapping("/update-person-by-id")
    public void updatePersonById(@RequestBody Person person) {
        this.personService.updatePersonById(person);
    }

    /**
     * To delete a Person object depending the ID communicated.
     *
     * @param person The Person object to delete.
     */
    @DeleteMapping("/delete-person-by-id")
    public void deletePersonById(@RequestBody Person person) {
        this.personService.deletePersonById(person.getId());
    }
}
