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

        people.add(new Person(++PEOPLE_COUNT, "Elliot", 26, "elliot@gmail.com"));
        people.add(new Person(++PEOPLE_COUNT, "Darlene", 26, "darlene@gmail.com"));
        people.add(new Person(++PEOPLE_COUNT, "Angela", 26, "angela@gmail.com"));
        people.add(new Person(++PEOPLE_COUNT, "Mr.Robot", 43, "robot@gmail.com"));
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

    public void update(int id, Person updatedPerson) {
        Person personToBeUpdated = show(id);

        personToBeUpdated.setName(updatedPerson.getName());
        personToBeUpdated.setAge(updatedPerson.getAge());
        personToBeUpdated.setEmail(updatedPerson.getEmail());
    }

    public void delete(int id) {
        people.removeIf(p -> p.getId() == id);
    }
}
