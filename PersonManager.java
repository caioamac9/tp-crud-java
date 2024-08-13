import java.util.ArrayList;
import java.util.Scanner;

public class PersonManager {
    ArrayList<Person> personList = new ArrayList<>();

    // Create
    public void addPerson(Person person) {
        personList.add(person);
    }

    // Read
    public Person getPersonByName(String name) {
        for (Person person : personList) {
            if (person.getName().equalsIgnoreCase(name)) {
                return person;
            }
        }
        return null;
    }

    // Update
    public boolean updatePerson(String name, Person updatedPerson) {
        for (int i = 0; i < personList.size(); i++) {
            if (personList.get(i).getName().equalsIgnoreCase(name)) {
                personList.set(i, updatedPerson);
                return true;
            }
        }
        return false;
    }

    // Delete
    public boolean deletePerson(String name) {
        return personList.removeIf(person -> person.getName().equalsIgnoreCase(name));
    }
}
