package com.test.api.Service;

import Model.Person;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * PersonService class.
 * Contract to manage Person objects.
 *
 * @author Alice B.
 * @version 28/01/2021
 */
public interface PersonService {
    /**
     * To add a new Person.
     *
     * @param person The Person to add.
     * @return 0 if everything's OK, -1 otherwise.
     */
    int insertPerson(Person person);

    /**
     * To get all the Person objects added.
     *
     * @return The list of all the Person objects added.
     */
    List<Person> getAllPersons();

    /**
     * To select a Person depending on its ID.
     *
     * @param id The ID corresponding to the Person object requested.
     * @return The Person object if it exists.
     */
    Optional<Person> selectPersonById(UUID id);

    /**
     * To update the information of a Person object.
     *
     * @param person The new information to update.
     * @return 0 if everything's OK, -1 otherwise.
     */
    int updatePersonById(Person person);

    /**
     * To delete a Person object depending on its ID.
     *
     * @param id The ID of the object to delete.
     * @return 0 if everything's OK, -1 otherwise.
     */
    int deletePersonById(UUID id);

    /**
     * Default behavior of this method.
     * If only the name is communicated, we create a random UUID to add a valid Person object.
     *
     * @param name The name of the Person object.
     * @return 0 if everything's OK, -1 otherwise.
     */
    default int insertPerson(String name) {
        insertPerson(new Person(UUID.randomUUID(), name));
        return 0;
    }
}
