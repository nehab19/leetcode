package guru.springframework.spring5webapp.leetcode.Arrays;

import java.util.Objects;

class Person {
    String name;
    int id;

    public Person(String name, int id) {
        this.name = name;
        this.id = id;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Person person = (Person) obj;
        return id == person.id && name.equals(person.name);  // Logical equality
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id);  // Ensure hashCode consistency
    }
}

public class Main {
    public static void main(String[] args) {
        Person p1 = new Person("Alice", 1);
        Person p2 = new Person("Bob", 1);

        System.out.println(p1.equals(p2));  // Output: true
    }
}