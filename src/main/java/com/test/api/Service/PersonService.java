package com.test.api.Service;

import Model.Person;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PersonService {
    int insertPerson(UUID id, String name);
    List<Person> getAllPersons();
    Optional<Person> selectPersonById(UUID id);
    int updatePersonById(UUID id, String name);
    int deletePersonById(UUID id);

    default int insertPerson(String name) {
        insertPerson(UUID.randomUUID(), name);
        return 1;
    }
}
