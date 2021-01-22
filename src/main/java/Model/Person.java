package Model;

import java.util.UUID;

/**
 * Person.
 *
 * @author Alice B.
 * @version 22/01/2021
 */
public class Person {
    /** The id of the object. */
    private final UUID id;
    /** The name of the object. */
    private final String name;

    /**
     * Constructor.
     *
     * @param id UUID (id) of the Person object.
     * @param name The name given to the Person object.
     */
    public Person(UUID id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * ID getter.
     *
     * @return The id of the object.
     */
    public UUID getId() {
        return id;
    }

    /**
     * Name getter.
     *
     * @return The name of the object.
     */
    public String getName() {
        return name;
    }

    /**
     * To know if the object passed in param is equal to the actual object.
     * To be equal they should : have the same id && have the same name.
     *
     * @param o The object to compare. (Should be a Person object).
     * @return true if o is equal to the actual object, false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if(o instanceof Person) {
            Person p = (Person)o;
            if ((p.getId().equals(this.getId())) && (p.getName().equals(this.getName()))) {
                return true;
            }
            return false;
        }
        return false;
    }

    /**
     * Returns the hasCode which is an addition of the id's hashcode and the name's hashcode.
     *
     * @return The hashcode of the object.
     */
    @Override
    public int hashCode() {
        return this.id.hashCode() + this.name.hashCode();
    }
}
