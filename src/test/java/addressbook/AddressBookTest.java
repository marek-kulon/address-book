package addressbook;

import addressbook.person.Person;
import com.google.common.collect.Sets;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.time.LocalDate;

import static addressbook.person.Person.Gender.FEMALE;
import static addressbook.person.Person.Gender.MALE;
import static java.time.Month.APRIL;

public class AddressBookTest {

    private Person john;
    private Person alice;
    private Person robert;

    @Before
    public void setUp() {
        john = new Person("John", "Smith", MALE, LocalDate.of(1985, APRIL, 11));
        alice = new Person("Alica", "Smith", FEMALE, LocalDate.of(1985, APRIL, 11));
        robert = new Person("Robert", "Smith", MALE, LocalDate.of(1985, APRIL, 11));

    }

    @Test
    public void testCountMales() {
        AddressBook addressBookNoMales = new AddressBook(Sets.newHashSet(alice));
        assertEquals(0, addressBookNoMales.countMales());

        AddressBook addressBookFemale2Males = new AddressBook(Sets.newHashSet(john, alice, robert));
        assertEquals(2, addressBookFemale2Males.countMales());
    }
}