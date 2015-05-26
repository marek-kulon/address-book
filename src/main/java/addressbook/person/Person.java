package addressbook.person;

import org.apache.commons.lang3.Validate;

import java.util.Optional;
import java.util.stream.Stream;

public class Person {
    private final String name;
    private final Gender gender;
    private final String dateOfBirth;

    public Person(String name, Gender gender, String dateOfBirth) {
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Gender getGender() {
        return gender;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
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
