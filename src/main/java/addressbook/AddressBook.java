package addressbook;


import addressbook.person.Person;

import java.util.Collections;
import java.util.Optional;
import java.util.Set;

import static addressbook.person.Person.Gender;
import static java.util.Comparator.comparing;
import static org.apache.commons.lang3.Validate.notNull;

/**
 * Represents address book: collection of people and utility methods
 */
public class AddressBook {

    final Set<Person> entries;

    public AddressBook(Set<Person> entries) {
        notNull(entries);
        this.entries = Collections.unmodifiableSet(entries);
    }

    /**
     * Calculates how many males are in the address book
     * @return result of calculation
     */
    public long countMales() {
        return entries.stream()
                .filter(person -> Gender.MALE.equals(person.getGender()))
                .count();
    }

    /**
     * Finds the oldest person in the book
     * @return oldest person or empty if book has no entries
     */
    public Optional<Person> getOldestPerson() {
        return entries.stream().max(comparing(Person::getDateOfBirth).reversed());
    }

}
