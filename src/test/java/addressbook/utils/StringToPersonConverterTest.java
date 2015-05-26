package addressbook.utils;

import addressbook.person.Person;
import org.junit.Test;

import java.time.LocalDate;
import java.time.Month;

import static addressbook.person.Person.Gender;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class StringToPersonConverterTest {

    @Test
    public void byCommaAndSpaceSeparatorInputOk() {
        Person p = StringToPersonConverter.byCommaAndSpaceSeparator("Bill McKnight, Male, 16/03/88");
        assertNotNull(p);
        assertEquals("Bill McKnight", p.getName());
        assertEquals(Gender.MALE, p.getGender());
        assertEquals(LocalDate.of(1988, Month.MARCH, 16), p.getDateOfBirth());
    }

    @Test
    public void byCommaAndSpaceSeparatorInputOkBornBefore2000() {
        Person p = StringToPersonConverter.byCommaAndSpaceSeparator("Bill McKnight, Male, 01/03/77");
        assertNotNull(p);
        assertEquals(LocalDate.of(1977, Month.MARCH, 01), p.getDateOfBirth());
    }

    @Test
    public void byCommaAndSpaceSeparatorInputOkBornAfter2000() {
        Person p = StringToPersonConverter.byCommaAndSpaceSeparator("Bill McKnight, Male, 16/10/05");
        assertNotNull(p);
        assertEquals(LocalDate.of(2005, Month.OCTOBER, 16), p.getDateOfBirth());
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