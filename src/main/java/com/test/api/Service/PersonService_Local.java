package com.test.api.Service;

import Model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * PersonService_Local class.
 * To manage Person objects thanks to a List.
 *
 * @author Alice B.
 * @version 28/01/2021
 */
@Service
public class PersonService_Local implements PersonService{
    /** The list to manage. */
    List<Person> persons;

    /**
     * Constructor.
     */
    @Autowired
    public PersonService_Local() {
        this.persons = new LinkedList<>();
    }

    /**
     * To add a new Person to the list.
     *
     * @param person The Person to add.
     * @return 0 if the Person could be added, -1 otherwise.
     */
    @Override
    public int insertPerson(Person person) {
        if(person.getId() == null) {
            return insertPerson(person.getName());
        }
        if(!persons.contains(selectPersonById(person.getId()))) {
            this.persons.add(person);
            return 0;
        }
        return -1;
    }

    /**
     * To get all the Person objects added to the list.
     *
     * @return The list of all the Person objects added.
     */
    @Override
    public List<Person> getAllPersons() {
        return this.persons;
    }

    /**
     * To select a Person depending on its ID.
     *
     * @param id The ID corresponding to the Person object requested.
     * @return The Person object if it exists.
     */
    @Override
    public Optional<Person> selectPersonById(UUID id) {
        return persons.stream()
                .filter(person -> person.getId().equals(id))
                .findFirst();
    }

    /**
     * To update the information of a Person object.
     *
     * @param person The new information to update.
     * @return 0 if we could update the info, -1 otherwise (Does the Person object exist ?).
     */
    @Override
    public int updatePersonById(Person person) {
        if(person.getId() != null) {
            if(this.selectPersonById(person.getId()).isPresent()) {
                deletePersonById(person.getId());
                insertPerson(person);
                return 0;
            }
        }
        return -1;
    }

    /**
     * To delete a Person object from the list depending on its ID.
     *
     * @param id The ID of the object to delete.
     * @return 0 if the Person object has been deleted, -1 otherwise (Does the Person object exist ?).
     */
    @Override
    public int deletePersonById(UUID id) {
        Optional<Person> person = selectPersonById(id);
        if(person.isPresent()) {
            if (persons.contains(person.get())) {
                this.persons.remove(person.get());
                return 0;
            }
        }
        return -1;
    }
}
