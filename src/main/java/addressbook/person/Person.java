package addressbook.person;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Stream;

import static org.apache.commons.lang3.Validate.notNull;

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

    /**
     * Calculates age difference in days
     * @param other candidate person
     * @return result of calculation
     * @throws NullPointerException if other is null
     */
    public long getAgeDifferenceInDays(Person other) {
        notNull(other);
        return Math.abs(ChronoUnit.DAYS.between(this.getDateOfBirth(), other.getDateOfBirth()));
    }

    /*
    getters & setters
     */

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

    /*
    equals & hashCode & toString
     */

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
            notNull(name);

            return Stream.of(Gender.values())
                    .filter(val -> val.name().equalsIgnoreCase(name))
                    .findAny();
        }
    }
}
