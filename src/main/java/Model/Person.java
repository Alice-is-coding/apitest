package Model;

import java.util.UUID;

public class Person {
    private final UUID id;
    private final String name;

    public Person(UUID id, String name) {
        this.id = id;
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

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

    @Override
    public int hashCode() {
        return this.id.hashCode() + this.name.hashCode();
    }
}
