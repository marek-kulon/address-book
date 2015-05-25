package addressbook.person;

import org.junit.Test;

import java.util.Optional;

import static addressbook.person.Person.*;
import static org.junit.Assert.*;


public class GenderTest {

    @Test
    public void testFindByNameIgnoreCaseValueFound() {
        assertEquals(Optional.of(Gender.FEMALE), Gender.findByNameIgnoreCase("fEmAle"));
        assertEquals(Optional.of(Gender.MALE), Gender.findByNameIgnoreCase("MalE"));
    }

    @Test
    public void testFindByNameIgnoreCaseValueNotFound() {
        assertEquals(Optional.empty(), Gender.findByNameIgnoreCase("xyz"));
    }

    @Test(expected = NullPointerException.class)
    public void testFindByNameIgnoreCaseNullValue() {
        Gender.findByNameIgnoreCase(null);
    }
}