package addressbook.person;

import org.junit.Test;

import java.time.LocalDate;

import static addressbook.person.Person.Gender.FEMALE;
import static addressbook.person.Person.Gender.MALE;
import static java.time.Month.APRIL;
import static org.junit.Assert.*;


public class PersonTest {


    @Test
    public void testGetAgeDifferenceInDays() {
        final Person john = new Person("John", "Smith", MALE, LocalDate.of(1985, APRIL, 11));
        final Person paul = new Person("Paul", "Smith", MALE, LocalDate.of(1985, APRIL, 25));
        assertEquals("no difference", 0, john.getAgeDifferenceInDays(john));
        assertEquals("between john and paul", 14, john.getAgeDifferenceInDays(paul));
        assertEquals("between paul and john", 14, paul.getAgeDifferenceInDays(john));
    }

    @Test
    public void testEqualsAndHashCode() throws Exception {
        final Person pOne = new Person("John", "Smith", MALE, LocalDate.of(1985, APRIL, 11));
        final Person pTwo = new Person("John", "Smith", MALE, LocalDate.of(1985, APRIL, 11));
        final Person pThree = new Person("John", "Smith", MALE, LocalDate.of(1985, APRIL, 11));

        /*
         equals
          */
        assertFalse("equals: null", pOne.equals(null));
        assertTrue("equals: is reflexive", pOne.equals(pOne));
        assertTrue("equals: is symmetric", pOne.equals(pTwo) && pTwo.equals(pOne));
        assertTrue("equals: is transitive", pOne.equals(pTwo) && pTwo.equals(pThree) && pOne.equals(pThree));
        assertTrue("equals: is consistent", pOne.equals(pTwo) && pOne.equals(pTwo));

        assertFalse("different first names", pOne.equals(new Person("Paul", "Smith", MALE, LocalDate.of(1985, APRIL, 11))));
        assertFalse("different last names", pOne.equals(new Person("John", "Braun", MALE, LocalDate.of(1985, APRIL, 11))));
        assertFalse("different genders", pOne.equals(new Person("John", "Smith", FEMALE, LocalDate.of(1985, APRIL, 11))));
        assertFalse("different dob", pOne.equals(new Person("John", "Smith", MALE, LocalDate.of(1986, APRIL, 11))));

        /*
        hashCode
         */
        assertEquals(pOne.hashCode(), pThree.hashCode());
    }
}