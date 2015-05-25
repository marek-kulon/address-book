package addressbook.utils;

import addressbook.person.Person;
import org.junit.Test;

import static org.junit.Assert.*;

public class StringToPersonConverterTest {

    @Test
    public void byCommaAndSpaceSeparatorInputOk() {
        Person p = StringToPersonConverter.byCommaAndSpaceSeparator("Bill McKnight, Male, 16/03/77");
        assertNotNull(p);
        assertEquals("Bill McKnight", p.getName());
        assertEquals("Male", p.getGender());
        assertEquals("16/03/77", p.getDateOfBirth());
    }

    @Test(expected = NullPointerException.class)
    public void byCommaAndSpaceSeparatorNullInput() {
        StringToPersonConverter.byCommaAndSpaceSeparator(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void byCommaAndSpaceSeparatorIncorrectInput() {
        StringToPersonConverter.byCommaAndSpaceSeparator("Bill McKnight, Male");
    }
}