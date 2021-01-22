package apiTests.Model;

import Model.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests class for Person class (src/main/java/Model).
 *
 * @author Alice B.
 * @version 22/01/2021
 */
class PersonTests {

    @BeforeEach
    void setUp() {
    }

    @Test
    void getId() {
        UUID id = UUID.randomUUID();
        Person person = new Person(id, "John Smith");

        assertTrue(person.getId() instanceof UUID);
        Assert.isTrue(id.equals(person.getId()), "IDs should be equals...");
    }

    @Test
    void getName() {
        UUID id = UUID.randomUUID();
        Person person = new Person(id, "Gal Gadot");

        assertTrue(person.getName() instanceof String);
        Assert.isTrue(person.getName().equals("Gal Gadot"), "The names aren't the same...");
    }

    @Test
    void testEquals() {
        UUID id = UUID.randomUUID();
        Person person = new Person(id, "Taylor Swift");

        id = UUID.randomUUID();
        Person person1 = new Person(id, "Jeremy Sumpter");
        Person person2 = new Person(id, "Jeremy Sumpter");

        Assert.isTrue(person.equals(person), "The Person object should be equals to itself...");
        Assert.isTrue(person1.equals(person1), "The Person object should be equals to itself...");
        assertFalse(person.equals(person1), "The 2 Person objects compared shouldn't be equal...");
        assertTrue(person1.equals(person2), "The 2 Person objects compared should be equal...");
    }
}