package com.test.api.Service;

import Model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PersonService_Local implements PersonService{
    List<Person> persons;

    @Autowired
    public PersonService_Local() {
        this.persons = new LinkedList<>();
    }

    @Override
    public int insertPerson(UUID id, String name) {
        if(!persons.contains(selectPersonById(id))) {
            this.persons.add(new Person(id, name));
            return 0;
        }
        return -1;
    }

    @Override
    public List<Person> getAllPersons() {
        return this.persons;
    }

    @Override
    public Optional<Person> selectPersonById(UUID id) {
        return persons.stream()
                .findFirst()
                .filter(person -> person.getId().equals(id));
    }

    @Override
    public int updatePersonById(UUID id, String name) {
        if(persons.contains(selectPersonById(id))) {
            deletePersonById(id);
            insertPerson(id, name);
            return 0;
        }
        return -1;
    }

    @Override
    public int deletePersonById(UUID id) {
        Optional<Person> person = selectPersonById(id);
        if(persons.contains(person)) {
            this.persons.remove(person);
            return 0;
        }
        return -1;
    }
}
