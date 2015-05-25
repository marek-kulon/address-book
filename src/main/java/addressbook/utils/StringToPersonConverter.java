package addressbook.utils;

import addressbook.person.Person;

import static org.apache.commons.lang3.Validate.isTrue;
import static org.apache.commons.lang3.Validate.notEmpty;

/**
 * Collection of utility methods for converting strings into person
 */
public class StringToPersonConverter {


    public static Person byCommaAndSpaceSeparator(String value) {
        notEmpty(value);

        String[] parts = value.split(",\\s");
        isTrue(parts.length == 3);

        return new Person(parts[0], parts[1], parts[2]);
    }
}
