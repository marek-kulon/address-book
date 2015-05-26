package addressbook.utils;

import addressbook.person.Person;

import java.util.NoSuchElementException;

import static org.apache.commons.lang3.Validate.isTrue;
import static org.apache.commons.lang3.Validate.notEmpty;

/**
 * Collection of utility methods for converting strings into person
 */
public class StringToPersonConverter {


    /**
     * Converts {@link String} value into {@link Person} object by separating value by comma and space sequence
     * @param value candidate value
     * @return conversion result
     * @throws NullPointerException if value is null
     * @throws IllegalArgumentException if value is empty or value incorrectly formed
     * @throws NoSuchElementException if gender is incorrect
     */
    public static Person byCommaAndSpaceSeparator(String value) {
        notEmpty(value);

        String[] parts = value.split(",\\s");
        isTrue(parts.length == 3);

        return new Person(parts[0], Person.Gender.findByNameIgnoreCase(parts[1]).get(), parts[2]);
    }
}
