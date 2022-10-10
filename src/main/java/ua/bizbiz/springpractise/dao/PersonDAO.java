package ua.bizbiz.springpractise.dao;

import org.springframework.stereotype.Component;
import ua.bizbiz.springpractise.models.Person;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    private static int PEOPLE_COUNT;
    private List<Person> people;

    {
        people = new ArrayList<>();

        people.add(new Person(++PEOPLE_COUNT, "Elliot"));
        people.add(new Person(++PEOPLE_COUNT, "Darlene"));
        people.add(new Person(++PEOPLE_COUNT, "Angela"));
        people.add(new Person(++PEOPLE_COUNT, "Mr.Robot"));
    }

    public List<Person> index() {
        return people;
    }

    public Person show(int id) {
        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }

    public void save(Person person) {
        person.setId(++PEOPLE_COUNT);
        people.add(person);
    }
}
