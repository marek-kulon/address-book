package addressbook.person;

import org.apache.commons.lang3.Validate;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * Represents entry unit of address book
 */
public class Person {
    private final String firstName;
    private final String lastName;
    private final Gender gender;
    private final LocalDate dateOfBirth;

    public Person(String firstName, String lastName, Gender gender, LocalDate dateOfBirth) {
        this.firstName = firstName;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Gender getGender() {
        return gender;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(firstName, person.firstName) &&
                Objects.equals(lastName, person.lastName) &&
                Objects.equals(gender, person.gender) &&
                Objects.equals(dateOfBirth, person.dateOfBirth);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, gender, dateOfBirth);
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender=" + gender +
                ", dateOfBirth=" + dateOfBirth +
                '}';
    }

    /**
     * Represents gender of person
     */
    public enum Gender {
        MALE, FEMALE;

        /**
         * Finds gender by name regardless of its case
         * @param name candidate value
         * @return found gender or empty value
         */
        public static Optional<Gender> findByNameIgnoreCase(String name) {
            Validate.notNull(name);

            return Stream.of(Gender.values())
                    .filter(val -> val.name().equalsIgnoreCase(name))
                    .findAny();
        }
    }
}
