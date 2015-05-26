package addressbook;

import addressbook.person.Person;
import com.google.common.collect.Sets;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.Optional;

import static addressbook.person.Person.Gender.FEMALE;
import static addressbook.person.Person.Gender.MALE;
import static java.time.Month.APRIL;
import static org.junit.Assert.assertEquals;

public class AddressBookTest {

    private Person john;
    private Person alice;
    private Person robert;

    @Before
    public void setUp() {
        john = new Person("John", "Smith", MALE, LocalDate.of(1985, APRIL, 11));
        alice = new Person("Alice", "Smith", FEMALE, LocalDate.of(1986, APRIL, 11));
        robert = new Person("Robert", "Smith", MALE, LocalDate.of(1975, APRIL, 11));

    }

    @Test
    public void testCountMales() {
        AddressBook addressBookNoMales = new AddressBook(Sets.newHashSet(alice));
        assertEquals(0, addressBookNoMales.countMales());

        AddressBook addressBookFemale2Males = new AddressBook(Sets.newHashSet(john, alice, robert));
        assertEquals(2, addressBookFemale2Males.countMales());
    }

    @Test
    public void testGetOldestPersonEntriesInTheBook() {
        AddressBook addressBook = new AddressBook(Sets.newHashSet(john, alice, robert));
        assertEquals(Optional.of(robert), addressBook.getOldestPerson());
    }
    @Test
    public void testGetOldestPersonEmptyBook() {
        AddressBook addressBook = new AddressBook(Sets.newHashSet());
        assertEquals(Optional.empty(), addressBook.getOldestPerson());
    }

    @Test
    public void testFindAnyByFirstNameOk() {
        AddressBook addressBook = new AddressBook(Sets.newHashSet(john, alice, robert));
        assertEquals(Optional.of(robert), addressBook.findAnyByFirstName("Robert"));
    }

    @Test
    public void testFindAnyByFirstNameNotFound() {
        AddressBook addressBook = new AddressBook(Sets.newHashSet(john, alice, robert));
        assertEquals(Optional.empty(), addressBook.findAnyByFirstName("xyz"));
    }


}