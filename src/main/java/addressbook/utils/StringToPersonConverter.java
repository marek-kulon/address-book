package addressbook.utils;

import addressbook.person.Person;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import static org.apache.commons.lang3.Validate.isTrue;
import static org.apache.commons.lang3.Validate.notEmpty;

/**
 * Collection of utility methods for converting strings into person
 */
public class StringToPersonConverter {

    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yy");


    /**
     * Converts {@link String} value into {@link Person} object by separating value by comma and space sequence
     *
     * @param value candidate value
     * @return conversion result
     * @throws NullPointerException     if value is null
     * @throws IllegalArgumentException if value is empty or value incorrectly formed
     * @throws DateTimeParseException   if the date of birth cannot be parsed
     */
    public static Person byCommaAndSpaceSeparator(String value) {
        notEmpty(value);

        String[] parts = value.split(",\\s");
        isTrue(parts.length == 3);

        final String[] fullNameParts = parts[0].split("\\s");
        isTrue(fullNameParts.length == 2);

        final String firstName = fullNameParts[0];
        final String lastName = fullNameParts[1];
        final Person.Gender gender = Person.Gender.findByNameIgnoreCase(parts[1]).orElseThrow(() -> new IllegalArgumentException("invalid gender"));
        final LocalDate dobRow = LocalDate.parse(parts[2], DATE_TIME_FORMATTER);

        return new Person(
                firstName,
                lastName,
                gender,
                dobRow.isBefore(LocalDate.now()) ? dobRow : dobRow.minusYears(100) // making sure person is born in the past
        );
    }
}
