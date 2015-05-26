package addressbook;

import addressbook.person.Person;
import addressbook.utils.FileUtils;
import addressbook.utils.StringToPersonConverter;

import java.util.Optional;
import java.util.Set;

import static java.util.stream.Collectors.toSet;

public class Main {

    public static void main(String[] args) {
        Set<Person> entries = FileUtils.readLines("AddressBook").stream()
                .map(StringToPersonConverter::byCommaAndSpaceSeparator)
                .collect(toSet());

        final AddressBook addressBook = new AddressBook(entries);

        // question no 1.
        System.out.println("Number of males in the address book: "+addressBook.countMales());

        // question no 2.
        String oldestPersonStr = addressBook.getOldestPerson()
                .map(person -> person.getFirstName() + " " + person.getLastName())
                .orElse("not found");
        System.out.println("Oldest person in the address book: "+oldestPersonStr);

        // question no 3.
        Optional<Person> bill = addressBook.findAnyByFirstName("Bill");
        Optional<Person> paul = addressBook.findAnyByFirstName("Paul");

        Optional<Long> ageDifference = bill.isPresent() && paul.isPresent() ?
                Optional.of(bill.get().getAgeDifferenceInDays(paul.get())) :
                Optional.empty();

        String ageDifferenceStr = ageDifference
                .map(String::valueOf)
                .orElse("undefined");

        System.out.println("Age difference in days between Bill and Paul: "+ageDifferenceStr);
    }
}
